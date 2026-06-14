package productos;

import java.util.ArrayList;

public class Producto {

    // Atributos
    private String nombre;
    private double precio;
    private String categoria;
    private String fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;

    // Metodos
    // Constructor
    public Producto(String nombre, double precio, String categoria, String fechaVencimiento, int cantidad) {

        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;

        listaImagenes = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Operaciones
    public void agregarImagen(String rutaImagen) {
        listaImagenes.add(rutaImagen);
    }

    // toString()
    public String toString() {
        return "Nombre: " + nombre +
                "\nPrecio: " + precio +
                "\nCategoria: " + categoria +
                "\nFecha de vencimiento: " + fechaVencimiento +
                "\nCantidad: " + cantidad +
                "\nImagenes: " + listaImagenes + "\n";
    }
}