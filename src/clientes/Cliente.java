package clientes;

import productos.ListaProductos;

public class Cliente {

    // Atributos
    private String nombre;
    private int prioridad;
    private ListaProductos carrito;
    private String ubicacion;

    // Metodos

    // Constructor
    public Cliente(String nombre, int prioridad, ListaProductos carrito, String ubicacion) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        carrito = new ListaProductos();
        this.ubicacion = ubicacion;
    }


    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public ListaProductos getCarrito() {
        return carrito;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setCarrito(ListaProductos carrito) {
        this.carrito = carrito;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // toString()
    public String toString() {
        return "Nombre: " + nombre +
                "\nPrioridad: " + prioridad
                + "\nUbicación: " + ubicacion + "\n";
    }
}