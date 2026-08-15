package Grafo;

import java.util.ArrayList;

public class Vertice {

    private String nombre;
    private ArrayList<Arista> adyacentes;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Arista> getAdyacentes() {
        return adyacentes;
    }

    public void agregarArista(Arista arista) {
        adyacentes.add(arista);
    }

    public boolean estaConectadoCon(Vertice destino) {
        for (Arista arista : adyacentes) {
            if (arista.getDestino() == destino) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
