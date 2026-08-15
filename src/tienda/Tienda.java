package tienda;

import clientes.Cliente;
import clientes.ColaClientes;
import Grafo.Grafo;
import productos.ArbolProductos;
import productos.Producto;

public class Tienda {

    // Atributos
    private ArbolProductos inventario;
    private ColaClientes colaClientes;
    private String ubicacion;
    private Grafo grafo;


    // Constructor
    public Tienda() {
        inventario = new ArbolProductos();
        colaClientes = new ColaClientes();
        ubicacion = "San Jose";
        grafo = new Grafo();
        grafo.cargarMapaInicial();
    }

    // Getters
    public ArbolProductos getInventario() {
        return inventario;
    }

    public ColaClientes getColaClientes() {
        return colaClientes;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
        grafo.agregarVertice(ubicacion);
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
        if (cliente == null) {
            return;
        }


        // La ubicación se agrega automáticamente cuando el cliente entra a la cola.
        grafo.agregarVertice(cliente.getUbicacion());
        colaClientes.insertar(cliente);
    }

    // Atiende al siguiente cliente de la cola
    public void atenderCliente() {

        Cliente cliente = colaClientes.verFrente();

        if (cliente == null) {
            return;
        }

        // Evita remover al cliente si su ubicación no se conecta con la tienda.
        if (!grafo.hayCamino(ubicacion, cliente.getUbicacion())) {
            System.out.println("\nNo se puede atender al cliente.");
            System.out.println("La ubicación " + cliente.getUbicacion()
                    + " está desconectada de la tienda.\n");
            return;
        }

        cliente = colaClientes.atenderCliente();

        System.out.println("\n========== FACTURA ==========");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Ubicación: " + cliente.getUbicacion());
        cliente.getCarrito().imprimirFactura();

    }
}
