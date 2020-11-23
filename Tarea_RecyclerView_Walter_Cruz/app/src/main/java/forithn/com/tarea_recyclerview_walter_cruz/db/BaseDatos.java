package forithn.com.tarea_recyclerview_walter_cruz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesDB.DATABASE_NAME, null, ConstantesDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesDB.TABLE_MASCOTA + " ( " +
                                        ConstantesDB.TABLE_MASCOTA_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesDB.TABLE_MASCOTA_NOMBRE       + " TEXT, " +
                                        ConstantesDB.TABLE_MASCOTA_FOTO         + " INTEGER," +
                                        ConstantesDB.TABLE_MASCOTA_CANT_LIKES   + " INTEGER )";

        db.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Se Eliminan las Tablas en caso de haber realizado algun cambio en Ellas y se vuelven a crear
        db.execSQL( "DROP TABLE IF EXISTS " + ConstantesDB.TABLE_MASCOTA );

        onCreate(db);
    }

    public ArrayList< Perro > obtenerPerrosLike(){
        ArrayList< Perro > perros = new ArrayList<>();

        String queyPerros = "SELECT * " +
                            "FROM " + ConstantesDB.TABLE_MASCOTA +
                            " ORDER BY " + ConstantesDB.TABLE_MASCOTA_CANT_LIKES + " DESC" +
                            " LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registrosDB = db.rawQuery(queyPerros, null);

        while( registrosDB.moveToNext() ){

            Perro perroActual = new Perro();

            perroActual.setId( registrosDB.getInt(0) );
            perroActual.setNombre( registrosDB.getString(1) );
            perroActual.setFoto( registrosDB.getInt(2) );
            perroActual.setCantLike( registrosDB.getInt(3) );

            perros.add( perroActual );
        }

        db.close();

        return perros;
    }

    public void insertarPerro(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();

        int likes = 0;

        String queryLikePerro = "SELECT " + ConstantesDB.TABLE_MASCOTA_CANT_LIKES +
                                " FROM "  + ConstantesDB.TABLE_MASCOTA +
                                " WHERE " + ConstantesDB.TABLE_MASCOTA_NOMBRE + " = '" + contentValues.getAsString(ConstantesDB.TABLE_MASCOTA_NOMBRE) + "'";

        Cursor registrosDB = db.rawQuery(queryLikePerro, null);

        if( registrosDB.moveToNext() ){
            likes = registrosDB.getInt(0);
        }

        if(likes > 0){
            likes += 1;

            String querryActualizarLikes = "UPDATE " + ConstantesDB.TABLE_MASCOTA +
                                           " SET "  + ConstantesDB.TABLE_MASCOTA_CANT_LIKES + " = " + likes +
                                           " WHERE " + ConstantesDB.TABLE_MASCOTA_NOMBRE + " = '" + contentValues.getAsString(ConstantesDB.TABLE_MASCOTA_NOMBRE) + "'";

            db.execSQL(querryActualizarLikes);
        }else{
            db.insert(ConstantesDB.TABLE_MASCOTA, null, contentValues);
        }

        db.close();
    }

    public int obtenerLikePerro(String nombre){
        int likes = 0;

        String queryLikePerro = "SELECT " + ConstantesDB.TABLE_MASCOTA_CANT_LIKES +
                                " FROM "  + ConstantesDB.TABLE_MASCOTA +
                                " WHERE " + ConstantesDB.TABLE_MASCOTA_NOMBRE + " = '" + nombre + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registrosDB = db.rawQuery(queryLikePerro, null);

        if( registrosDB.moveToNext() ){
            likes = registrosDB.getInt(0);
        }

        db.close();

        return likes;
    }

}
