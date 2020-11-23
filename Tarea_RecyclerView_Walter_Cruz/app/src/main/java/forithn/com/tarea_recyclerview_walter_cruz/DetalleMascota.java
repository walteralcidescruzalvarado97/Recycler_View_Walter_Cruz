package forithn.com.tarea_recyclerview_walter_cruz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.adaptadores.Adaptador;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;
import forithn.com.tarea_recyclerview_walter_cruz.presentador.DetalleMascota_Presentador;
import forithn.com.tarea_recyclerview_walter_cruz.presentador.IDetalleMascota_Presentador;

public class DetalleMascota extends AppCompatActivity implements IDetalleMascota {

    ArrayList<Perro> perros;
    private RecyclerView rvPerroSeguido;

    private IDetalleMascota_Presentador iDetalleMascota_presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);

        Toolbar actionBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvPerroSeguido = (RecyclerView) findViewById(R.id.rvPerroSeguido);


        iDetalleMascota_presentador = new DetalleMascota_Presentador(this, this );
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvPerroSeguido.setLayoutManager(llm);
    }

    @Override
    public Adaptador crearAdaptador(ArrayList<Perro> perros) {
        Adaptador adaptador = new Adaptador(perros, this);

        return adaptador;
    }

    @Override
    public void inicializarAdaptador(Adaptador adaptador) {
        rvPerroSeguido.setAdapter(adaptador);
    }
}