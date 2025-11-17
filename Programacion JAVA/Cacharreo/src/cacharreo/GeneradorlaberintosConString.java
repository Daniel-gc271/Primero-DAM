package cacharreo;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * @author Daniel González
 */
public class GeneradorlaberintosConString extends JFrame {
    private VisualizadorLaberinto panelLaberinto;
    private char[][] laberintoActual;
    private int tamaño = 32;
    private int iteraciones = (int) Math.pow(tamaño, 3);
    private final Random numAleatorio = new Random();
    private JLabel infoLabel;
    private JScrollPane scrollPane;

    public GeneradorlaberintosConString() {
        setTitle("Visualización del Laberinto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Generar laberinto inicial
        laberintoActual = generarNuevoLaberinto(tamaño, iteraciones);

        // Panel con scroll
        panelLaberinto = new VisualizadorLaberinto(laberintoActual);
        scrollPane = new JScrollPane(panelLaberinto);

        // Panel lateral (sidebar)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(250, getHeight()));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campos y controles
        JTextField tamañoField = new JTextField(String.valueOf(tamaño), 3); // mucho más pequeño
        JTextField iteracionesField = new JTextField(String.valueOf(iteraciones), 6);
        iteracionesField.setEnabled(false);

        JCheckBox overrideCheck = new JCheckBox("Override iteraciones");
        overrideCheck.addActionListener(e -> iteracionesField.setEnabled(overrideCheck.isSelected()));

        JButton resetZoomBtn = new JButton("Resetear zoom");
        resetZoomBtn.addActionListener(e -> panelLaberinto.resetZoom());

        JButton centrarBtn = new JButton("Ir al centro");
        centrarBtn.addActionListener(e -> centrarVista());

        // Slider para zoom
        JLabel zoomLabel = new JLabel("Zoom:");
        JSlider zoomSlider = new JSlider(5, 100, 20);
        zoomSlider.setMajorTickSpacing(20);
        zoomSlider.setMinorTickSpacing(5);
        zoomSlider.setPaintTicks(true);
        zoomSlider.setPaintLabels(true);
        zoomSlider.addChangeListener(e -> panelLaberinto.setZoom(zoomSlider.getValue()));

        // Botones para mover el laberinto
        JPanel movePanel = new JPanel(new GridLayout(2, 3, 5, 5));
        JButton upBtn = new JButton("↑");
        JButton downBtn = new JButton("↓");
        JButton leftBtn = new JButton("←");
        JButton rightBtn = new JButton("→");

        upBtn.addActionListener(e -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() - 50));
        downBtn.addActionListener(e -> scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() + 50));
        leftBtn.addActionListener(e -> scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue() - 50));
        rightBtn.addActionListener(e -> scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue() + 50));

        movePanel.add(new JLabel());
        movePanel.add(upBtn);
        movePanel.add(new JLabel());
        movePanel.add(leftBtn);
        movePanel.add(downBtn);
        movePanel.add(rightBtn);

        infoLabel = new JLabel();
        actualizarInfo();

        // Botón para generar laberinto (al final)
        JButton nuevoBtn = new JButton("Generar nuevo laberinto");
        nuevoBtn.addActionListener(e -> {
            try {
                tamaño = Integer.parseInt(tamañoField.getText());
                if (overrideCheck.isSelected()) {
                    iteraciones = Integer.parseInt(iteracionesField.getText());
                } else {
                    iteraciones = (int) Math.pow(tamaño, 3);
                }
                laberintoActual = generarNuevoLaberinto(tamaño, iteraciones);
                panelLaberinto.setLaberinto(laberintoActual);
                actualizarInfo();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores inválidos.");
            }
        });

        // Añadir componentes al sidebar
        sidebar.add(new JLabel("Tamaño:"));
        sidebar.add(tamañoField);
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(overrideCheck);
        sidebar.add(new JLabel("Iteraciones:"));
        sidebar.add(iteracionesField);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(resetZoomBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(centrarBtn);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(zoomLabel);
        sidebar.add(zoomSlider);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(new JLabel("Mover laberinto:"));
        sidebar.add(movePanel);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(infoLabel);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(nuevoBtn); // Botón al final

        // SplitPane para dividir la ventana
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, sidebar);
        splitPane.setDividerLocation(700);
        splitPane.setResizeWeight(1.0);
        add(splitPane, BorderLayout.CENTER);

        configurarScrollConFlechas();

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configurarScrollConFlechas() {
        scrollPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "scrollUp");
        scrollPane.getActionMap().put("scrollUp", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() - 20);
            }
        });
        scrollPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "scrollDown");
        scrollPane.getActionMap().put("scrollDown", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() + 20);
            }
        });
        scrollPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "scrollLeft");
        scrollPane.getActionMap().put("scrollLeft", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue() - 20);
            }
        });
        scrollPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "scrollRight");
        scrollPane.getActionMap().put("scrollRight", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue() + 20);
            }
        });
    }

    private void centrarVista() {
        JScrollBar hBar = scrollPane.getHorizontalScrollBar();
        JScrollBar vBar = scrollPane.getVerticalScrollBar();
        hBar.setValue((hBar.getMaximum() - hBar.getVisibleAmount()) / 2);
        vBar.setValue((vBar.getMaximum() - vBar.getVisibleAmount()) / 2);
    }

    private void actualizarInfo() {
        infoLabel.setText("<html><b>Tamaño:</b> " + tamaño + "<br><b>Iteraciones:</b> " + iteraciones + "</html>");
    }

    private char[][] generarNuevoLaberinto(int grado, int iteraciones) {
        char[][] vectoresUnidos = new char[grado][grado];
        for (int i = 0; i < vectoresUnidos.length; i++) {
            for (int j = 0; j < vectoresUnidos[0].length; j++) {
                if (j != vectoresUnidos[0].length - 1) {
                    vectoresUnidos[i][j] = 'D';
                }
                if (j == vectoresUnidos.length - 1) {
                    vectoresUnidos[i][j] = 'S';
                }
            }
        }
        vectoresUnidos[vectoresUnidos.length - 1][vectoresUnidos[0].length - 1] = 'O';
        return generarlaberinto(vectoresUnidos, numAleatorio, iteraciones);
    }

    private static char[][] generarlaberinto(char[][] laberinto, Random numAleatorio, int iteraciones) {
        int oI = 0, oJ = 0, contIteraciones = 0, mov = 0;
        while (contIteraciones <= iteraciones) {
            for (int i = 0; i < laberinto.length; i++) {
                for (int j = 0; j < laberinto[0].length; j++) {
                    if (laberinto[i][j] == 'O') {
                        oI = i;
                        oJ = j;
                        break;
                    }
                }
            }
            mov = numAleatorio.nextInt(4);
            if (oJ - 1 >= 0 && mov == 0) {
                laberinto[oI][oJ] = 'A';
                laberinto[oI][oJ - 1] = 'O';
                contIteraciones++;
            }
            if (oJ + 1 < laberinto[0].length && mov == 1) {
                laberinto[oI][oJ + 1] = 'O';
                laberinto[oI][oJ] = 'D';
                contIteraciones++;
            }
            if (oI - 1 >= 0 && mov == 2) {
                laberinto[oI][oJ] = 'W';
                laberinto[oI - 1][oJ] = 'O';
                contIteraciones++;
            }
            if (oI + 1 < laberinto[0].length && mov == 3) {
                laberinto[oI + 1][oJ] = 'O';
                laberinto[oI][oJ] = 'S';
                contIteraciones++;
            }
        }
        return laberinto;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GeneradorlaberintosConString::new);
    }
}

