package gcdani271.yt;

import static org.lwjgl.opengl.GL11.*;

public class CubeRenderer {

    public void drawCube() {
        glBegin(GL_QUADS);

        // Frente (rojo)
        glColor3f(1, 0, 0);
        glVertex3f(-1, -1,  1);
        glVertex3f( 1, -1,  1);
        glVertex3f( 1,  1,  1);
        glVertex3f(-1,  1,  1);

        // Atrás (verde)
        glColor3f(0, 1, 0);
        glVertex3f(-1, -1, -1);
        glVertex3f(-1,  1, -1);
        glVertex3f( 1,  1, -1);
        glVertex3f( 1, -1, -1);

        // Izquierda (azul)
        glColor3f(0, 0, 1);
        glVertex3f(-1, -1, -1);
        glVertex3f(-1, -1,  1);
        glVertex3f(-1,  1,  1);
        glVertex3f(-1,  1, -1);

        // Derecha (amarillo)
        glColor3f(1, 1, 0);
        glVertex3f( 1, -1, -1);
        glVertex3f( 1,  1, -1);
        glVertex3f( 1,  1,  1);
        glVertex3f( 1, -1,  1);

        // Arriba (magenta)
        glColor3f(1, 0, 1);
        glVertex3f(-1, 1,  1);
        glVertex3f( 1, 1,  1);
        glVertex3f( 1, 1, -1);
        glVertex3f(-1, 1, -1);

        // Abajo (cyan)
        glColor3f(0, 1, 1);
        glVertex3f(-1, -1,  1);
        glVertex3f(-1, -1, -1);
        glVertex3f( 1, -1, -1);
        glVertex3f( 1, -1,  1);

        glEnd();
    }
}
