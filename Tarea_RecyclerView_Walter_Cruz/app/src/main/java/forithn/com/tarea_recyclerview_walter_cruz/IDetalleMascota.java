package forithn.com.tarea_recyclerview_walter_cruz;

import java.util.ArrayList;

import forithn.com.tarea_recyclerview_walter_cruz.adaptadores.Adaptador;
import forithn.com.tarea_recyclerview_walter_cruz.pojo.Perro;

public interface IDetalleMascota {

    public void generarLinearLayoutVertical();

    public Adaptador crearAdaptador( ArrayList< Perro > perros );

    public void inicializarAdaptador(Adaptador adaptador);

}
