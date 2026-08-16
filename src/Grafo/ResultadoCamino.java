package Grafo;

import java.util.ArrayList;

public class ResultadoCamino {

    private ArrayList<Vertice> camino;
    private double distanciaTotal;
    private boolean existeCamino;

    public ResultadoCamino(ArrayList<Vertice> camino, double distanciaTotal, boolean existeCamino) {
        this.camino = camino;
        this.distanciaTotal = distanciaTotal;
        this.existeCamino = existeCamino;
    }

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