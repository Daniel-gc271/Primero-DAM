package gcdani271.yt;

import static org.lwjgl.opengl.GL11.*;

public class HudRenderer {

    private final StbFont font;

    public HudRenderer(StbFont font) {
        this.font = font;
    }

    public void begin2D(int width, int height) {

        glDisable(GL_TEXTURE_2D);
        glColor4f(0f, 0f, 0f, 0.35f);
        glBegin(GL_QUADS);
        glVertex2f(0, 0);
        glVertex2f(width, 60);
        glVertex2f(width, 0);
        glVertex2f(0, 60);
        glEnd();
        glEnable(GL_TEXTURE_2D);

        glMatrixMode(GL_PROJECTION);
        glPushMatrix();
        glLoadIdentity();
        glOrtho(0, width, height, 0, -1, 1);

        glMatrixMode(GL_MODELVIEW);
        glPushMatrix();
        glLoadIdentity();

        glDisable(GL_DEPTH_TEST);
    }

    public void end2D() {
        glEnable(GL_DEPTH_TEST);

        glMatrixMode(GL_MODELVIEW);
        glPopMatrix();

        glMatrixMode(GL_PROJECTION);
        glPopMatrix();
    }

    public void drawText(float x, float y, String text) {
        font.drawText(x, y, text, 1f, 1f, 1f, 1f);
    }
}