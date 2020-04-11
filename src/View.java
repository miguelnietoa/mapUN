import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Ventana principal de la aplicación.
 *
 * @author MCJ
 * @version 1.0
 */
public class View extends javax.swing.JFrame {

    private Grafo grafo;
    private Nodo[][] MatrizRecorridos;
    private Nodo v1, v2;
    static final int DIAMETRO = 16;
    static final int RADIO = DIAMETRO / 2;

    public View() {
        ImageIcon img = new ImageIcon("src/imgs/logo.png");
        this.setIconImage(img.getImage());
        initComponents();
        setLocationRelativeTo(null);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        panel.setFocusable(true);
        grafo = new Grafo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listaOpciones = new javax.swing.JComboBox<>();
        panel = new javax.swing.JPanel();
        mapaImagen = new javax.swing.JLabel();
        btnElimarGraf = new javax.swing.JButton();
        visButton = new javax.swing.JToggleButton();
        checkBox = new javax.swing.JCheckBox();
        costoMinLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("mapUN");
        setResizable(false);

        jLabel1.setText("¿Qué deseas realizar?");

        listaOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Añadir nodo", "Añadir arista", "Borrar nodo", "Mostrar informacion", "Ejecutar Floyd", "Eliminar arista" }));
        listaOpciones.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listaOpcionesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        listaOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaOpcionesActionPerformed(evt);
            }
        });

        panel.setRequestFocusEnabled(false);
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        mapaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/mapaU.png"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapaImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapaImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        btnElimarGraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/limpiar.png"))); // NOI18N
        btnElimarGraf.setText("Eliminar Grafo");
        btnElimarGraf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnElimarGrafMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnElimarGrafMouseExited(evt);
            }
        });
        btnElimarGraf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimarGrafActionPerformed(evt);
            }
        });

        visButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/vis.png"))); // NOI18N
        visButton.setText("Visitantes");
        visButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                visButtonMouseExited(evt);
            }
        });
        visButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visButtonActionPerformed(evt);
            }
        });

        checkBox.setText("Mostrar peso de aristas");
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElimarGraf)
                        .addGap(18, 18, 18)
                        .addComponent(visButton)
                        .addGap(18, 18, 18)
                        .addComponent(checkBox))
                    .addComponent(costoMinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnElimarGraf)
                    .addComponent(visButton)
                    .addComponent(checkBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costoMinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        //Coordenadas del click dado.
        int x = evt.getX() - RADIO;
        int y = evt.getY() - RADIO;

        if (x > DIAMETRO && y > DIAMETRO && x < panel.getWidth() - DIAMETRO && y < panel.getHeight() - DIAMETRO) {
            Graphics2D g = (Graphics2D) panel.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Nodo nodo = grafo.existeNodoEnPos(x, y); //Buscamos si existe un nodo en esa posición.

            switch (listaOpciones.getSelectedIndex()) {
                case 0: //Añadir nodo.
                    if (nodo == null) {
                        if (!nodoColisionaArista(x + RADIO, y + RADIO)) {
                            String nombre;
                            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del vértice:");
                            if (nombre != null) {//Se dió en aceptar.
                                if (!nombre.isEmpty()) {
                                    Nodo newNodo = new Nodo(nombre, x, y);
                                    grafo.addNodo(newNodo);
                                    pintarVertice(g, newNodo, Color.blue);
                                    MatrizRecorridos = (Nodo[][]) (floydPath(grafo).get(0));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Debe escribir un nombre.");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede añadir nodos sobre aristas.");
                        }
                    }
                    break;

                case 1: // Añadir arista.
                    if (nodo != null) {
                        if (v1 == null) { // Si aún no ha sido seleccionado el primer nodo.
                            v1 = nodo;
                            g.setColor(Color.red);
                            g.fillOval(v1.getX(), v1.getY(), DIAMETRO, DIAMETRO);
                            g.setColor(Color.black);
                            g.drawOval(v1.getX(), v1.getY(), DIAMETRO, DIAMETRO);
                        } else if (!v1.equals(nodo)) {
                            if (grafo.existeArista(v1, nodo) != null) {
                                JOptionPane.showMessageDialog(null, "Ya existe una arista entre estos dos vértices.");
                            } else {
                                v2 = nodo;
                                if (aristaColisionaNodo(v1, v2)) {
                                    JOptionPane.showMessageDialog(null, "Arista colisiona con un nodo.");
                                } else {

                                    g.setColor(Color.red);
                                    g.fillOval(v2.getX(), v2.getY(), DIAMETRO, DIAMETRO);
                                    g.setColor(Color.black);
                                    g.drawOval(v2.getX(), v2.getY(), DIAMETRO, DIAMETRO);

                                    String cad = JOptionPane.showInputDialog(null, "Ingrese el peso de la arista");

                                    if (cad != null) {
                                        try {
                                            int peso = Integer.parseInt(cad);
                                            v1.addArista(new Arista(v2, peso));
                                            pintarArista(panel.getGraphics(), v1, v2, false);
                                            this.repaint();
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Valor inválido.");
                                        }
                                    }
                                    pintarVertice(g, v1, Color.blue);
                                    pintarVertice(g, v2, Color.blue);
                                    v1 = v2 = null;
                                }
                            }
                        }
                    }
                    break;

                case 2: //Borrar nodo.
                    if (nodo != null) {
                        grafo.getVertices().forEach((vertice) -> {
                            vertice.eliminarAristaConVertice(nodo);
                        });
                        grafo.eliminarNodo(nodo);
                        this.repaint();
                        MatrizRecorridos = (Nodo[][]) (floydPath(grafo).get(0));
                    }
                    break;

                case 3: //Mostrar información.
                    if (nodo != null) {
                        InfoNodo vent = new InfoNodo(nodo);
                        vent.setVisible(true);
                    }
                    break;

                case 4: //Ejecutar Floyd.
                    if (nodo != null) {
                        if (v1 == null) {
                            v1 = nodo;
                            pintarVertice(g, v1, Color.red);
                        } else if (v2 == null) {
                            v2 = nodo;
                            pintarVertice(g, v2, Color.red);
                            if (v1 == v2) {
                                JOptionPane.showMessageDialog(null, "No se pude ir al mismo nodo de origen");
                                pintarVertice(g, v1, Color.blue);
                                v1 = v2 = null;
                            } else {
                                if (MatrizRecorridos==null) {
                                    MatrizRecorridos = (Nodo[][]) (floydPath(grafo).get(0));
                                }
                                pintarRuta(
                                        getRuta(MatrizRecorridos, v1, v2)
                                );
                                v1 = v2 = null;
                                listaOpciones.setSelectedIndex(0);
                            }
                        }
                    }
                    break;

                case 5: //Eliminar arista.
                    if (nodo != null) {
                        if (v1 == null) {
                            v1 = nodo;
                            pintarVertice(g, v1, Color.red);
                        } else if (v2 == null) {
                            v2 = nodo;
                            pintarVertice(g, v2, Color.red);
                            if (v1 == v2) {
                                JOptionPane.showMessageDialog(null, "No se pude ir al mismo nodo de origen");
                            } else {
                                if (grafo.existeArista(v1, v2) == null) {
                                    JOptionPane.showMessageDialog(null, "No existe una arista entre este par de vértices.");
                                } else {
                                    v1.eliminarAristaConVertice(v2);
                                }
                            }
                            this.repaint();
                            v1 = v2 = null;
                        }
                    }
                    break;

                default:
                    break;
            }
            if (!visButton.isSelected()) {
                grafo.actualizarArchivo();
            }
        }
    }//GEN-LAST:event_panelMouseClicked

    private void btnElimarGrafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimarGrafActionPerformed
        grafo.vertices = new LinkedList<>();
        grafo.actualizarArchivo();
        this.repaint();
    }//GEN-LAST:event_btnElimarGrafActionPerformed

    private void listaOpcionesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listaOpcionesPopupMenuWillBecomeInvisible
        this.repaint();
        v1 = v2 = null;
    }//GEN-LAST:event_listaOpcionesPopupMenuWillBecomeInvisible

    private void visButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visButtonActionPerformed
        if (visButton.isSelected()) {
            this.setTitle("mapUN - Modo Visitantes Activo");
            btnElimarGraf.setEnabled(false);
            listaOpciones.setSelectedIndex(4);
            grafo.cargarGrafo(new File("src/files/visitantes.txt"));
        } else {
            this.setTitle("mapUN");
            btnElimarGraf.setEnabled(true);
            listaOpciones.setSelectedIndex(0);
            grafo.cargarGrafo(new File("src/files/grafoActual.txt"));
        }
        MatrizRecorridos = (Nodo[][]) (floydPath(grafo).get(0));
        this.repaint();
    }//GEN-LAST:event_visButtonActionPerformed

    private void listaOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaOpcionesActionPerformed
        if (visButton.isSelected()) {
            if (listaOpciones.getSelectedIndex() != 3 && listaOpciones.getSelectedIndex() != 4) {
                listaOpciones.setSelectedIndex(3);
            }
        }
    }//GEN-LAST:event_listaOpcionesActionPerformed

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        this.repaint();
    }//GEN-LAST:event_checkBoxActionPerformed

    private void btnElimarGrafMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnElimarGrafMouseEntered
        btnElimarGraf.setIcon(new ImageIcon("src/imgs/limpiarColor.png"));
    }//GEN-LAST:event_btnElimarGrafMouseEntered

    private void btnElimarGrafMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnElimarGrafMouseExited
        btnElimarGraf.setIcon(new ImageIcon("src/imgs/limpiar.png"));
    }//GEN-LAST:event_btnElimarGrafMouseExited

    private void visButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visButtonMouseEntered
        visButton.setIcon(new ImageIcon("src/imgs/visColor.png"));
    }//GEN-LAST:event_visButtonMouseEntered

    private void visButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visButtonMouseExited
        if (visButton.isSelected()) {
            visButton.setIcon(new ImageIcon("src/imgs/visColor.png"));
        } else {
            visButton.setIcon(new ImageIcon("src/imgs/vis.png"));
        }
    }//GEN-LAST:event_visButtonMouseExited

    /**
     * Verifica que una arista no colisione con un nodo.
     *
     * @param origen Nodo origen de la arista.
     * @param destino Nodo destino de la arista.
     * @return <code>true</code> si colisiona <br> <code>false</code> si no.
     */
    public boolean aristaColisionaNodo(Nodo origen, Nodo destino) {
        double x1 = origen.getX() + RADIO, y1 = origen.getY() + RADIO,
                x2 = destino.getX() + RADIO, y2 = destino.getY() + RADIO,
                m = (y2 - y1) / (x2 - x1),
                a = m,
                b = -1,
                c = -m * x1 + y1;

        double dist, x, y, minX, minY, width, height, extra;

        extra = (grafo.existeArista(destino, origen) == null ? 0 : 3);

        for (Nodo nodo : grafo.getVertices()) {
            if (nodo != origen && nodo != destino) {

                x = nodo.getX() + RADIO;
                y = nodo.getY() + RADIO;

                dist = (Math.abs(a * x + b * y + c)) / Math.sqrt(a * a + b * b);

                minX = Math.min(x1, x2);
                minY = Math.min(y1, y2);
                width = Math.abs(x2 - x1);
                height = Math.abs(y2 - y1);

                if (RADIO + extra >= dist) {
                    if ((x >= minX && x <= minX + width) && (y >= minY && y <= minY + height)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Verifica que un nodo no colisione con ninguna arista.
     *
     * @param x Coordenada x del centro del circulo.
     * @param y Coordenada y del centro del circulo.
     * @return <code>true</code> si colisiona <br> <code>false</code> si no.
     */
    public boolean nodoColisionaArista(int x, int y) {
        double x1, y1, x2, y2, m, a, b, c, dist;
        double minX, minY, width, height, extra;
        for (Nodo nodo : grafo.vertices) {
            for (Arista arista : nodo.getAristas()) {
                x1 = nodo.getX() + RADIO;
                y1 = nodo.getY() + RADIO;
                x2 = arista.getNodo().getX() + RADIO;
                y2 = arista.getNodo().getY() + RADIO;
                m = (y2 - y1) / (x2 - x1);
                a = m;
                b = -1;
                c = -m * x1 + y1;
                dist = (Math.abs(a * x + b * y + c)) / Math.sqrt(a * a + b * b);

                minX = Math.min(x1, x2);
                minY = Math.min(y1, y2);
                width = Math.abs(x2 - x1);
                height = Math.abs(y2 - y1);

                extra = (grafo.existeArista(arista.getNodo(), nodo) == null ? 0 : 3);

                if (RADIO + extra >= dist) {
                    if ((x >= minX && x <= minX + width) && (y >= minY && y <= minY + height)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Pinta un vértice.
     *
     * @param g Graphics.
     * @param vertice Vértice a pintar.
     * @param c Color.
     */
    private void pintarVertice(Graphics g, Nodo vertice, Color c) {
        g.setColor(c);
        g.fillOval(vertice.getX(), vertice.getY(), DIAMETRO, DIAMETRO);
        g.setColor(Color.black);
        g.drawOval(vertice.getX(), vertice.getY(), DIAMETRO, DIAMETRO);
    }

    /**
     * Pinta las arista que conectan una sucesión de nodos.
     *
     * @param ruta Lista de nodos.
     */
    public void pintarRuta(LinkedList<Nodo> ruta) {
        if (ruta == null) {
            JOptionPane.showMessageDialog(null, "No se pude ir del nodo: " + v1.getNombre() + " hacia el nodo: " + v2.getNombre());
            this.repaint();
        } else {
            Graphics2D g = (Graphics2D) panel.getGraphics();
            for (int i = 0; i < ruta.size(); i++) {
                pintarVertice(g, ruta.get(i), Color.GREEN);
            }
            for (int i = 0; i < ruta.size() - 1; i++) {
                if (grafo.existeArista(ruta.get(i), ruta.get(i + 1)) != null) {
                    pintarArista(g, ruta.get(i), ruta.get(i + 1), true);
                } else {
                    pintarRuta(getRuta(MatrizRecorridos, ruta.get(i), ruta.get(i + 1)));
                }
            }
            costoMinLabel.setText("El recorrido mínimo es de " + getCostoMinimo(v1, v2) + " metros.");
        }
    }

    /**
     * Obtiene la ruta mínima de un vértice origen a uno final.
     *
     * @param recorridos Matriz de recorridos obtenida al aplicar Floyd
     * Warshall.
     * @param origen Vértice Origen.
     * @param destino Vértice Final.
     * @return La ruta de un vértice a otro.
     */
    public LinkedList<Nodo> getRuta(Nodo[][] recorridos, Nodo origen, Nodo destino) {
        Stack<Nodo> pila = new Stack<>();

        int indexOrg = grafo.getVertices().indexOf(origen);
        int indexDest = grafo.getVertices().indexOf(destino);

        pila.addElement(destino);
        while (!recorridos[indexOrg][indexDest].equals(origen)) {
            if (recorridos[indexOrg][indexDest].equals(grafo.getVertices().get(indexDest))) {
                pila.addElement(origen);
                break;
            }
            pila.addElement(recorridos[indexOrg][indexDest]);
            indexDest = grafo.getVertices().indexOf(recorridos[indexOrg][indexDest]);
        }
        LinkedList<Nodo> ruta = new LinkedList<>();

        Nodo n1 = pila.pop(), n2;
        ruta.add(n1);

        while (!pila.isEmpty()) {
            n2 = pila.pop();
            ruta.add(n2);
            n1 = n2;
        }
        if (ruta.size() == 2 && grafo.existeArista(origen, destino) == null) {
            ruta = null;
        }
        return ruta;
    }

    /**
     * Obtiene el costo mínimo de un vertice inicial a uno final.
     */
    public int getCostoMinimo(Nodo inicio, Nodo fin) {
        int indexOrg = grafo.getVertices().indexOf(inicio);
        int indexDest = grafo.getVertices().indexOf(fin);
        int[][] distancias = (int[][]) floydPath(grafo).get(1);
        return distancias[indexOrg][indexDest];
    }

    /**
     * Realiza el algoritmo de Floyd Warshall.
     *
     * @param grafo El grafo que se va a analizar.
     * @return La matriz de recorridos mínimos del grafo.
     */
    public LinkedList<Object> floydPath(Grafo grafo) {
        LinkedList<Object> matrices = new LinkedList<>();
        int n = grafo.vertices.size();
        int[][] distancias = new int[n][n];
        Nodo[][] recorridos = new Nodo[n][n];
        for (int i = 0; i < n; i++) { //Inicializamos la matriz de recorridos.
            Nodo vertice = grafo.vertices.get(i);
            for (int j = 0; j < n; j++) {
                recorridos[j][i] = (i != j ? vertice : null);
            }
        }
        for (int i = 0; i < n; i++) { //Inicializamos la matriz de distancias.
            Nodo verticeOrigen = grafo.vertices.get(i);
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    Nodo verticeDestino = grafo.vertices.get(j);
                    Arista a = grafo.existeArista(verticeOrigen, verticeDestino);
                    distancias[i][j] = (a != null ? a.getPeso() : 100000);
                } else {
                    distancias[i][j] = 0;
                }
            }
        }
        // Aplicamos Floyd.
        for (int i = 0; i < n; i++) { //Indice de vértice analizado.
            for (int j = 0; j < n; j++) { //Filas.
                for (int k = 0; k < n; k++) { //Columnas.
                    if (j != i && k != i) {
                        if (distancias[j][k] > distancias[j][i] + distancias[i][k]) {
                            distancias[j][k] = distancias[j][i] + distancias[i][k];
                            recorridos[j][k] = grafo.vertices.get(i);
                        }
                    }
                }
            }
        }
        matrices.add(recorridos);
        matrices.add(distancias);
        return matrices;
    }

    /**
     * Pinta una arista entre dos vértices.
     *
     * @param g1 Graphics.
     * @param v1 Vértice inicial.
     * @param v2 Vértice final.
     * @param camino <code>true</code> si se quiere pintar como ruta <br>
     * <code>false</code> si se quiere pintar como arista.
     *
     * @see <span>Pintar flecha de:</span>
     * <a href="https://stackoverrun.com/es/q/963263">https://stackoverrun.com/</a>
     */
    private void pintarArista(Graphics g1, Nodo v1, Nodo v2, boolean camino) {
        Graphics2D g2 = (Graphics2D) g1.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (camino) {
            g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(Color.red);
        } else {
            g2.setColor(Color.black);
        }
        int x1 = v1.getX() + RADIO;
        int y1 = v1.getY() + RADIO;
        int x2 = v2.getX() + RADIO;
        int y2 = v2.getY() + RADIO;

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx * dx + dy * dy) - RADIO;
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g2.transform(at);

        int ARR_SIZE = 5;

        Arista otraArista = grafo.existeArista(v2, v1);
        if (otraArista == null) {
            g2.drawLine(RADIO, 0, len, 0);
            g2.fillPolygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4);
            if (checkBox.isSelected()) {
                g2.drawString(grafo.existeArista(v1, v2).getPeso() + "", len / 2, -1);
            }
        } else {
            g2.drawLine(RADIO, 3, len, 3);
            g2.fillPolygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new int[]{3, -ARR_SIZE + 3, ARR_SIZE + 3, 3}, 4);
            if (checkBox.isSelected()) {
                g2.drawString(otraArista.getPeso() + "", len / 2, -4);
            }
        }
    }

    /**
     * Pinta el grafo.
     */
    public void pintarGrafo() {
        Graphics2D g = (Graphics2D) panel.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x, y;
        for (Nodo vertice : grafo.getVertices()) {
            pintarVertice(g, vertice, Color.blue);
        }
        for (Nodo vertice : grafo.getVertices()) {
            for (Arista arista : vertice.getAristas()) {
                pintarArista(panel.getGraphics(), vertice, arista.getNodo(), false);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pintarGrafo();
        costoMinLabel.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElimarGraf;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JLabel costoMinLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> listaOpciones;
    private javax.swing.JLabel mapaImagen;
    private javax.swing.JPanel panel;
    private javax.swing.JToggleButton visButton;
    // End of variables declaration//GEN-END:variables

}