class VisualizadorLaberinto extends JPanel {
    private char[][] laberinto;
    private int cellSize = 20; // tamaño inicial
    private final int puntoSize = 6;

    public VisualizadorLaberinto(char[][] laberinto) {
        this.laberinto = laberinto;

        // Zoom con la rueda del ratón
        addMouseWheelListener(e -> {
            if (e.getPreciseWheelRotation() < 0) {
                cellSize = Math.min(cellSize + 2, 100); // zoom in
            } else {
                cellSize = Math.max(cellSize - 2, 5); // zoom out
            }
            revalidate();
            repaint();
        });
    }

    public void setLaberinto(char[][] laberinto) {
        this.laberinto = laberinto;
        revalidate();
        repaint();
    }

    public void resetZoom() {
        cellSize = 20;
        revalidate();
        repaint();
    }

    public void setZoom(int zoomValue) {
        cellSize = zoomValue;
        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        if (laberinto == null) return new Dimension(400, 400);
        return new Dimension(laberinto[0].length * cellSize, laberinto.length * cellSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (laberinto == null) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        int filas = laberinto.length;
        int columnas = laberinto[0].length;

        // Dibujar cuadrícula
        g2.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= filas; i++) {
            g2.drawLine(0, i * cellSize, columnas * cellSize, i * cellSize);
        }
        for (int j = 0; j <= columnas; j++) {
            g2.drawLine(j * cellSize, 0, j * cellSize, filas * cellSize);
        }

        // Dibujar contenido
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int x = j * cellSize + cellSize / 2;
                int y = i * cellSize + cellSize / 2;

                // Si es el origen, pintar celda amarilla
                if (laberinto[i][j] == 'O') {
                    g2.setColor(Color.YELLOW);
                    g2.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }

                g2.setColor(Color.BLACK);
                g2.fillOval(x - puntoSize / 2, y - puntoSize / 2, puntoSize, puntoSize);

                char dir = laberinto[i][j];
                switch (dir) {
                    case 'W': drawArrow(g2, x, y, x, y - cellSize); break;
                    case 'S': drawArrow(g2, x, y, x, y + cellSize); break;
                    case 'A': drawArrow(g2, x, y, x - cellSize, y); break;
                    case 'D': drawArrow(g2, x, y, x + cellSize, y); break;
                    case 'O': g2.drawString("O", x - 4, y + 4); break;
                }
            }
        }
    }

    private void drawArrow(Graphics2D g2, int x1, int y1, int x2, int y2) {
        g2.drawLine(x1, y1, x2, y2);
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int arrowSize = 6;
        int xArrow1 = (int) (x2 - arrowSize * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - arrowSize * Math.sin(angle - Math.PI / 6));
        int xArrow2 = (int) (x2 - arrowSize * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - arrowSize * Math.sin(angle + Math.PI / 6));
        g2.drawLine(x2, y2, xArrow1, yArrow1);
        g2.drawLine(x2, y2, xArrow2, yArrow2);
    }
}