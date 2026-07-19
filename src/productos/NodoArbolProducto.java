package productos;

public class NodoArbolProducto {

    private Producto producto;
    private NodoArbolProducto izquierdo;
    private NodoArbolProducto derecho;

    public NodoArbolProducto(Producto producto) {
        this.producto = producto;
        izquierdo = null;
        derecho = null;
    }

    //Getter
    public Producto getProducto() {
        return producto;
    }

    public NodoArbolProducto getIzquierdo() {
        return izquierdo;
    }

    public NodoArbolProducto getDerecho() {
        return derecho;
    }

    //Setter
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
