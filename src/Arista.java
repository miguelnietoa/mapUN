
/**
 * Representa una arista ponderada.
 *
 * @author MCJ
 * @version 1.0
 */
public class Arista {

    private Nodo nodo;
    private int peso;

    public Arista(Nodo nodo, int peso) {
        this.nodo = nodo;
        this.peso = peso;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String toString() {
        return nodo.getNombre() + "," + peso;
    }

}
