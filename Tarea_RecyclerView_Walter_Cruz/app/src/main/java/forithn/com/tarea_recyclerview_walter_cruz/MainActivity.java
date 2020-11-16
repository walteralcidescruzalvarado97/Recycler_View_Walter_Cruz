package forithn.com.tarea_recyclerview_walter_cruz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.adaptadores.Adaptador;
import forithn.com.tarea_recyclerview_walter_cruz.adaptadores.AdaptadorFragment;
import forithn.com.tarea_recyclerview_walter_cruz.fragments.FragmentListaPerros;
import forithn.com.tarea_recyclerview_walter_cruz.fragments.FragmentPerfilPerro;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public class MainActivity extends AppCompatActivity {

    private Toolbar actionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = (Toolbar) findViewById(R.id.actionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        iniciarFragments();


        if(actionBar != null){
            setSupportActionBar(actionBar);
        }
    }

    //*******************************MENU DE OPCIONES**********************************

    //Sobre escribimos el Metodo onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflamos el Menu con el Menu de Opciones que acabamos de crear
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ){
            case R.id.mContacto:
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                Intent intent_dos = new Intent(this, AcercaDe.class);
                startActivity(intent_dos);
                break;

            case R.id.mEstrella:
                Intent intent_tres = new Intent(this, DetalleMascota.class);
                startActivity(intent_tres);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList< Fragment > fragments = new ArrayList<>();

        //Se Cargan los Fragments
        fragments.add(new FragmentListaPerros());
        fragments.add(new FragmentPerfilPerro());

        //Se Retornan los Fragments
        return fragments;
    }

    private void iniciarFragments(){
        viewPager.setAdapter(new AdaptadorFragment( getSupportFragmentManager(), agregarFragments() ));
        tabLayout.setupWithViewPager( viewPager );

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_perros);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil_perro);
    }

}