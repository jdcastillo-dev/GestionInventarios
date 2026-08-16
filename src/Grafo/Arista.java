package Grafo;

public class Arista {

    // Atributos
    private Vertice origen;
    private Vertice destino;
    private double peso;

    // Metodos
    // Constructor
    public Arista(Vertice origen, Vertice destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    // Getters
    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    // toString()
    @Override
    public String toString() {
        return destino.getNombre() + " (" + peso + " km)";
    }
}