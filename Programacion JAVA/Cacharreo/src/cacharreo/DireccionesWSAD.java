package cacharreo;

import javax.swing.*;
import java.awt.*;

public class DireccionesWSAD extends JPanel {
    private final char[][] matriz;
    private final int puntoSize = 10;
    private final int cellSize = 60;

    public DireccionesWSAD(char[][] matriz) {
        this.matriz = matriz;
        setPreferredSize(new Dimension(matriz[0].length * cellSize, matriz.length * cellSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setFont(new Font("Arial", Font.BOLD, 14));

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int x = j * cellSize + cellSize / 2;
                int y = i * cellSize + cellSize / 2;

                // Dibuja el punto
                g2.setColor(Color.BLACK);
                g2.fillOval(x - puntoSize / 2, y - puntoSize / 2, puntoSize, puntoSize);

                // Dibuja la flecha según el carácter
                char dir = matriz[i][j];
                g2.setColor(Color.BLUE);
                switch (dir) {
                    case 'W': // Arriba
                        drawArrow(g2, x, y, x, y - cellSize);
                        break;
                    case 'S': // Abajo
                        drawArrow(g2, x, y, x, y + cellSize);
                        break;
                    case 'A': // Izquierda
                        drawArrow(g2, x, y, x - cellSize, y);
                        break;
                    case 'D': // Derecha
                        drawArrow(g2, x, y, x + cellSize, y);
                        break;
                }
            }
        }
    }

    private void drawArrow(Graphics2D g2, int x1, int y1, int x2, int y2) {
        g2.drawLine(x1, y1, x2, y2);
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int arrowSize = 10;
        int xArrow1 = (int) (x2 - arrowSize * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - arrowSize * Math.sin(angle - Math.PI / 6));
        int xArrow2 = (int) (x2 - arrowSize * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - arrowSize * Math.sin(angle + Math.PI / 6));
        g2.drawLine(x2, y2, xArrow1, yArrow1);
        g2.drawLine(x2, y2, xArrow2, yArrow2);
    }

    public static void main(String[] args) {
         String[][] maStringses = {{"O", "A", "A", "A"}, {"W", "W", "W", "W"}, {"W", "W", "W", "W"}, {"W", "W", "W", "W"}};

        JFrame frame = new JFrame("Mapa WSAD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}