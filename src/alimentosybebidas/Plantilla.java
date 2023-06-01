package alimentosybebidas;

public class Plantilla {
    private String nombre;
    private String descripcion;
    private double precio;
    private int disponibles;

    public Plantilla(String nombre, String descripcion, double precio,int disponibles) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibles = disponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public double getPrecio() {
        return precio;
    }
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\n" + " Descripcion: " + descripcion + "\n" + " Precio: " + precio + "\n"
                + " Disponibles: " + disponibles;
    }
}
