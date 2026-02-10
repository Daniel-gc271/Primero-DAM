package gcdani271.yt;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class ChunkMesh {
    public final List<Quad> quads = new ArrayList<>();

    // Render inmediato para enseñar (cada quad como GL_QUADS)
    // scale = tamaño del voxel en unidades de mundo (tú usas 2f)
    // baseX, baseZ = offset del chunk en voxels (NO en unidades de mundo)
    public void render(float scale, int baseXvox, int baseZvox) {
        glBegin(GL_QUADS);
        for (Quad q : quads) {
            // Color simple por tipo (luego meteremos texturas)
            switch (q.type) {
                case 1: glColor3f(0.7f, 0.7f, 0.7f); break; // piedra
                case 2: glColor3f(0.3f, 0.8f, 0.3f); break; // hierba
                case 3: glColor3f(0.5f, 0.4f, 0.3f); break; // tierra
                default: glColor3f(1f, 1f, 1f);
            }

            // Coordenadas en voxels → a unidades de mundo
            // OJO: baseXvox y baseZvox están en VOXELS; multiplicamos todo por 'scale'
            float sx = (baseXvox + q.x) * scale;
            float sy = (q.y) * scale;
            float sz = (baseZvox + q.z) * scale;

            float du1 = 0, dv1 = 0, du2 = 0, dv2 = 0;
            // u y v: las dos dimensiones del rectángulo
            // Emitimos con CCW dependiendo de axis/dir
            if (q.axis == 0) { // plano X (vertical), u=z, v=y
                float x = (q.dir > 0) ? (sx + scale) : sx; // cara en X o X+1 (en mundo)
                float y0 = sy,              y1 = sy + q.h * scale;
                float z0 = sz,              z1 = sz + q.w * scale;

                if (q.dir > 0) {
                    vertex(x, y0, z0);
                    vertex(x, y1, z0);
                    vertex(x, y1, z1);
                    vertex(x, y0, z1);
                } else {
                    vertex(x, y0, z1);
                    vertex(x, y1, z1);
                    vertex(x, y1, z0);
                    vertex(x, y0, z0);
                }
            } else if (q.axis == 1) { // plano Y (horizontal), u=x, v=z
                float y = (q.dir > 0) ? (sy + scale) : sy;
                float x0 = sx,              x1 = sx + q.w * scale;
                float z0 = sz,              z1 = sz + q.h * scale;

                if (q.dir > 0) {
                    vertex(x0, y, z0);
                    vertex(x0, y, z1);
                    vertex(x1, y, z1);
                    vertex(x1, y, z0);
                } else {
                    vertex(x1, y, z0);
                    vertex(x1, y, z1);
                    vertex(x0, y, z1);
                    vertex(x0, y, z0);
                }
            } else { // axis == 2, plano Z, u=x, v=y
                float z = (q.dir > 0) ? (sz + scale) : sz;
                float x0 = sx,              x1 = sx + q.w * scale;
                float y0 = sy,              y1 = sy + q.h * scale;

                if (q.dir > 0) {
                    vertex(x1, y0, z);
                    vertex(x1, y1, z);
                    vertex(x0, y1, z);
                    vertex(x0, y0, z);
                } else {
                    vertex(x0, y0, z);
                    vertex(x0, y1, z);
                    vertex(x1, y1, z);
                    vertex(x1, y0, z);
                }
            }
        }
        glEnd();
    }

    private void vertex(float x, float y, float z) { glVertex3f(x, y, z); }
}