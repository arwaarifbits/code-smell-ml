package Campeonato;

import java.time.LocalDate;

public class Jornada {
    private LocalDate fecha;
    private Partido[] partidos;

    public Jornada(LocalDate fecha) {
        this.fecha = fecha;
        this.partidos = new Partido[10];
    }

    public void agregarPartido(Partido p) {
        for (int i = 0; i < partidos.length; i++) {
            if (partidos[i] == null) {
                partidos[i] = p;
                break;
            }
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }
}