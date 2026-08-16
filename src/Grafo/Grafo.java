package Grafo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {

    private ArrayList<Vertice> vertices;

    public Grafo() {
        vertices = new ArrayList<>();
    }

    public boolean agregarVertice(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || existeVertice(nombre)) {
            return false;
        }

        vertices.add(new Vertice(nombre.trim()));
        return true;
    }

    public boolean agregarVertice(Vertice vertice) {
        if (vertice == null) {
            return false;
        }
        return agregarVertice(vertice.getNombre());
    }

    public boolean agregarArista(String nombreOrigen, String nombreDestino, double peso) {
        Vertice origen = buscarVertice(nombreOrigen);
        Vertice destino = buscarVertice(nombreDestino);

        if (origen == null || destino == null || peso <= 0 || origen == destino) {
            return false;
        }

        if (origen.estaConectadoCon(destino)) {
            return false;
        }

        origen.agregarArista(new Arista(origen, destino, peso));
        destino.agregarArista(new Arista(destino, origen, peso));
        return true;
    }

    public boolean agregarArista(Vertice origen, Vertice destino, double peso) {
        if (origen == null || destino == null) {
            return false;
        }
        return agregarArista(origen.getNombre(), destino.getNombre(), peso);
    }

    public Vertice buscarVertice(String nombre) {
        if (nombre == null) {
            return null;
        }

        for (Vertice vertice : vertices) {
            if (vertice.getNombre().equalsIgnoreCase(nombre.trim())) {
                return vertice;
            }
        }
        return null;
    }

    public boolean existeVertice(String nombre) {
        return buscarVertice(nombre) != null;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public boolean hayCamino(String nombreOrigen, String nombreDestino) {
        Vertice origen = buscarVertice(nombreOrigen);
        Vertice destino = buscarVertice(nombreDestino);

        if (origen == null || destino == null) {
            return false;
        }

        Queue<Vertice> pendientes = new LinkedList<>();
        HashSet<Vertice> visitados = new HashSet<>();

        pendientes.offer(origen);
        visitados.add(origen);

        while (!pendientes.isEmpty()) {
            Vertice actual = pendientes.poll();

            if (actual == destino) {
                return true;
            }

            for (Arista arista : actual.getAdyacentes()) {
                Vertice vecino = arista.getDestino();
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    pendientes.offer(vecino);
                }
            }
        }

        return false;
    }

    public void mostrarMapa() {
        System.out.println("\n========== MAPA DE UBICACIONES ==========");

        if (vertices.isEmpty()) {
            System.out.println("El mapa no contiene ubicaciones.\n");
            return;
        }

        for (Vertice vertice : vertices) {
            System.out.println("\n" + vertice.getNombre() + ":");

            if (vertice.getAdyacentes().isEmpty()) {
                System.out.println("  Sin conexiones");
            } else {
                for (Arista arista : vertice.getAdyacentes()) {
                    System.out.println("  -> " + arista);
                }
            }
        }
        System.out.println();
    }

    public void cargarMapaInicial() {
        agregarVertice("San Jose");
        agregarVertice("Escazu");
        agregarVertice("Santa Ana");
        agregarVertice("Heredia");
        agregarVertice("Alajuela");
        agregarVertice("Cartago");

        agregarArista("San Jose", "Escazu", 8);
        agregarArista("San Jose", "Heredia", 12);
        agregarArista("San Jose", "Cartago", 24);
        agregarArista("Escazu", "Santa Ana", 10);
        agregarArista("Santa Ana", "Alajuela", 18);
        agregarArista("Heredia", "Alajuela", 14);
        agregarArista("Heredia", "Cartago", 32);
    }

    public ResultadoCamino dijkstra(String nombreOrigen, String nombreDestino) {
        Vertice origen = buscarVertice(nombreOrigen);
        Vertice destino = buscarVertice(nombreDestino);

        if (origen == null || destino == null) {
            return new ResultadoCamino(new ArrayList<>(), 0, false);
        }

        HashMap<Vertice, Double> distancias = new HashMap<>();
        HashMap<Vertice, Vertice> anteriores = new HashMap<>();
        HashSet<Vertice> visitados = new HashSet<>();

        for (Vertice vertice : vertices) {
            distancias.put(vertice, Double.POSITIVE_INFINITY);
        }

        distancias.put(origen, 0.0);

        while (visitados.size() < vertices.size()) {
            Vertice actual = null;
            double menorDistancia = Double.POSITIVE_INFINITY;

            for (Vertice vertice : vertices) {
                if (!visitados.contains(vertice)
                        && distancias.get(vertice) < menorDistancia) {
                    menorDistancia = distancias.get(vertice);
                    actual = vertice;
                }
            }

            if (actual == null) {
                break;
            }

            if (actual == destino) {
                break;
            }

            visitados.add(actual);

            for (Arista arista : actual.getAdyacentes()) {
                Vertice vecino = arista.getDestino();

                if (!visitados.contains(vecino)) {
                    double nuevaDistancia = distancias.get(actual) + arista.getPeso();

                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        anteriores.put(vecino, actual);
                    }
                }
            }
        }

        if (Double.isInfinite(distancias.get(destino))) {
            return new ResultadoCamino(new ArrayList<>(), 0, false);
        }

        ArrayList<Vertice> camino = new ArrayList<>();
        Vertice actual = destino;

        while (actual != null) {
            camino.add(0, actual);
            actual = anteriores.get(actual);
        }

        return new ResultadoCamino(camino, distancias.get(destino), true);
    }
}
