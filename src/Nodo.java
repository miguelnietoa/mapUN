
import java.util.LinkedList;

/**
 * Representa un nodo.
 *
 * @author MCJ
 * @version 1.0
 */
public class Nodo {

    private int x, y;
    private String nombre;
    private LinkedList<Arista> aristas;

    public Nodo(String nombre, int x, int y) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        aristas = new LinkedList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addArista(Arista a) {
        aristas.add(a);
    }

    public LinkedList<Arista> getAristas() {
        return aristas;
    }

    @Override
    public String toString() {
        return nombre + "," + x + "," + y;
    }

    /**
     * Elimina la arista que comienza en ESTE nodo y que termina en el parámetro
     * nodo.
     *
     * @param nodo Nodo de final de arista.
     */
    public void eliminarAristaConVertice(Nodo nodo) {
        for (Arista arista : aristas) {
            if (arista.getNodo().equals(nodo)) {
                aristas.remove(arista);
                return;
            }
        }
    }

}
