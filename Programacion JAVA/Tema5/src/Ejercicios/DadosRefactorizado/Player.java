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
    private int punto;

    private String nombre;

    //Constructor
    public Player() {
        this.contVictorias = 0;
        this.apuesta = 15;
        this.bote = 100;
        this.nombre = "CPU";
    }

    public Player(String _nombre) {
        this.contVictorias = 0;
        this.apuesta = 15;
        this.bote = 100;
        this.nombre = _nombre.trim();
    }

    public Player(int _boteInicial, int _apuesta) {
        this.contVictorias = 0;
        this.bote = _boteInicial;
        this.apuesta = _apuesta;
        this.nombre = "CPU";
    }

    public Player(String _nombre, int _boteInicial, int _apuesta) {
        this.contVictorias = 0;
        this.bote = _boteInicial;
        this.apuesta = _apuesta;
        this.nombre = _nombre.trim();
    }

    //Metodos
    //Devuelve el punto actual del jugador
    
    public int getPunto() {
        return this.punto;
    }
    //Fija el punto actual del jugador
    
    public void setPunto(int _punto) {
        this.punto=punto;
    }

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
    //La apuesta es el dinero que va a perder
    public int getApuesta() {
        return this.apuesta;
    }
    //Devuelve el nombre del objeto

    public String getName() {
        return this.nombre;
    }
    //Incrementa el bote del objeto segun la apuesta

    public void incBote(int _apuesta) {
        this.bote += _apuesta;
    }
    //Decrementa el bote del objeto segun la apuesta
    //La apuesta es la cantidad que se arriesga uno en cada partida
    //Aunque siempre suele ser igual para todos, puede ser que alguin se deje mas facil

    public void decBote() {
        this.bote -= this.apuesta;
    }

    //Cuando un jugador gana, recibe el dinero que le corresponde
    //Se decrementa del jugador perdedor
    public void victoria(Player _rival) {
        this.bote += _rival.getApuesta();
        _rival.decBote();
        this.incVivtorias();
    }

    //Cuando el jugador es derrotado, pierde el dinero de la apuesta
    //Se lo da al jugador rival
    public void derrota(Player _rival, Banca _banca) {
        this.decBote();
        _rival.incBote(this.apuesta);
        _rival.incVivtorias();
        _banca.cambiarTurno();
    }

}
