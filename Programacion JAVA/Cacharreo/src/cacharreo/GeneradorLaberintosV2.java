/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Daniel González
 */
public class GeneradorLaberintosV2 {

    public static void main(String[] args) {
        long tEjecucion = System.currentTimeMillis();
        Laberinto lab = new Laberinto(3, 2);
        Random rd = new Random();
        System.out.println(lab.getnumFilas());
        /*lab = lab.randomizarLaberinto(lab, rd, 0xfff);
        System.out.println("Laberinto random:");
        lab.imprimirLaberinto(lab);
        tEjecucion = System.currentTimeMillis() - tEjecucion;
        System.out.printf("Tiempo de ejecucion: %dms", tEjecucion);
        /*
        if (exitX < 0 || exitX >= numFilas || exitY < 0 || exitY >= numColumnas) {
        System.err.println("La salida no se encuentra en los confines del laberinto");
        System.exit(1);
    }
        */
    }

}

class Laberinto {

    private int numFilasY;
    private int numColumnasX;
    private int oX;
    private int oY;
    private char[][] laberinto;

    public Laberinto(int columnasX, int filasY) {

        this.numFilasY = filasY;
        this.numColumnasX = columnasX;
        this.laberinto = new char[columnasX][filasY];
    }

    public int getnumFilas() {
        return numFilasY;
    }

    public int getnumColumnas() {
        return numColumnasX;
    }

    public int getoX() {
        return oX;
    }

    public int getoY() {
        return oY;
    }

    public char[][] getLaberinto() {
        return this.laberinto;
    }

    public char getCeldaLaberinto(int fila, int columna) {
        return this.laberinto[fila][columna];
    }

    public void setoX(int oX) {
        this.oX = oX;
    }

    public void setoY(int oY) {
        this.oY = oY;
    }

    public void setLaberinto(char[][] laberinto) {
        this.laberinto = laberinto;
    }

    public void setCeldaLaberinto(int fila, int columna, char caracter) {
        this.laberinto[fila][columna] = caracter;
    }

    private Laberinto crearLaberintoBase(Laberinto laberinto) {
        for (int y = 0; y < laberinto.getnumFilas(); y++) {
            for (int x = 0; x < laberinto.getnumColumnas(); x++) {
                if (y != laberinto.getnumFilas() && y >= 0) {
                    laberinto.setCeldaLaberinto(x, y, 'S');
                }

                if (x == laberinto.getnumColumnas() - 1 && x >= 0) {
                    laberinto.setCeldaLaberinto(x, y, 'D');
                }
            }
        }
        laberinto.setoX(laberinto.getnumColumnas() - 1);
        laberinto.setoY(laberinto.getnumFilas() - 1);
        laberinto.setCeldaLaberinto(laberinto.getnumColumnas() - 1, laberinto.getnumFilas() - 1, 'O');
        return laberinto;
    }

    public Laberinto randomizarLaberinto(Laberinto lab, Random numRd, int iteraciones) {
        lab = lab.crearLaberintoBase(lab);
        int oX = lab.getoX(), oY = lab.getoY();
        for (int i = 0; i <= iteraciones; i++) {
            int mov = numRd.nextInt(4);
            
        }
        lab.setoX(oX);
        lab.setoY(oY);
        return lab;
    }

    public Laberinto resolverLaberinto(Laberinto lab, int exitX, int exitY) {
        int numFilas = lab.getnumFilas(), numColumnas = lab.getnumColumnas(), oX = lab.getoX(), oY = lab.getoY();
        Laberinto distancias = new Laberinto(numFilas, numColumnas);
       
           
        
        
    
        
        
        return lab;
    }

    public void imprimirLaberinto(Laberinto lab) {
        for (int x = 0; x < lab.getnumColumnas(); x++) {
            for (int y = 0; y < lab.getnumFilas(); y++) {

                System.out.printf(" %s", lab.getLaberinto()[x][y]);
            }
            System.out.println("");
        }

    }
}
/*
    private int[][] floodFill(Laberinto lab, int salidaX, int salidaY) {
    char[][] laberinto= lab.getLaberinto();
    int numFilas = lab.getnumFilas();
    int numColumnas = lab.getnumColumnas();

    // Validación de coordenadas
    if (salidaX < 0 || salidaX >= numFilas || salidaY < 0 || salidaY >= numColumnas) {
        System.err.println("La salida no se encuentra en los confines del laberinto");
        System.exit(1);
    }

    // Inicializar matriz de distancias con -1 (no visitado)
    int[][] distanciaSalida = new int[numFilas][numColumnas];
    for (int i = 0; i < numFilas; i++) {
        for (int j = 0; j < numColumnas; j++) {
            distanciaSalida[i][j] = -1;
        }
    }

    // Cola para BFS
    java.util.Queue<int[]> cola = new java.util.LinkedList<>();
    cola.add(new int[]{salidaX, salidaY});
    distanciaSalida[salidaX][salidaY] = 0; // salida = distancia 0

    // Direcciones: arriba, abajo, izquierda, derecha
    int[][] direcciones = {{-1,0},{1,0},{0,-1},{0,1}};

    while (!cola.isEmpty()) {
        int[] actual = cola.poll();
        int x = actual[0], y = actual[1];
        int distanciaActual = distanciaSalida[x][y];

        for (int[] d : direcciones) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < numFilas && ny >= 0 && ny < numColumnas) {
                // Solo avanzar si es camino y no visitado
                if (laberinto[nx][ny] != '#' && distanciaSalida[nx][ny] == -1) {
                    distanciaSalida[nx][ny] = distanciaActual + 1;
                    cola.add(new int[]{nx, ny});
                }
            }
        }
    }

    return distanciaSalida;
}
*/