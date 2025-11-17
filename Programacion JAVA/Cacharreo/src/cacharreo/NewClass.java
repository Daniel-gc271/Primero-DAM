import javax.swing.*;
import java.awt.*;

class VisualizadorLaberinto extends JPanel {
    private final char[][] laberinto;
    private final int cellSize = 20;
    private final int puntoSize = 6;

    public VisualizadorLaberinto(char[][] laberinto) {
        this.laberinto = laberinto;
        setPreferredSize(new Dimension(laberinto[0].length * cellSize, laberinto.length * cellSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                int x = j * cellSize + cellSize / 2;
                int y = i * cellSize + cellSize / 2;

                // Dibuja el punto
                g2.setColor(Color.BLACK);
                g2.fillOval(x - puntoSize / 2, y - puntoSize / 2, puntoSize, puntoSize);

                char dir = laberinto[i][j];
                g2.setColor(Color.BLUE);

                switch (dir) {
                    case 'W': drawArrow(g2, x, y, x, y - cellSize); break;
                    case 'S': drawArrow(g2, x, y, x, y + cellSize); break;
                    case 'A': drawArrow(g2, x, y, x - cellSize, y); break;
                    case 'D': drawArrow(g2, x, y, x + cellSize, y); break;
                    case 'O': // Marca especial
                        g2.setColor(Color.RED);
                        g2.drawString("O", x - 4, y + 4);
                        break;
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
