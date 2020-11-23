package forithn.com.tarea_recyclerview_walter_cruz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.R;
import forithn.com.tarea_recyclerview_walter_cruz.adaptadores.Adaptador;
import forithn.com.tarea_recyclerview_walter_cruz.db.ConstructorPerrosDB;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public class FragmentListaPerros extends Fragment {

    ArrayList<Perro> perros;
    private RecyclerView rvPerro;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lista_perros_fragment, container, false);


        rvPerro = (RecyclerView) v.findViewById(R.id.rvPerro);

        LinearLayoutManager llm = new LinearLayoutManager( getActivity() );
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvPerro.setLayoutManager(llm);
        iniciarPerros();
        inicializarAdaptador();

        return v;
    }

    public void iniciarPerros(){
        perros = new ArrayList< Perro >();

        ConstructorPerrosDB constructorPerrosDB = new ConstructorPerrosDB( getContext() );

        perros.add(new Perro(R.drawable.perro_nueve, "Apolo", constructorPerrosDB.obtenerLikePerro( "Apolo" ) ));
        perros.add(new Perro(R.drawable.perro_cuatro, "Kaiser", constructorPerrosDB.obtenerLikePerro( "Kaiser" ) ));
        perros.add(new Perro(R.drawable.perro_ocho, "Zeus", constructorPerrosDB.obtenerLikePerro( "Zeus" ) ));
        perros.add(new Perro(R.drawable.perro_cinco, "Polo", constructorPerrosDB.obtenerLikePerro( "Polo" ) ));
        perros.add(new Perro(R.drawable.perro_dos, "Dido", constructorPerrosDB.obtenerLikePerro( "Dido" ) ));
        perros.add(new Perro(R.drawable.perro_tres, "Fido", constructorPerrosDB.obtenerLikePerro( "Fido" ) ));
        perros.add(new Perro(R.drawable.perro_seis, "Rocky", constructorPerrosDB.obtenerLikePerro( "Rocky" ) ));
        perros.add(new Perro(R.drawable.perro_siete, "Pelusa", constructorPerrosDB.obtenerLikePerro( "Pelusa" ) ));
    }

    public void inicializarAdaptador(){
        Adaptador adaptador = new Adaptador( perros, getActivity() );

        rvPerro.setAdapter(adaptador);
    }

}
