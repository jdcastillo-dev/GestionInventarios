package Grafo;

import java.util.ArrayList;

public class Vertice {

    // Atributos
    private String nombre;
    private ArrayList<Arista> adyacentes;

    // Metodos
    // Constructor
    public Vertice(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    // Agrega una arista a la lista de adyacentes
    public ArrayList<Arista> getAdyacentes() {
        return adyacentes;
    }

    public void agregarArista(Arista arista) {
        adyacentes.add(arista);
    }

    // Verifica si el vertice esta conectado con otro vertice
    public boolean estaConectadoCon(Vertice destino) {
        for (Arista arista : adyacentes) {
            if (arista.getDestino() == destino) {
                return true;
            }
        }
        return false;
    }

    // toString()
    @Override
    public String toString() {
        return nombre;
    }
}
