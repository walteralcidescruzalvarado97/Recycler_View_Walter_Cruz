package forithn.com.tarea_recyclerview_walter_cruz;

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

public class Adaptador extends RecyclerView.Adapter< Adaptador.PerroViewHolder > {

    ArrayList< Perro > perros;
    Activity activity;

    public Adaptador(ArrayList< Perro > perros, Activity activity){
        this.perros = perros;
        this.activity = activity;
    }

    //Nos ayuda a inflar el Layout y lo pasará al ViewHolder para que obtenga los datos del Arreglo
    @NonNull
    @Override
    public PerroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new PerroViewHolder(v);
    }

    //Asocia cada elemento de la Nuestra lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerroViewHolder perroViewHolder, int position) {
        final Perro perro = perros.get(position);

        perroViewHolder.imgPerro.setImageResource( perro.getFoto() );
        perroViewHolder.tvCVNombrePerro.setText( perro.getNombre() );
        perroViewHolder.tvCVCantidadLikePerro.setText( perro.getCantLike() );

        perroViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast para el Boton de Like
                Toast.makeText(activity, "Se ha vuelto Seguidor de " + perro.getNombre() + "!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Cantidad de Elementos que contiene la Lista de Perros
    @Override
    public int getItemCount() {
        return perros.size();
    }

    public static class PerroViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPerro;
        private TextView tvCVNombrePerro;
        private TextView tvCVCantidadLikePerro;
        private ImageButton btnLike;


        public PerroViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPerro                = (ImageView) itemView.findViewById( R.id.imgPerro );
            tvCVNombrePerro         = (TextView) itemView.findViewById( R.id.tvCVNombrePerro );
            tvCVCantidadLikePerro   = (TextView) itemView.findViewById( R.id.tvCVCantidadLikePerro );
            btnLike                 = (ImageButton) itemView.findViewById( R.id.btnLike );
        }
    }
}
