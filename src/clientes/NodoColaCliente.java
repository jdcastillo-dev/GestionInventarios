package clientes;
public class NodoColaCliente {

    // Atributos
    private Cliente cliente;
    private NodoColaCliente siguiente;

    // Metodos
    // Constructor
    public NodoColaCliente(Cliente cliente) {
        this.cliente = cliente;
        siguiente = null;
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }

    public NodoColaCliente getSiguiente() {
        return siguiente;
    }

    // Setters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSiguiente(NodoColaCliente siguiente) {
        this.siguiente = siguiente;
    }

    // toString()
    public String toString() {
        return cliente.toString();
    }
}