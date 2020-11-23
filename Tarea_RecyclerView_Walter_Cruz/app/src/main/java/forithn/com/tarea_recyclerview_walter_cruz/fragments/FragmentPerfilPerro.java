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
import forithn.com.tarea_recyclerview_walter_cruz.adaptadores.PerfilPerroAdaptador;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public class FragmentPerfilPerro extends Fragment {

    ArrayList<Perro> perros;
    private RecyclerView rvPerroPerfil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.perfil_perro_fragment, container, false);


        rvPerroPerfil = (RecyclerView) v.findViewById(R.id.rvPerroPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);

        rvPerroPerfil.setLayoutManager(glm);
        iniciarPerros();
        inicializarAdaptadorPerfilPerro();

        return v;
    }

    public void iniciarPerros(){
        perros = new ArrayList< Perro >();

        perros.add(new Perro(R.drawable.perro_nueve, "Dido", 5));
        perros.add(new Perro(R.drawable.perrro_uno, "Apolo", 5));
        perros.add(new Perro(R.drawable.perro_diez, "Fido", 4));
        perros.add(new Perro(R.drawable.perro_once, "Kaiser", 3));
    }

    public void inicializarAdaptadorPerfilPerro(){
        PerfilPerroAdaptador adaptador = new PerfilPerroAdaptador( perros, getActivity() );

        rvPerroPerfil.setAdapter(adaptador);
    }
}
