package tienda;

import productos.ArbolProductos;
import clientes.Cliente;
import clientes.ColaClientes;
import productos.Producto;
import grafo.Grafo;

public class Tienda {

    // Atributos
    private ArbolProductos inventario;
    private ColaClientes colaClientes;
    private String ubicacion;
    private Grafo grafo;

    // Metodos
    // Constructor
    public Tienda(String ubicacion, Grafo grafo) {
        inventario = new ArbolProductos();
        this.grafo = grafo;
        colaClientes = new ColaClientes(grafo);
        this.ubicacion = ubicacion;
    }

    // Getters
    public ArbolProductos getInventario() {
        return inventario;
    }

    public ColaClientes getColaClientes() {
        return colaClientes;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    // Setter
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Agrega un producto al inventario de la tienda
    public void agregarProducto(Producto producto) {
        inventario.insertar(producto);
    }

    // Busca un producto en el inventario por su nombre
    public Producto buscarProducto(String nombre) {
        return inventario.buscar(nombre);
    }

    // Muestra el inventario de la tienda
    public void mostrarInventario() {
        System.out.println("\n===== INVENTARIO =====");
        inventario.mostrarInOrden();
    }

    // Muestra todos los clientes en la cola
    public void mostrarClientes() {
        colaClientes.mostrar();
    }

    // Agrega un cliente a la cola de atención
    public void agregarCliente(Cliente cliente) {
        colaClientes.insertar(cliente);
    }

    // Atiende al siguiente cliente de la cola
    public void atenderCliente() {

        Cliente cliente = colaClientes.atenderCliente();

        if (cliente == null) {
            System.out.println("No hay clientes en la cola.\n");
            return;
        }

        System.out.println("\n========== FACTURA ==========");
        System.out.println("Cliente: " + cliente.getNombre());

        cliente.getCarrito().imprimirFactura();
    }
}
