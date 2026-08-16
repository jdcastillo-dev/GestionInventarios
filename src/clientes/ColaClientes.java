package clientes;

import Grafo.Grafo;

public class ColaClientes {

    // Atributos
    private NodoColaCliente frente;
    private Grafo grafo;

    // Metodos
    // Constructor
    public ColaClientes(Grafo grafo) {
        frente = null;
        this.grafo = grafo;
    }

    // Operaciones
    private boolean estaVacia() {
        return frente == null;
    }

    // Inserta un cliente respetando la prioridad y el orden de llegada en caso de empate
    public void insertar(Cliente cliente) {

        // Verifica que el cliente sea valido
        if (cliente == null) {
            return;
        }

        // Agrega automaticamente la ubicacion del cliente al grafo
        grafo.agregarVertice(cliente.getUbicacion());

        NodoColaCliente nodo = new NodoColaCliente(cliente);

        // Si la cola esta vacia o el cliente nuevo tiene mas prioridad que el del frente, se inserta de primero
        if (estaVacia() || cliente.getPrioridad() > frente.getCliente().getPrioridad()) {
            nodo.setSiguiente(frente);
            frente = nodo;
            return;
        }

        // Se recorre la cola hasta encontrar el punto de insercion, respetando el orden de llegada en caso de empate
        NodoColaCliente temp = frente;

        while (temp.getSiguiente() != null
                && temp.getSiguiente().getCliente().getPrioridad() >= cliente.getPrioridad()) {
            temp = temp.getSiguiente();
        }

        nodo.setSiguiente(temp.getSiguiente());
        temp.setSiguiente(nodo);
    }

    // Devuelve al cliente que esta en el frente de la cola, sin removerlo
    public Cliente verFrente() {

        if (estaVacia()) {
            System.out.println("La cola de clientes está vacía.\n");
            return null;
        }

        return frente.getCliente();
    }

    // Remueve y devuelve al cliente que esta en el frente de la cola
    public Cliente atenderCliente() {

        if (estaVacia()) {
            System.out.println("La cola de clientes está vacía.\n");
            return null;
        }

        NodoColaCliente aux = frente;
        frente = frente.getSiguiente();

        return aux.getCliente();
    }

    // Muestra todos los clientes en la cola
    public void mostrar() {

        if (estaVacia()) {
            System.out.println("La cola de clientes está vacía.\n");
            return;
        }

        NodoColaCliente temp = frente;

        // Recorre cada cliente
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getSiguiente();
        }
    }
}
