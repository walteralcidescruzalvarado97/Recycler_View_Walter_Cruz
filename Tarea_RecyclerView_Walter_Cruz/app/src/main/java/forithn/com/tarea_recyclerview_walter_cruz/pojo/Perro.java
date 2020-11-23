package forithn.com.tarea_recyclerview_walter_cruz.pojo;

public class Perro {

    private int id;
    private int foto;
    private String nombre;
    private int cantLike;

    //Constructor
    public Perro(int foto, String nombre, int cantLike) {
        this.foto = foto;
        this.nombre = nombre;
        this.cantLike = cantLike;
    }

    //Constructor Vacio Necesario para Almacenar los Datos de los Perros
    public Perro() {

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantLike() {
        return cantLike;
    }

    public void setCantLike(int cantLike) {
        this.cantLike = cantLike;
    }

}
