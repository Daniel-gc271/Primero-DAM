package gcdani271.yt;

import static org.lwjgl.opengl.GL11.*;

public class World {

    private final Chunk[][] chunks;
    private final int width, depth;

    // Para acceso rápido desde el mesher al chunk que se está construyendo
    private Chunk buildingChunk = null;

    public World(int radius) {
        this.width = radius;
        this.depth = radius;
        this.chunks = new Chunk[width][depth];

        for (int cx = 0; cx < width; cx++)
            for (int cz = 0; cz < depth; cz++)
                chunks[cx][cz] = new Chunk(cx, cz);

        buildAllMeshes();
    }

    public void buildAllMeshes() {
        for (int cx = 0; cx < width; cx++) {
            for (int cz = 0; cz < depth; cz++) {
                buildingChunk = chunks[cx][cz];
                buildingChunk.mesh = GreedyMesher.build(this, buildingChunk);
                buildingChunk = null;
            }
        }
    }

    // Acceso para GreedyMesher al bloque "local" del chunk que se está construyendo
    public int currentBlockInBuild(int lx, int ly, int lz) {
        return buildingChunk.blocks[lx][ly][lz];
    }

    // Obtener bloque en coordenadas de VOXEL "globales"
    public int getBlockGlobal(int gx, int gy, int gz) {
        if (gy < 0 || gy >= Chunk.SIZE) return 0;

        int cx = Math.floorDiv(gx, Chunk.SIZE);
        int cz = Math.floorDiv(gz, Chunk.SIZE);
        int lx = Math.floorMod(gx, Chunk.SIZE);
        int lz = Math.floorMod(gz, Chunk.SIZE);

        if (cx < 0 || cz < 0 || cx >= width || cz >= depth) return 0;

        return chunks[cx][cz].blocks[lx][gy][lz];
    }

    public void render(Camera cam, float voxelScale) {
        // Dibuja malla de cada chunk
        for (int cx = 0; cx < width; cx++) {
            for (int cz = 0; cz < depth; cz++) {
                Chunk c = chunks[cx][cz];
                if (c.mesh == null) continue;

                int baseXvox = c.chunkX * Chunk.SIZE;
                int baseZvox = c.chunkZ * Chunk.SIZE;

                glPushMatrix();
                // No traslades aquí; el mesh se encarga con baseXvox/baseZvox*scale
                c.mesh.render(voxelScale, baseXvox, baseZvox);
                glPopMatrix();
            }
        }
    }
}