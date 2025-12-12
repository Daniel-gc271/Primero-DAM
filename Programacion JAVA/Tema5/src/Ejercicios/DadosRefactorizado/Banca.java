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

    private boolean turno;
    private int turnosJugados;
    private long tiempoInicio;
    private long tiempoSalida;
    private int bote;

    public Banca() {
        this.tiempoInicio = System.currentTimeMillis();
        this.bote = 0;
        this.turnosJugados = 0;
    }

    //Invierte el turno
    public void cambiarTurno() {
        this.turno = !this.turno;
    }

    //Fija el turno
    public void establecerTurno(Boolean turno) {
        this.turno = turno;
    }

    //Devuelve el turno
    public boolean getTurno() {
        return this.turno;
    }

    //Cuando gana la banca, el jugador ve disminuido su bote
    //La banca recibe ese dinero
    public void victoria(Player rival) {
        this.bote += rival.getApuesta();
        rival.decBote();
        this.cambiarTurno();
    }

    //Muestra las estadisticas actuales de la partida
    public void showCurrentStats(Player humano, Player maquina) {
        int boteJ = humano.getBote();
        int boteM = maquina.getBote();
        int victoriasJ = humano.getVictorias();
        int victoriasM = maquina.getVictorias();
        String nombreJ = humano.getName();
        String nombreM = maquina.getName();
        String mensaje = new String().format(
                ""
                + "Turnos jugados: %d"
                + "\nBote de %s: %d\tBote de %s: %d"
                + "\nVictorias de %s: %d\tVictorias de %s: %d",
                this.turnosJugados,
                nombreJ, boteJ,
                nombreM, boteM,
                nombreJ, victoriasJ,
                nombreM, victoriasM);
        System.out.println(mensaje);
    }

    public void showImediateVictoryMsg(Player ganador, Player perdedor, int tirada) {
        String mensaje = new String().formatted(""
                + "Has sacado un %d,"
                + " significa que ganas automaticamente enhotabuena"
                + "tu bote asciende a: %d y el bote de tu rival asciende a: %d",
                tirada,
                ganador.getBote(),
                perdedor.getBote());
    }

    public void showImediateLostMsg(Player ganador, Player perdedor, int tirada) {
        String mensaje = new String().formatted(""
                + "Has sacado un %d,"
                + " significa que pierdes automaticamente"
                + "tu bote asciende a: %d y el bote de tu rival asciende a: %d",
                tirada,
                ganador.getBote(),
                perdedor.getBote());
    }

    public void showRegularLostMsg(Player ganador, Player perdedor, int tirada) {
        String mensaje = new String().formatted(""
                + "Has sacado un %d,"
                + " significa que pierdes en tu turno"
                + "tu bote asciende a: %d y el bote de tu rival asciende a: %d",
                tirada,
                ganador.getBote(),
                perdedor.getBote());
    }

}
