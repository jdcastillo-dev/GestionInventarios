package productos;

public class ArbolProductos {

    // Atributo
    private NodoArbolProducto raiz;

    // Metodos
    // Constructor
    public ArbolProductos() {
        raiz = null; }

    // Verifica si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null; }

    // Inserta un producto en el árbol
    public boolean insertar(Producto producto) {
        if (producto == null) {
            return false; }
        if (raiz == null) {
            raiz = new NodoArbolProducto(producto);
            return true; }
        return insertarRecursivo(raiz, producto); }

    // Inserta un producto en la posición correspondiente del árbol
    private boolean insertarRecursivo(NodoArbolProducto actual, Producto producto) {
        int comparacion = producto.getNombre()
                .compareToIgnoreCase(actual.getProducto().getNombre());

        if (comparacion == 0) {
            System.out.println("El producto ya existe en el inventario :)");
            return false;
        }
        if (comparacion < 0) {

            if (actual.getIzquierdo() == null) {
                actual.setIzquierdo(new NodoArbolProducto(producto));
                return true;
            }
            return insertarRecursivo(actual.getIzquierdo(), producto);  }

        else {
            if (actual.getDerecho() == null) {
                actual.setDerecho(
                        new NodoArbolProducto(producto) );
                return true; }
            return insertarRecursivo( actual.getDerecho(), producto );
        }
    }

    // Busca un producto por su nombre
    public Producto buscar(String nombre) {

        NodoArbolProducto resultado = buscarRecursivo(raiz, nombre);
        if (resultado == null) {

            System.out.println("Producto no encontrado :(");
            return null;
        }
        return resultado.getProducto();
    }

    // Busca un producto de forma recursiva
    private NodoArbolProducto buscarRecursivo(NodoArbolProducto actual, String nombre) {
        if (actual == null) {
            return null;
        }
        int comparacion = nombre.compareToIgnoreCase(actual.getProducto().getNombre());

        if (comparacion == 0) {
            return actual; }

        if (comparacion < 0) {
            return buscarRecursivo(actual.getIzquierdo(), nombre);
        }

        return buscarRecursivo(actual.getDerecho(), nombre);
    }

    // Muestra los productos utilizando el recorrido InOrden
    public void mostrarInOrden() {

        if (raiz == null) {
            System.out.println("El inventario está vacío :(");
            return;
        }

        inOrden(raiz);
    }

    // Recorre el árbol en InOrden
    private void inOrden(NodoArbolProducto nodo) {

        if (nodo != null) {
            inOrden(nodo.getIzquierdo());
            System.out.println(nodo.getProducto());
            inOrden(nodo.getDerecho());
        }
    }

    public void mostrarPreOrden() {preOrden(raiz);
    }

    // Muestra los productos utilizando el recorrido PreOrden
    private void preOrden(NodoArbolProducto nodo) {
        if (nodo != null) {
            System.out.println(nodo.getProducto());
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    }

    // Muestra los productos utilizando el recorrido PostOrden
    public void mostrarPostOrden() {
        postOrden(raiz);
    }

    // Recorre el árbol en PostOrden
    private void postOrden(NodoArbolProducto nodo) {
        if (nodo != null) {
            postOrden(nodo.getIzquierdo());
            postOrden(nodo.getDerecho());
            System.out.println(nodo.getProducto());
        }
    }
}
