package gcdani271.yt;

public class Chunk {

    public static final int SIZE = 16;

    public final int chunkX, chunkZ; // coordenadas de chunk (en voxels, no en mundo)
    public final int[][][] blocks = new int[SIZE][SIZE][SIZE];

    public ChunkMesh mesh;

    public Chunk(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        generate();
    }

   
private void generate() {
        // Suelo plano y algo de "ruido" para verlo
        for (int x = 0; x < SIZE; x++) {
            for (int z = 0; z < SIZE; z++) {
                blocks[x][0][z] = 2; // hierba
                if (Math.random() < 0.08) {
                    int h = 1 + (int)(Math.random()*4);
                    for (int y = 1; y < Math.min(SIZE, h); y++) {
                        blocks[x][y][z] = 1; // piedra
                    }
                }
            }
        }
    }


    public int getBlock(int x, int y, int z) {
        return blocks[x][y][z];
    }

    public int worldX() {
        return chunkX * SIZE * 2; // *2 porque tu cubo mide 2
    }

    public int worldZ() {
        return chunkZ * SIZE * 2;
    }
}
