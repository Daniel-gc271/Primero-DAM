/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.DadosRefactorizado;

/**
 *
 * @author goncalda
 */
public class Banca {

    //Atributos
    private boolean turno;
    private boolean esTiradaSalida;
    private int turnosJugados;
    private long tiempoInicio;
    private long tiempoSalida;
    private int bote;

    //Constructores
    public Banca() {
        this.tiempoInicio = System.currentTimeMillis();
        this.bote = 0;
        this.turnosJugados = 0;
        this.tiempoInicio = System.currentTimeMillis();
    }

    //Metodos
    //Invierte el turno
    public void cambiarTurno() {
        this.turno = !this.turno;
    }

    //Fija el turno
    public void setTurno(Boolean _turno) {
        this.turno = _turno;
    }

    //Devuelve el turno
    public boolean getTurno() {
        return this.turno;
    }

    //Fija la bandera de salida
    public void setTiradaSalida(Boolean _esTiradaSalida) {
        this.esTiradaSalida = _esTiradaSalida;
    }

    //Devuelve la bandera de salida
    public boolean getTiradaSalida() {
        return this.esTiradaSalida;
    }
    public void incTurnosJugados() {
        ++this.turnosJugados;
    }

    //Cuando gana la banca, el jugador ve disminuido su bote
    //La banca recibe ese dinero
    public void victoria(Player _rival) {
        this.bote += _rival.getApuesta();
        _rival.decBote();
        this.cambiarTurno();
    }

    //Muestra las estadisticas actuales de la partida
    public void showCurrentStats(Player _humano, Player _maquina) {
        int boteJ = _humano.getBote();
        int boteM = _maquina.getBote();
        int victoriasJ = _humano.getVictorias();
        int victoriasM = _maquina.getVictorias();
        String nombreJ = _humano.getName();
        String nombreM = _maquina.getName();
        String mensaje = new String().format(
                ""
                + "Turnos jugados: %d"
                + "\nBote de %s: %d\tBote de %s: %d"
                + "\nVictorias de %s: %d\tVictorias de %s: %d\n",
                this.turnosJugados,
                nombreJ, boteJ,
                nombreM, boteM,
                nombreJ, victoriasJ,
                nombreM, victoriasM);
        System.out.println(mensaje);
    }

    public void showImediateVictoryMsg(Player _ganador, Player _perdedor, int _tirada) {
        String mensaje = new String();
                mensaje= mensaje.format(""
                + "%s ha sacado un %d.\n"
                + "Significa una victoria automatica. Enhorabuena %s!\n",
                
                _ganador.getName(),
                _tirada,_ganador.getName());
                showCurrentStats(_ganador, _perdedor);
                
                
                System.out.println(mensaje);
                
    }

    public void showImediateLostMsg(Player _ganador, Player _perdedor, int _tirada) {
        String mensaje = new String().format(""
                + "%s ha sacado un %d.\n"
                + "Significa una derrota automatica.\n"
                + "Gana %s, enhorabuena\n",
                _perdedor.getName(),
                _tirada,
                _ganador.getName());
                 showCurrentStats(_ganador, _perdedor);
                System.out.println(mensaje);
    }

    public void showRegularLostMsg(Player _jugadorActual) {
        String mensaje = new String().format(""
                + "%s Ha sacado un 7 y ha perdido en su turno.\n"
                + "Por ende, gana la banca\n"
                + "El bote de %s asciende a: %d\n",
                _jugadorActual.getName(),
                _jugadorActual.getBote()
            
            
            );             
                
                
                System.out.println(mensaje);
    }

}
