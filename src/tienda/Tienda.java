package tienda;

import clientes.Cliente;
import clientes.ColaClientes;
import Grafo.Grafo;
import Grafo.ResultadoCamino;
import Grafo.Vertice;
import productos.ArbolProductos;
import productos.Producto;

public class Tienda {

    // Atributos
    private ArbolProductos inventario;
    private ColaClientes colaClientes;
    private String ubicacion;
    private Grafo grafo;

    // Metodos
    // Constructor
    public Tienda() {
        inventario = new ArbolProductos();

        ubicacion = "San Jose";

        grafo = new Grafo();
        grafo.cargarMapaInicial();

        colaClientes = new ColaClientes(grafo);
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

    // Setter
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

        colaClientes.insertar(cliente);
    }

    // Atiende al siguiente cliente de la cola
    public void atenderCliente() {

        Cliente cliente = colaClientes.verFrente();

        if (cliente == null) {
            return;
        }

        ResultadoCamino resultado = grafo.dijkstra(ubicacion, cliente.getUbicacion());

        // Si no existe camino, el cliente no se elimina de la cola
        if (!resultado.isExisteCamino()) {

            System.out.println("\nNo se puede atender al cliente.");

            System.out.println(
                    "La ubicacion "
                            + cliente.getUbicacion()
                            + " esta desconectada de la tienda.\n"
            );

            return;
        }

        // Solo se remueve de la cola cuando existe un camino
        cliente = colaClientes.atenderCliente();

        System.out.println("\n========== FACTURA ==========");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Ubicacion: " + cliente.getUbicacion());

        cliente.getCarrito().imprimirFactura();

        System.out.println("\n===== RUTA DE ENTREGA =====");

        System.out.print("Camino mas corto: ");

        for (int i = 0; i < resultado.getCamino().size(); i++) {

            Vertice vertice = resultado.getCamino().get(i);

            System.out.print(vertice.getNombre());

            if (i < resultado.getCamino().size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println(
                "\nDistancia total: "
                        + resultado.getDistanciaTotal()
                        + " km"
        );

        System.out.println();
    }
}
