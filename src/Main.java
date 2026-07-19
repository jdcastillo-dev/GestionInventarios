import productos.ListaProductos;
import productos.NodoProducto;
import productos.Producto;

import clientes.Cliente;
import clientes.ColaClientes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        ListaProductos listaProductos = new ListaProductos();

        int opcion;

        do {
            // Menu de opciones.
            System.out.println("----- MENU GESTION DE INVENTARIO -----");
            System.out.println("1. Insertar producto al inicio");
            System.out.println("2. Insertar producto al final");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Buscar producto");
            System.out.println("5. Modificar producto");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Agregar imagen a producto");
            System.out.println("8. Reporte de costos");
            System.out.println("9. Salir");
            System.out.print("Digite una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                // Insertar un producto al inicio de la lista.
                case 1:
                    Producto productoInicio = crearProducto(scanner);
                    listaProductos.insertarInicio(productoInicio);
                    System.out.println("Producto insertado al inicio correctamente.\n");
                    break;

                // Insertar un producto al final de la lista.
                case 2:
                    Producto productoFinal = crearProducto(scanner);
                    listaProductos.insertarFinal(productoFinal);
                    System.out.println("Producto insertado al final correctamente.\n");
                    break;

                // Muestra todos los productos almacenados.
                case 3:
                    listaProductos.mostrar();
                    break;

                // Busca un producto por nombre.
                case 4:
                    System.out.print("Digite el nombre del producto a buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    NodoProducto nodoBuscado = listaProductos.buscar(nombreBuscar);

                    if (nodoBuscado != null) {
                        System.out.println(nodoBuscado);
                    }
                    break;

                // Modifica la informacion de un producto existente.
                case 5:
                    System.out.print("Digite el nombre del producto a modificar: ");
                    String nombreModificar = scanner.nextLine();

                    System.out.print("Digite el nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite la nueva categoria: ");
                    String nuevaCategoria = scanner.nextLine();

                    System.out.print("Digite la nueva fecha de vencimiento: ");
                    String nuevaFechaVencimiento = scanner.nextLine();

                    System.out.print("Digite la nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    scanner.nextLine();

                    listaProductos.modificarProducto(nombreModificar, nuevoPrecio,
                            nuevaCategoria, nuevaFechaVencimiento, nuevaCantidad);
                    break;

                // Elimina un producto en la lista.
                case 6:
                    System.out.print("Digite el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    NodoProducto nodoEliminado = listaProductos.eliminar(nombreEliminar);

                    if (nodoEliminado != null) {
                        System.out.println("Producto eliminado correctamente.\n");
                    }
                    break;

                // Agrega una imagen a un producto exstente.
                case 7:
                    System.out.print("Digite el nombre del producto: ");
                    String nombreImagen = scanner.nextLine();

                    System.out.print("Digite la ruta de la imagen: ");
                    String rutaImagen = scanner.nextLine();

                    listaProductos.agregarImagen(nombreImagen, rutaImagen);
                    break;

                // Genera el reporte de costos de los productos.
                case 8:
                    listaProductos.reporteCostos();
                    break;

                // Finaliza la ejecución del programa.
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;

                // Opción inválida.
                default:
                    System.out.println("Opcion invalida.\n");
                    break;
            }

        } while (opcion != 9);
    }

    // Solicita los datos de un producto y crea un objeto Producto.
    public static Producto crearProducto(Scanner scanner) {

        System.out.print("Digite el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Digite el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite la categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Digite la fecha de vencimiento: ");
        String fechaVencimiento = scanner.nextLine();

        System.out.print("Digite la cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        // Retorna el producto creado con los datos ingresados
        return new Producto(nombre, precio, categoria, fechaVencimiento, cantidad);
    }
}
