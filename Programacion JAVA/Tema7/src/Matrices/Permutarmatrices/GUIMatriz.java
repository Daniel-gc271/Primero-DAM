/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Matrices.Permutarmatrices;

import static Matrices.Permutarmatrices.App.dimensionMax;
import static Matrices.Permutarmatrices.App.dimensionMin;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bazgomjo
 */
public class GUIMatriz extends javax.swing.JFrame {

    private ButtonGroup grupoModo = new ButtonGroup();
    private Integer[][] matriz;
    private int numFilas, numColumnas;
    private DefaultTableModel modTabla;
    private JTable tabla;
    private DefaultComboBoxModel<String> modSelectorVectoresA = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> modSelectorVectoresB = new DefaultComboBoxModel<>();

    /**
     * Creates new form GUIMatriz
     */
    public GUIMatriz(Integer[][] matriz) {
        this.matriz = matriz;
        this.numFilas = matriz.length;
        this.numColumnas = matriz[0].length;
        llenaMatriz(matriz);
        modTabla = new DefaultTableModel(matriz, new Object[numColumnas]) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tabla = new JTable();
        tabla.setModel(modTabla);
        tabla.getTableHeader().setVisible(false);// quitar el encabezado de la tabla
        imprimirMatriz();
        initComponents();
        ModoFilas.setSelected(true);
        genModVect();
        setFrame();
    }

    private void setFrame() {

        grupoModo.add(ModoFilas);
        grupoModo.add(ModoColumnas);
        String tit = String.format("Matriz de: %d x %d", numFilas, numColumnas);
        this.setTitle(tit);
        JScrollPane scroll = new JScrollPane(tabla);
        this.PanelCentral.add(scroll);
        this.setPreferredSize(new Dimension(96 * numColumnas + 15, 54 * numFilas));
        SelectorA.setModel(modSelectorVectoresA);
        SelectorB.setModel(modSelectorVectoresB);
        this.pack();

        SelectorA.setModel(modSelectorVectoresA);
        SelectorB.setModel(modSelectorVectoresB);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void llenaMatriz(Integer[][] matrizParA) {
        Random rd = new Random();

        for (int i = 0; i < matrizParA.length; i++) {
            for (int j = 0; j < matrizParA[0].length; j++) {
                matrizParA[i][j] = rd.nextInt(0, 5);
            }

        }
    }

    private void imprimirMatriz() {
        for (int i = 0; i < this.numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println("");
        }
        // System.out.println(this.tabla.getColumnCount());
    }

    private void genModVect() {
        if (modSelectorVectoresA != null) {
            modSelectorVectoresA.removeAllElements();
        }
        if (modSelectorVectoresB != null) {
            modSelectorVectoresB.removeAllElements();
        }

        if (ModoColumnas.isSelected()) {
            for (int i = 0; i < this.matriz[0].length; i++) {
                modSelectorVectoresA.addElement(String.valueOf(i + 1));
                modSelectorVectoresB.addElement(String.valueOf(i + 1));
            }

        } else if (ModoFilas.isSelected()) {
            for (int i = 0; i < this.matriz.length; i++) {
                modSelectorVectoresA.addElement(String.valueOf(i + 1));
                modSelectorVectoresB.addElement(String.valueOf(i + 1));
            }

        } else {
        }
    }

    public void permutarFilas(int org, int dest) {
        Integer[] temp = this.matriz[org];
        this.matriz[org] = matriz[dest];
        this.matriz[dest] = temp;

    }

    public void permutarColumnas(int org, int dest) {
        for (int i = 0; i < matriz.length; i++) {
            Integer temp = this.matriz[i][org];
            this.matriz[i][org] = matriz[i][dest];
            this.matriz[i][dest] = temp;
        }

    }

    public void determinante(Integer[][] matriz) {
        if (matriz.length != matriz[0].length) {
            this.ResDet.setText("N/A");
        }
        int n = matriz.length;
        double[][] a = new double[n][n];

        // Copiamos los valores int → double
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = matriz[i][j];
            }
        }

        double det = 1.0;

