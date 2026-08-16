package Grafo;

import java.util.ArrayList;

public class ResultadoCamino {

    // Atributos
    private ArrayList<Vertice> camino;
    private double distanciaTotal;
    private boolean existeCamino;

    // Metodos
    // Constructor
    public ResultadoCamino(ArrayList<Vertice> camino, double distanciaTotal, boolean existeCamino) {
        this.camino = camino;
        this.distanciaTotal = distanciaTotal;
        this.existeCamino = existeCamino;
    }

    // Getters
    public ArrayList<Vertice> getCamino() {
        return camino;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    public boolean isExisteCamino() {
        return existeCamino;
    }
}