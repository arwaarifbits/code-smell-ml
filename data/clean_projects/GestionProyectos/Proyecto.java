package Gestion;

import java.time.LocalDate;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFinPrevista;
    private Fase[] fases;
    private EstadoProyecto estado;

    public Proyecto(String nombre, String descripcion, LocalDate inicio, LocalDate fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = inicio;
        this.fechaFinPrevista = fin;
        this.fases = new Fase[4];
        this.estado = EstadoProyecto.NO_INICIADO;
    }

    public void agregarFase(Fase f) {
        for (int i = 0; i < fases.length; i++) {
            if (fases[i] == null) {
                fases[i] = f;
                return;
            }
        }
    }


    public void actualizarEstado() {
        boolean todasCompletadas = true;
        for (Fase f : fases) {
            if (f != null) {
                for (Tarea t : f.getTareas()) {
                    if (t != null && t.getEstado() != EstadoTarea.COMPLETADA) {
                        todasCompletadas = false;
                        break;
                    }
                }
            }
        }
        if (todasCompletadas) {
            estado = EstadoProyecto.COMPLETADO;
        }
    }

    public Fase[] getFases() { return fases; }
    public EstadoProyecto getEstado() { return estado; }
}