package gcdani271.yt;

/**
 * Greedy meshing tipo "Mikola Lysenko".
 * Genera quads grandes fusionando caras coplanares contiguas.
 * Trabaja en unidades de VOXEL (no en mundo). El escalado lo hace ChunkMesh.
 */
public class GreedyMesher {

    // Devuelve una malla para un chunk concreto. Usa 'world' para ver vecinos de otros chunks.
    public static ChunkMesh build(World world, Chunk chunk) {

        final int SX = Chunk.SIZE, SY = Chunk.SIZE, SZ = Chunk.SIZE;

        // Volumen absoluto (en coords de voxel "globales")
        final int baseX = chunk.chunkX * SX;
        final int baseZ = chunk.chunkZ * SZ;

        ChunkMesh mesh = new ChunkMesh();

        // Recorremos las 3 direcciones (0=X,1=Y,2=Z)
        for (int axis = 0; axis < 3; axis++) {
            int u = (axis + 1) % 3;
            int v = (axis + 2) % 3;

            int[] dims = {SX, SY, SZ};
            int du = dims[u];
            int dv = dims[v];
            int dw = dims[axis];

            // Para cada capa (w) vamos a construir una "máscara" de caras visibles
            // y luego fusionarla en rectángulos.
            int[][] mask = new int[du][dv]; // signo = dir, abs = tipo

            for (int w = 0; w <= dw; w++) {

                // 1) Construir máscara
                for (int i = 0; i < du; i++) {
                    for (int j = 0; j < dv; j++) {
                        int[] a = {0,0,0};
                        int[] b = {0,0,0};

                        // voxel A (w-1) y B (w)
                        index(axis, u, v, w-1, i, j, a);
                        index(axis, u, v, w,   i, j, b);

                        int va = voxel(world, baseX, baseZ, a[0], a[1], a[2]);
                        int vb = voxel(world, baseX, baseZ, b[0], b[1], b[2]);

                        int val = 0;
                        if ((va != 0 || vb != 0) && va != vb) {
                            // si vb != 0 → cara con normal +axis; si va != 0 → normal -axis
                            val = (vb != 0) ?  vb : -va;
                        }
                        mask[i][j] = val;
                    }
                }

                // 2) Greedy merge de la máscara en rectángulos
                int i = 0;
                while (i < du) {
                    int j = 0;
                    while (j < dv) {
                        int val = mask[i][j];
                        if (val != 0) {
                            int type = Math.abs(val);
                            int dir = (val > 0) ? +1 : -1;

                            // anchura
                            int wlen = 1;
                            while (i + wlen < du && mask[i + wlen][j] == val) wlen++;

                            // altura
                            int hlen = 1;
                            outer:
                            while (j + hlen < dv) {
                                for (int k = 0; k < wlen; k++) {
                                    if (mask[i + k][j + hlen] != val) break outer;
                                }
                                hlen++;
                            }

                            // Apagar la máscara usada
                            for (int di = 0; di < wlen; di++) {
                                for (int dj = 0; dj < hlen; dj++) {
                                    mask[i + di][j + dj] = 0;
                                }
                            }

                            // Convertir (w, i, j) en (x,y,z) locales al chunk
                            int lx=0, ly=0, lz=0;
                            if (axis == 0) { // X
                                lx = (dir > 0) ? w : w - 1;
                                ly = i;
                                lz = j;
                            } else if (axis == 1) { // Y
                                lx = i;
                                ly = (dir > 0) ? w : w - 1;
                                lz = j;
                            } else { // Z
                                lx = i;
                                ly = j;
                                lz = (dir > 0) ? w : w - 1;
                            }

                            // El quad empieza en (lx,ly,lz) y ocupa wlen x hlen en (u,v)
                            int qx = lx, qy = ly, qz = lz;
                            int qw = wlen, qh = hlen;

                            // ¡Añadirlo!
                            mesh.quads.add(new Quad(axis, dir, qx, qy, qz, qw, qh, type));
                            
                            j += hlen;
                        } else {
                            j++;
                        }
                    }
                    i++;
                }
            }
        }

        return mesh;
    }

    // Convierte (axis,u,v) + (w,i,j) → (x,y,z)
    private static void index(int axis, int u, int v, int w, int i, int j, int[] out) {
        out[axis] = w;
        out[u] = i;
        out[v] = j;
    }

    // Obtiene el voxel en coords de chunk local, pero mirando vecinos en 'world'.
    // baseX/baseZ son el offset del chunk en VOXELS (no en mundo).
    private static int voxel(World world, int baseX, int baseZ, int lx, int ly, int lz) {
        // Si estamos fuera del rango del chunk actual, consultamos al world.
        if (lx < 0 || lx >= Chunk.SIZE || ly < 0 || ly >= Chunk.SIZE || lz < 0 || lz >= Chunk.SIZE) {
            int gx = baseX + lx;
            int gz = baseZ + lz;
            return world.getBlockGlobal(gx, ly, gz);
        } else {
            return world.currentBlockInBuild(lx, ly, lz); // world fijará temporalmente el chunk en build
        }
    }
}