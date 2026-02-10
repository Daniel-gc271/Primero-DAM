package gcdani271.yt;

import static org.lwjgl.opengl.GL11.*;

public class CrosshairRenderer {

    public void drawCrosshair(int width, int height) {

        // Guardar estado
        glPushMatrix();
        glLoadIdentity();

        // Cambiar a modo 2D (ortográfico)
        glMatrixMode(GL_PROJECTION);
        glPushMatrix();
        glLoadIdentity();
        glOrtho(0, width, height, 0, -1, 1);

        glMatrixMode(GL_MODELVIEW);
        glPushMatrix();
        glLoadIdentity();

        glDisable(GL_DEPTH_TEST);

        glColor3f(1f, 1f, 1f); // blanco

        int cx = width / 2;
        int cy = height / 2;

        int size = 10; // tamaño de la cruz

        glBegin(GL_LINES);

        // Línea horizontal
        glVertex2f(cx - size, cy);
        glVertex2f(cx + size, cy);

        // Línea vertical
        glVertex2f(cx, cy - size);
        glVertex2f(cx, cy + size);

        glEnd();

        glEnable(GL_DEPTH_TEST);

        // Restaurar matrices
        glMatrixMode(GL_PROJECTION);
        glPopMatrix();

        glMatrixMode(GL_MODELVIEW);
        glPopMatrix();

        glPopMatrix();
    }
}