        for (int i = 0; i < n; i++) {

            // Pivoteo parcial: buscamos el máximo en la columna i
            int maxFila = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(a[k][i]) > Math.abs(a[maxFila][i])) {
                    maxFila = k;
                }
            }

            // Si el pivote es 0 → determinante = 0
            if (Math.abs(a[maxFila][i]) < 1e-10) {
                this.ResDet.setText("0");
            }

            // Intercambiar filas si es necesario (cambia el signo del determinante)
            if (i != maxFila) {
                double[] temp = a[i];
                a[i] = a[maxFila];
                a[maxFila] = temp;

                det *= -1;   // cambio de signo
            }

            det *= a[i][i];

            // Eliminación hacia abajo
            for (int k = i + 1; k < n; k++) {
                double factor = a[k][i] / a[i][i];

                for (int j = i; j < n; j++) {
                    a[k][j] -= factor * a[i][j];
                }
            }
        }

        this.ResDet.setText(String.valueOf((long) det));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotoneraDerecha = new javax.swing.JPanel();
        ModoFilas = new javax.swing.JRadioButton();
        ModoColumnas = new javax.swing.JRadioButton();
        SelectorA = new javax.swing.JComboBox<>();
        SelectorB = new javax.swing.JComboBox<>();
        BotConfirmar = new javax.swing.JButton();
        BotCalcDet = new javax.swing.JButton();
        ResDet = new javax.swing.JLabel();
        PanelCentral = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));

        BotoneraDerecha.setMinimumSize(new java.awt.Dimension(120, 86));

        ModoFilas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ModoFilas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ModoFilas.setLabel("Filas");
        ModoFilas.setMinimumSize(new java.awt.Dimension(120, 21));
        ModoFilas.setPreferredSize(new java.awt.Dimension(50, 21));
        ModoFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModoFilasActionPerformed(evt);
            }
        });

        ModoColumnas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ModoColumnas.setLabel("Columnas");
        ModoColumnas.setMinimumSize(new java.awt.Dimension(120, 21));
        ModoColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModoColumnasActionPerformed(evt);
            }
        });

        SelectorA.setMinimumSize(new java.awt.Dimension(120, 22));

        SelectorB.setMinimumSize(new java.awt.Dimension(120, 22));

        BotConfirmar.setText("Intercambiar");
        BotConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotConfirmarActionPerformed(evt);
            }
        });

        BotCalcDet.setText("Determinante");
        BotCalcDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotCalcDetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BotoneraDerechaLayout = new javax.swing.GroupLayout(BotoneraDerecha);
        BotoneraDerecha.setLayout(BotoneraDerechaLayout);
        BotoneraDerechaLayout.setHorizontalGroup(
            BotoneraDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotoneraDerechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BotoneraDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotoneraDerechaLayout.createSequentialGroup()
                        .addComponent(ResDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotoneraDerechaLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(BotoneraDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ModoColumnas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ModoFilas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotConfirmar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(SelectorB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectorA, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))
                    .addGroup(BotoneraDerechaLayout.createSequentialGroup()
                        .addComponent(BotCalcDet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        BotoneraDerechaLayout.setVerticalGroup(
            BotoneraDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotoneraDerechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ModoFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ModoColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectorB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotCalcDet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResDet, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(BotoneraDerecha, java.awt.BorderLayout.LINE_END);

        PanelCentral.setLayout(new java.awt.BorderLayout());
        getContentPane().add(PanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModoFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModoFilasActionPerformed
        // TODO add your handling code here:
        genModVect();
        SelectorA.setModel(modSelectorVectoresA);
        SelectorB.setModel(modSelectorVectoresB);
    }//GEN-LAST:event_ModoFilasActionPerformed

    private void BotCalcDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotCalcDetActionPerformed
        // TODO add your handling code here:
        determinante(this.matriz);
    }//GEN-LAST:event_BotCalcDetActionPerformed

    private void ModoColumnasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ModoColumnasActionPerformed
        // TODO add your handling code here:
        genModVect();
        SelectorA.setModel(modSelectorVectoresA);
        SelectorB.setModel(modSelectorVectoresB);

    }// GEN-LAST:event_ModoColumnasActionPerformed

    private void BotConfirmarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BotConfirmarActionPerformed
        // TODO add your handling code here:
        System.out.println("Confirmar");
        int filaO = Integer.parseInt((String) SelectorA.getSelectedItem()) - 1;
        int filaD = Integer.parseInt((String) SelectorB.getSelectedItem()) - 1;
        if (ModoColumnas.isSelected()) {
            System.out.println("Permutar columnas");
            permutarColumnas(filaO, filaD);
            //modTabla = (DefaultTableModel) this.tabla.getModel();
            modTabla.setDataVector(matriz, new Object[numColumnas]);
        } else if (ModoFilas.isSelected()) {

            System.out.println("Permutar filas");
            permutarFilas(filaO, filaD);
            //modTabla = (DefaultTableModel) this.tabla.getModel();
            modTabla.setDataVector(matriz, new Object[numColumnas]);

        } else {
        }

    }// GEN-LAST:event_BotConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotCalcDet;
    private javax.swing.JButton BotConfirmar;
    private javax.swing.JPanel BotoneraDerecha;
    private javax.swing.JRadioButton ModoColumnas;
    private javax.swing.JRadioButton ModoFilas;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JLabel ResDet;
    private javax.swing.JComboBox<String> SelectorA;
    private javax.swing.JComboBox<String> SelectorB;
    // End of variables declaration//GEN-END:variables
}
