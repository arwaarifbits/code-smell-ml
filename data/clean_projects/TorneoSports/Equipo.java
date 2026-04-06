package Torneo;

public class Equipo {
    private String nombre;
    private Jugador[] jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new Jugador[5];
    }

    public void agregarJugador(Jugador j) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = j;
                break;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
}