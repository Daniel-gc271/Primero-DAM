package gcdani271.yt;

public class Quad {
    // Plano: axis = 0(X),1(Y),2(Z). dir = +1 o -1 (normal)
    public int axis, dir;
    // Origen del quad en coordenadas de VOXEL (no escaladas)
    public int x, y, z;
    // Tamaño del rectángulo en las otras dos direcciones (voxels)
    public int w, h;
    // Tipo de bloque (para color/textura en el futuro)
    public int type;

    public Quad(int axis, int dir, int x, int y, int z, int w, int h, int type) {
        this.axis = axis; this.dir = dir;
        this.x = x; this.y = y; this.z = z;
        this.w = w; this.h = h;
        this.type = type;
    }
}