package forithn.com.tarea_recyclerview_walter_cruz.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.R;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public class PerfilPerroAdaptador extends RecyclerView.Adapter< PerfilPerroAdaptador.PerroViewHolder > {

    ArrayList<Perro> perros;
    Activity activity;

    public PerfilPerroAdaptador(ArrayList< Perro > perros, Activity activity){
        this.perros = perros;
        this.activity = activity;
    }

    //Nos ayuda a inflar el Layout y lo pasará al ViewHolder para que obtenga los datos del Arreglo
    @NonNull
    @Override
    public PerroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_dos, parent, false);

        return new PerroViewHolder(v);
    }

    //Asocia cada elemento de la Nuestra lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerroViewHolder perroViewHolder, int position) {

        final Perro perro = perros.get(position);

        perroViewHolder.imgPerroDos.setImageResource( perro.getFoto() );
        perroViewHolder.tvCVDosCantidadLikePerro.setText( String.valueOf( perro.getCantLike() ) );
    }

    //Cantidad de Elementos que contiene la Lista de Perros
    @Override
    public int getItemCount() {
        return perros.size();
    }

    public static class PerroViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPerroDos;
        private TextView tvCVDosCantidadLikePerro;

        public PerroViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPerroDos                = (ImageView) itemView.findViewById( R.id.imgPerroDos );
            tvCVDosCantidadLikePerro   = (TextView) itemView.findViewById( R.id.tvCVDosCantidadLikePerro );
        }
    }

}
