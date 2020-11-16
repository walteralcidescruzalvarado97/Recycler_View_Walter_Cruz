package forithn.com.tarea_recyclerview_walter_cruz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.adaptadores.Adaptador;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public class DetalleMascota extends AppCompatActivity {

    ArrayList<Perro> perros;
    private RecyclerView rvPerroSeguido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);

        Toolbar actionBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvPerroSeguido = (RecyclerView) findViewById(R.id.rvPerroSeguido);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvPerroSeguido.setLayoutManager(llm);
        iniciarPerros();
        inicializarAdaptador();
    }

    public void iniciarPerros(){
        perros = new ArrayList< Perro >();

        perros.add(new Perro(R.drawable.perro_nueve, "Apolo", "5"));
        perros.add(new Perro(R.drawable.perro_ocho, "Zeus", "5"));
        perros.add(new Perro(R.drawable.perro_dos, "Dido", "4"));
        perros.add(new Perro(R.drawable.perro_seis, "Scott", "3"));
        perros.add(new Perro(R.drawable.perro_siete, "Pelusa", "2"));

    }

    public void inicializarAdaptador(){
        Adaptador adaptador = new Adaptador(perros, this);

        rvPerroSeguido.setAdapter(adaptador);
    }
}