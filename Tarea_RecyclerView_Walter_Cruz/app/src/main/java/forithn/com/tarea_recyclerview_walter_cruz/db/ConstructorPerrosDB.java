package forithn.com.tarea_recyclerview_walter_cruz.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.R;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public class ConstructorPerrosDB {
    private Context context;

    public ConstructorPerrosDB(Context context) {
        this.context = context;
    }

    public ArrayList< Perro > obtenerDatos(){

        BaseDatos db = new BaseDatos(context);

        return db.obtenerPerrosLike();
    }

    public void insertarPerroDB(Perro perro){
        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();

        contentValues.put( ConstantesDB.TABLE_MASCOTA_NOMBRE, perro.getNombre() );
        contentValues.put( ConstantesDB.TABLE_MASCOTA_FOTO, perro.getFoto() );
        contentValues.put( ConstantesDB.TABLE_MASCOTA_CANT_LIKES, 1 );

        db.insertarPerro(contentValues);
    }

    public int obtenerLikePerro(String nombre){
        BaseDatos db = new BaseDatos(context);

        return db.obtenerLikePerro( nombre );
    }
}
