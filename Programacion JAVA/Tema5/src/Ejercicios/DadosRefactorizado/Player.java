/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.DadosRefactorizado;

/**
 *
 * @author goncalda
 */
public class Player {

    //Artributos
    private int bote;
    private int tirada;
    private int contVictorias;
    private int apuesta;
    private boolean miTurno;
    private String nombre;

    //Constructor
    public Player() {
        this.contVictorias = 0;
        this.apuesta = 15;
        this.bote = 100;
        this.nombre = "CPU";
    }
    
    public Player(String nombre) {
        this.contVictorias = 0;
        this.apuesta = 15;
        this.bote = 100;
        this.nombre = nombre.trim();
    }

    public Player(int boteInicial, int apuesta) {
        this.contVictorias = 0;
        this.bote = boteInicial;
        this.apuesta = apuesta;
        this.nombre = "CPU";
    }
    
    public Player(String nombre, int boteInicial, int apuesta) {
        this.contVictorias = 0;
        this.bote = boteInicial;
        this.apuesta = apuesta;
        this.nombre = nombre.trim();
    }

    //Metodos
    //Devuelve la cuenta de las victorias del objeto
    public int getVictorias() {
        return this.contVictorias;
    }
    //Incrementa la cuenta de las victorias del objeto

    public void incVivtorias() {
        this.contVictorias++;
    }
    //Devuelve el bote del objeto

    public int getBote() {
        return this.bote;
    }
    //Devuelve la apuesta del objeto

    public int getApuesta() {
        return this.apuesta;
    }
    //Devuelve el nombre del objeto

    public String getName() {
        return this.nombre;
    }
    //Incrementa el bote del objeto segun la apuesta

    public void incBote(int apuesta) {
        this.bote += apuesta;
    }
    //Decrementa el bote del objeto segun la apuesta
    //La apuesta es la cantidad que se arriesga uno en cada partida
    //Aunque siempre suele ser igual para todos, puede ser que alguin se deje mas facil

    public void decBote() {
        this.bote -= this.apuesta;
    }
    //Devuelve si le toca al objeto 
    //(true: Si es su turno)
    //(false: No es su turno)
    public boolean getTurno() {
        return miTurno;
    }
    //Muestra las estadisticas actuales de la partida
    public void showCurrentStats(Player humano,Player maquina) {
        int boteJ = humano.getBote();
        int boteM = maquina.getBote();
        int victoriasJ = humano.getVictorias();
        int victoriasM = maquina.getVictorias();
        String nombre = humano.getName();
        System.out.printf("Bote de %s: ",nombre );
    }

}
