package productos;

public class NodoArbolProducto {

    // Atributos
    private Producto producto;
    private NodoArbolProducto izquierdo;
    private NodoArbolProducto derecho;

    // Metodos
    // Constructor
    public NodoArbolProducto(Producto producto) {
        this.producto = producto;
        izquierdo = null;
        derecho = null;
    }

    // Getters
    public Producto getProducto() {
        return producto;
    }

    public NodoArbolProducto getIzquierdo() {
        return izquierdo;
    }

    public NodoArbolProducto getDerecho() {
        return derecho;
    }

    // Setters
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setIzquierdo(NodoArbolProducto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbolProducto derecho) {
        this.derecho = derecho;
    }
}
