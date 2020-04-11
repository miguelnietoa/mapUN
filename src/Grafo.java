
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Representa un grafo formado por sus componentes ya conocidos (Vértices,
 * aristas).
 *
 * @author MCJ
 * @version 1.0
 */
public class Grafo {

    LinkedList<Nodo> vertices;
    static File f = new File("src/files/grafoActual.txt");

    public Grafo() {
        vertices = new LinkedList<>();
        cargarGrafo(f);
    }

    public LinkedList<Nodo> getVertices() {
        return vertices;
    }

    public void setVertices(LinkedList<Nodo> vertices) {
        this.vertices = vertices;
    }

    public void addNodo(Nodo nodo) {
        vertices.add(nodo);
    }

    /**
     * Verifica que no exista otro nodo en las mismas coordenadas.
     *
     * @param x Coordenada x del nodo.
     * @param y Coordenada y del nodo.
     * @return <code>null</code> si no existe un nodo esas coordenadas <br>
     * el <code>nodo</code> si existe.
     */
    public Nodo existeNodoEnPos(int x, int y) {
        for (Nodo nodo : vertices) {
            int xNodo = nodo.getX();
            int yNodo = nodo.getY();

            // Si está dentro de la región donde hay un nodo dibujado
            if (((x < xNodo + View.DIAMETRO) && (x > xNodo - View.DIAMETRO))
                    && ((y < yNodo + View.DIAMETRO) && (y > yNodo - View.DIAMETRO))) {
                return nodo;
            }
        }
        return null;
    }

    /**
     * Elimina un nodo de la lista de vértices.
     *
     * @param nodo Nodo a eliminar.
     */
    public void eliminarNodo(Nodo nodo) {
        vertices.remove(nodo);
    }

    /**
     * Busca un nodo por su nombre en la lista de vértices del grafo.
     *
     * @param nombre Nombre del nodo.
     * @return <code>null</code> si no lo encuentra <br>
     * el <code>nodo</code> si lo encuentra.
     */
    public Nodo buscarNodo(String nombre) {
        for (Nodo vertice : vertices) {
            if (vertice.getNombre().equals(nombre)) {
                return vertice;
            }
        }
        return null;
    }

    /**
     * Obtiene un nodo en la posición dada de la lista.
     *
     * @param pos Posición del nodo.
     * @return <code>null</code> si la posición supera el número de nodos <br>
     * el <code>nodo</code> en caso contrario.
     */
    public Nodo getNodo(int pos) {
        return pos < vertices.size() ? vertices.get(pos) : null;
    }

    /**
     * Busca que un vértice esté relacionado con otro, revisando cada una de sus
     * aristas y viendo si estas contienen en sus atributos el nodo destino.
     *
     * @param orig Vértice origen.
     * @param dest Vértice destino
     * @return La <code>arista</code> si existe; <code>null</code> en cualquier
     * otro caso.
     */
    public Arista existeArista(Nodo orig, Nodo dest) {
        for (Arista a : orig.getAristas()) {
            if (a.getNodo() == dest) {
                return a;
            }
        }
        return null;
    }

    /**
     * Lee el archivo, y carga las estructuras del grafo
     *
     * @param f Archivo a leer.
     */
    public void cargarGrafo(File f) {
        vertices.clear();
        try (Scanner lector = new Scanner(f)) {
            ArrayList<ArrayList<String>> infoAristas = new ArrayList<>();
            while (lector.hasNextLine()) {
                String[] str = lector.nextLine().split(";");
                ArrayList<String> aristas = new ArrayList<>();
                if (str.length > 0) {
                    for (int i = 1; i < str.length; i++) {
                        aristas.add(str[i]);
                    }
                    String[] infoVertice = str[0].split(",");
                    try {
                        addNodo(new Nodo(infoVertice[0], Integer.parseInt(infoVertice[1]), Integer.parseInt(infoVertice[2])));
                    } catch (NumberFormatException e) {
                        System.out.println("Error de conversión al leer archivo.");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error al acceder a posiciones del arreglo para el archivo.");
                    }
                }
                infoAristas.add(aristas);
            }

            for (int i = 0; i < vertices.size(); i++) {
                for (String string : infoAristas.get(i)) {
                    try {
                        String[] datos = string.split(",");
                        Nodo nodo2 = buscarNodo(datos[0]);
                        if (nodo2 == null) {
                            System.out.println("Error, hay un vertice de una arista que no existe. Error en el archivo.");
                        } else {
                            int peso = Integer.parseInt(datos[1]);
                            getNodo(i).addArista(new Arista(nodo2, peso));
                        }
                    } catch (Exception e) {
                        System.out.println("Error al añadir arista.");
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Escribe en un archivo la información que compone al objeto Nodo, para
     * guardar esta informacion de cada nodo y luego poder recuperar el grafo
     * ante un cierre del programa.
     */
    public void actualizarArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (Nodo vertice : vertices) {
                String str = vertice.toString();
                for (Arista arista : vertice.getAristas()) {
                    str += ";" + arista.toString();
                }
                bw.write(str);
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }

}
