import clientes.Cliente;
import productos.Producto;
import tienda.Tienda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Tienda tienda = new Tienda();

        int opcion;

        do {
            mostrarMenu();

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    agregarProducto(scanner, tienda);
                    break;

                case 2:
                    buscarProducto(scanner, tienda);
                    break;

                case 3:
                    tienda.mostrarInventario();
                    break;

                case 4:
                    agregarCliente(scanner, tienda);
                    break;

                case 5:
                    agregarProductoAlCarrito(scanner, tienda);
                    break;

                case 6:
                    tienda.mostrarClientes();
                    break;

                case 7:
                    tienda.atenderCliente();
                    break;

                case 8:
                    agregarVertice(scanner, tienda);
                    break;

                case 9:
                    agregarArista(scanner, tienda);
                    break;

                case 10:
                    tienda.getGrafo().mostrarMapa();
                    break;

                case 11:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpción inválida.\n");
            }

        } while (opcion != 11);

        scanner.close();
    }

    // Muestra las opciones principales del sistema
    public static void mostrarMenu() {

        System.out.println("\n========== MENÚ TIENDA ==========");
        System.out.println("1. Agregar producto al inventario");
        System.out.println("2. Buscar producto");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Agregar cliente a la cola");
        System.out.println("5. Agregar producto al carrito");
        System.out.println("6. Mostrar clientes en cola");
        System.out.println("7. Atender cliente");
        System.out.println("8. Agregar ubicacion al mapa");
        System.out.println("9. Agregar conexion entre ubicaciones");
        System.out.println("10. Mostrar mapa");
        System.out.println("11. Salir");
        System.out.println("=================================");
    }

    // Agrega un producto al inventario
    public static void agregarProducto(Scanner scanner, Tienda tienda) {

        System.out.println("\n===== AGREGAR PRODUCTO =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Fecha de vencimiento: ");
        String fechaVencimiento = scanner.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(
                nombre,
                precio,
                categoria,
                fechaVencimiento,
                cantidad
        );

        tienda.agregarProducto(producto);

        System.out.println("\nProducto agregado correctamente.\n");
    }

    // Busca un producto por su nombre
    public static void buscarProducto(Scanner scanner, Tienda tienda) {

        System.out.println("\n===== BUSCAR PRODUCTO =====");

        System.out.print("Digite el nombre del producto: ");
        String nombre = scanner.nextLine();

        Producto producto = tienda.buscarProducto(nombre);

        if (producto != null) {
            System.out.println("\nProducto encontrado:");
            System.out.println(producto);
        }
    }

    // Agrega un cliente a la cola
    public static void agregarCliente(Scanner scanner, Tienda tienda) {

        System.out.println("\n===== AGREGAR CLIENTE =====");

        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Prioridad del cliente: ");
        int prioridad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ubicacion del cliente: ");
        String ubicacion = scanner.nextLine();

        Cliente cliente = new Cliente(
                nombre,
                prioridad,
                ubicacion
        );

        tienda.agregarCliente(cliente);

        System.out.println("\nCliente agregado correctamente.\n");
    }

    // Agrega un producto al carrito del cliente
    public static void agregarProductoAlCarrito(
            Scanner scanner,
            Tienda tienda
    ) {

        System.out.println("\n===== AGREGAR PRODUCTO AL CARRITO =====");

        Cliente cliente = tienda.getColaClientes().verFrente();

        if (cliente == null) {
            return;
        }

        System.out.println(
                "Cliente seleccionado: " + cliente.getNombre()
        );

        System.out.print("Nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        Producto productoInventario =
                tienda.buscarProducto(nombreProducto);

        if (productoInventario == null) {
            return;
        }

        System.out.print("Cantidad que desea comprar: ");
        int cantidadCompra = scanner.nextInt();
        scanner.nextLine();

        if (cantidadCompra <= 0) {

            System.out.println(
                    "\nLa cantidad debe ser mayor que cero.\n"
            );

            return;
        }

        if (cantidadCompra > productoInventario.getCantidad()) {

            System.out.println(
                    "\nNo hay suficiente cantidad en el inventario."
            );

            System.out.println(
                    "Cantidad disponible: "
                            + productoInventario.getCantidad()
            );

            return;
        }

        Producto productoCarrito = new Producto(
                productoInventario.getNombre(),
                productoInventario.getPrecio(),
                productoInventario.getCategoria(),
                productoInventario.getFechaVencimiento(),
                cantidadCompra
        );

        cliente.getCarrito().insertarFinal(productoCarrito);

        productoInventario.setCantidad(
                productoInventario.getCantidad()
                        - cantidadCompra
        );

        System.out.println(
                "\nProducto agregado al carrito correctamente.\n"
        );
    }

    // Agrega una nueva ubicacion al grafo
    public static void agregarVertice(
            Scanner scanner,
            Tienda tienda
    ) {

        System.out.println("\n===== AGREGAR UBICACION =====");

        System.out.print("Nombre de la ubicacion: ");
        String ubicacion = scanner.nextLine();

        boolean agregado =
                tienda.getGrafo().agregarVertice(ubicacion);

        if (agregado) {
            System.out.println(
                    "\nUbicacion agregada correctamente.\n"
            );
        } else {
            System.out.println(
                    "\nNo se pudo agregar la ubicacion.\n"
            );
        }
    }

    // Agrega una conexion entre dos ubicaciones
    public static void agregarArista(
            Scanner scanner,
            Tienda tienda
    ) {

        System.out.println("\n===== AGREGAR CONEXION =====");

        System.out.print("Ubicacion de origen: ");
        String origen = scanner.nextLine();

        System.out.print("Ubicacion de destino: ");
        String destino = scanner.nextLine();

        System.out.print("Distancia en km: ");
        double distancia = scanner.nextDouble();
        scanner.nextLine();

        boolean agregada =
                tienda.getGrafo().agregarArista(
                        origen,
                        destino,
                        distancia
                );

        if (agregada) {
            System.out.println(
                    "\nConexion agregada correctamente.\n"
            );
        } else {
            System.out.println(
                    "\nNo se pudo agregar la conexion.\n"
            );
        }
    }
}
