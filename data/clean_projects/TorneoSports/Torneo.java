package Torneo;

import java.time.LocalDate;
import java.util.Random;

public class Torneo {
    private String nombre;
    private Videojuego videojuego;
    private LocalDate fechaInicio;
    private FormatoTorneo formato;
    private Equipo[] equipos;
    private Enfrentamiento[] enfrentamientos;
    private boolean inscripcionesCerradas;

    public Torneo(String nombre, Videojuego videojuego, LocalDate fechaInicio, FormatoTorneo formato) {
        this.nombre = nombre;
        this.videojuego = videojuego;
        this.fechaInicio = fechaInicio;
        this.formato = formato;
        this.equipos = new Equipo[8];
        this.enfrentamientos = new Enfrentamiento[15]; // para eliminatoria directa
        this.inscripcionesCerradas = false;
    }

    public void inscribirEquipo(Equipo e) {
        if (!inscripcionesCerradas) {
            for (int i = 0; i < equipos.length; i++) {
                if (equipos[i] == null) {
                    equipos[i] = e;
                    break;
                }
            }
        }
    }

    public void cerrarInscripciones() {
        inscripcionesCerradas = true;
        generarPrimeraRonda();
    }

    private void generarPrimeraRonda() {
        Random r = new Random();
        Equipo[] mezcla = new Equipo[equipos.length];
        System.arraycopy(equipos, 0, mezcla, 0, equipos.length);

        // mezcla aleatoria
        for (int i = 0; i < mezcla.length; i++) {
            int j = (int) (Math.random() * mezcla.length);
            Equipo temp = mezcla[i];
            mezcla[i] = mezcla[j];
            mezcla[j] = temp;
        }

        // crear enfrentamientos
        int index = 0;
        for (int i = 0; i < mezcla.length; i += 2) {
            enfrentamientos[index++] = new Enfrentamiento(mezcla[i], mezcla[i + 1]);
        }
    }

    public void avanzarRonda() {
        Enfrentamiento[] nuevaRonda = new Enfrentamiento[8];
        int index = 0;

        for (int i = 0; i < enfrentamientos.length; i += 2) {
            if (enfrentamientos[i] != null && enfrentamientos[i].getEstado() == EstadoEnfrentamiento.FINALIZADO &&
                    enfrentamientos[i + 1] != null && enfrentamientos[i + 1].getEstado() == EstadoEnfrentamiento.FINALIZADO) {

                Equipo ganadorA = enfrentamientos[i].getEquipoGanador();
                Equipo ganadorB = enfrentamientos[i + 1].getEquipoGanador();
                nuevaRonda[index++] = new Enfrentamiento(ganadorA, ganadorB);
            }
        }

        for (int i = 0; i < nuevaRonda.length; i++) {
            if (nuevaRonda[i] != null) {
                enfrentamientos[i + 8] = nuevaRonda[i];
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public FormatoTorneo getFormato() {
        return formato;
    }

    public void setFormato(FormatoTorneo formato) {
        this.formato = formato;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[] equipos) {
        this.equipos = equipos;
    }

    public boolean isInscripcionesCerradas() {
        return inscripcionesCerradas;
    }

    public void setInscripcionesCerradas(boolean inscripcionesCerradas) {
        this.inscripcionesCerradas = inscripcionesCerradas;
    }

    public Enfrentamiento[] getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(Enfrentamiento[] enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }
}
