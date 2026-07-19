package clientes;

import productos.ListaProductos;

public class Cliente {

    // Atributos
    private String nombre;
    private int prioridad;
    private ListaProductos carrito;

    // Metodos
    // Constructor
    public Cliente(String nombre, int prioridad) {

        this.nombre = nombre;
        this.prioridad = prioridad;

        carrito = new ListaProductos();
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

    // toString()
    public String toString() {
        return "Nombre: " + nombre +
                "\nPrioridad: " + prioridad + "\n";
    }
}