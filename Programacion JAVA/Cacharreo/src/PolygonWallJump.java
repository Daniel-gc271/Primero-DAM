import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PolygonWallJump extends JPanel implements KeyListener {
    private int[] xPoints = {50, 150, 200, 100};
    private int[] yPoints = {50, 50, 150, 200};
    private int nPoints = xPoints.length;

    private int dx = 0; // movimiento horizontal
    private double dy = 0; // velocidad vertical
    private double gravity = 0.8;
    private double jumpStrength = -12;
    private boolean onGround = false;
    private boolean onLeftWall = false;
    private boolean onRightWall = false;

    public PolygonWallJump() {
        setFocusable(true);
        addKeyListener(this);

        Timer timer = new Timer(20, e -> update());
        timer.start();
    }

    private void update() {
        // Movimiento horizontal
        for (int i = 0; i < nPoints; i++) {
            xPoints[i] += dx;
        }

        // Aplicar gravedad
        dy += gravity;
        for (int i = 0; i < nPoints; i++) {
            yPoints[i] += dy;
        }

        // Detectar suelo
        int bottom = getHeight();
        int maxY = getMaxY();
        if (maxY >= bottom) {
            double offset = maxY - bottom;
            for (int i = 0; i < nPoints; i++) {
                yPoints[i] -= offset;
            }
            dy = 0;
            onGround = true;
        } else {
            onGround = false;
        }

        // Detectar paredes
        int minX = getMinX();
        int maxX = getMaxX();
        onLeftWall = false;
        onRightWall = false;

        if (minX <= 0) {
            int offset = -minX;
            for (int i = 0; i < nPoints; i++) {
                xPoints[i] += offset;
            }
            onLeftWall = true;
        }
        if (maxX >= getWidth()) {
            int offset = maxX - getWidth();
            for (int i = 0; i < nPoints; i++) {
                xPoints[i] -= offset;
            }
            onRightWall = true;
        }

        repaint();
    }

    private int getMaxY() {
        int max = yPoints[0];
        for (int y : yPoints) if (y > max) max = y;
        return max;
    }

    private int getMinX() {
        int min = xPoints[0];
        for (int x : xPoints) if (x < min) min = x;
        return min;
    }

    private int getMaxX() {
        int max = xPoints[0];
        for (int x : xPoints) if (x > max) max = x;
        return max;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillPolygon(xPoints, yPoints, nPoints);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A: dx = -5; break;
            case KeyEvent.VK_D: dx = 5; break;
            case KeyEvent.VK_SPACE:
                if (onGround || onLeftWall || onRightWall) {
                    dy = jumpStrength;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
            dx = 0;
        }
    }

    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Polígono con Wall Jump");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new PolygonWallJump());
        frame.setVisible(true);
    }
}