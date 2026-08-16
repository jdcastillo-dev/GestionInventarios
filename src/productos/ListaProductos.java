package productos;

public class ListaProductos {

    // Atributos
    private NodoProducto primero;

    // Metodos
    // Constructor
    public ListaProductos() {
        primero = null;
    }

    // Operaciones
    private boolean estaVacia() {
        return primero == null;
    }

    public void insertarInicio(Producto producto) {

        NodoProducto nodo = new NodoProducto(producto);

        // Ponerle al nodo nuevo como siguiente el primero
        nodo.setSiguiente(primero);

        // Poner el nuevo nodo como primero de la lista
        primero = nodo;
    }

    // Inserta un producto al final de la lista
    public void insertarFinal(Producto producto) {

        NodoProducto nodo = new NodoProducto(producto);

        // Considerar si la lista esta vacia; si es asi, lo insertamos como primero
        if (estaVacia()) {
            primero = nodo;
            return;
        }

        // Si no, se recorre la lista hasta encontrar el ultimo
        NodoProducto temp = primero;

        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }

        // Una vez encontrado el ultimo, le ponemos el nuevo nodo como siguiente
        temp.setSiguiente(nodo);
    }

    // Busca un producto por nombre
    public NodoProducto buscar(String nombre) {

        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return null;
        }

        NodoProducto temp = primero;

        // Recorrer la lista comparando nombres
        while (temp != null) {

            if (temp.getProducto().getNombre().equalsIgnoreCase(nombre)) {
                return temp;
            }

            temp = temp.getSiguiente();
        }

        System.out.println("El producto buscado no se encontró en la lista.\n");
        return null;
    }

    // Elimina un producto de la lista por nombre
    public NodoProducto eliminar(String nombre) {

        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return null;
        }

        // Caso especial: el producto a eliminar es el primero
        if (primero.getProducto().getNombre().equalsIgnoreCase(nombre)) {
            NodoProducto aux = primero;
            primero = primero.getSiguiente();
            return aux;
        }

        NodoProducto temp = primero;
        NodoProducto anterior = temp;

        // Buscar el nodo a eliminar y su nodo anterior
        while (temp != null && !temp.getProducto().getNombre().equalsIgnoreCase(nombre)) {
            anterior = temp;
            temp = temp.getSiguiente();
        }

        // Si no se encontró el producto
        if (temp == null) {
            System.out.println("El producto buscado no se encontró en la lista.\n");
            return null;
        }

        // Saltar el nodo encontrado para eliminarlo de la lista
        anterior.setSiguiente(temp.getSiguiente());

        return temp;
    }

    // Modifica los datos de un producto existente
    public void modificarProducto(String nombre, double precio, String categoria, String fechaVencimiento, int cantidad) {

        NodoProducto nodo = buscar(nombre);

        if (nodo == null) {
            return;
        }

        // Actualizar los datos del producto
        nodo.getProducto().setPrecio(precio);
        nodo.getProducto().setCategoria(categoria);
        nodo.getProducto().setFechaVencimiento(fechaVencimiento);
        nodo.getProducto().setCantidad(cantidad);

        System.out.println("Producto modificado correctamente.\n");
    }

    // Agrega una imagen a la lista de imágenes de un producto
    public void agregarImagen(String nombre, String rutaImagen) {

        NodoProducto nodo = buscar(nombre);

        if (nodo == null) {
            return;
        }

        nodo.getProducto().agregarImagen(rutaImagen);

        System.out.println("Imagen agregada correctamente.\n");
    }

    // Muestra todos los productos almacenados en la lista
    public void mostrar() {

        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return;
        }

        NodoProducto temp = primero;

        // Recorrer e imprimir cada producto
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getSiguiente();
        }
    }

    // Genera un reporte de costos de todos los productos
    public void reporteCostos() {

        if (estaVacia()) {
            System.out.println("La lista está vacía.\n");
            return;
        }

        NodoProducto temp = primero;
        double totalGeneral = 0;

        // Recorrer todos los productos y calcular sus costos
        while (temp != null) {

            Producto producto = temp.getProducto();

            double totalProducto =
                    producto.getPrecio() * producto.getCantidad();

            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("Costo total: " + totalProducto + "\n");

            totalGeneral += totalProducto;

            temp = temp.getSiguiente();
        }

        // Mostrar el costo total del inventario
        System.out.println("Costo total acumulado: " + totalGeneral + "\n");
    }

    // Calcula y retorna el costo total de todos los productos
    public double calcularTotal() {

        double totalGeneral = 0;
        NodoProducto temp = primero;

        while (temp != null) {

            Producto producto = temp.getProducto();

            double totalProducto = producto.getPrecio() * producto.getCantidad();

            totalGeneral += totalProducto;

            temp = temp.getSiguiente();
        }

        return totalGeneral;

    }

    // Imprime la factura de los productos del carrito
    public void imprimirFactura() {

        if (estaVacia()) {
            System.out.println("El carrito esta vacío.\n");
            return;
        }

        NodoProducto temp = primero;

        System.out.println("\n========== Carrito ==========");

        while (temp != null) {
            Producto producto = temp.getProducto();
            double subtotal = producto.getPrecio() * producto.getCantidad();

            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("Subtotal: " + subtotal + "\n");

            temp = temp.getSiguiente();
        }
        System.out.println("Total de la compra: " + calcularTotal());
        System.out.println("=============================\n");
    }
}
