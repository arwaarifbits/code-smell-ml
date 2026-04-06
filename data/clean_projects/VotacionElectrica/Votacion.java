package Votacion;

import java.time.LocalDate;

public class Votacion {
    private int id;
    private String pregunta;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Opcion[] opciones;
    private Voto[] votos;
    private Votante[] votantesQueYaVotaron;

    public Votacion(int id, String pregunta, LocalDate inicio, LocalDate fin, Opcion[] opciones) {
        this.id = id;
        this.pregunta = pregunta;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.opciones = opciones;
        this.votos = new Voto[100];
        this.votantesQueYaVotaron = new Votante[100];
    }

    public EstadoVotacion getEstado() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isBefore(fechaInicio)) return EstadoVotacion.CREADA;
        if (hoy.isAfter(fechaFin)) return EstadoVotacion.CERRADA;
        return EstadoVotacion.ABIERTA;
    }

    public boolean yaVoto(Votante v) {
        for (Votante vot : votantesQueYaVotaron) {
            if (vot != null && vot.getDni().equals(v.getDni())) return true;
        }
        return false;
    }

    public boolean emitirVoto(Votante v, Opcion o) {
        if (getEstado() != EstadoVotacion.ABIERTA || yaVoto(v)) return false;

        for (int i = 0; i < votos.length; i++) {
            if (votos[i] == null) {
                votos[i] = new Voto(v, o);
                break;
            }
        }

        for (int i = 0; i < votantesQueYaVotaron.length; i++) {
            if (votantesQueYaVotaron[i] == null) {
                votantesQueYaVotaron[i] = v;
                break;
            }
        }

        return true;
    }

    public void mostrarResultados() {
        if (getEstado() != EstadoVotacion.CERRADA) {
            System.out.println("la votación aún no está cerrada");
            return;
        }

        int[] conteo = new int[opciones.length];
        int total = 0;

        for (Voto v : votos) {
            if (v != null) {
                for (int i = 0; i < opciones.length; i++) {
                    if (v.getOpcion().getId() == opciones[i].getId()) {
                        conteo[i]++;
                        total++;
                    }
                }
            }
        }

        for (int i = 0; i < opciones.length; i++) {
            double porcentaje = total > 0 ? (conteo[i] * 100.0 / total) : 0;
            System.out.println(opciones[i].getTexto() + ": " + conteo[i] + " votos (" + porcentaje + "%)");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Opcion[] getOpciones() {
        return opciones;
    }

    public void setOpciones(Opcion[] opciones) {
        this.opciones = opciones;
    }

    public Voto[] getVotos() {
        return votos;
    }

    public void setVotos(Voto[] votos) {
        this.votos = votos;
    }

    public Votante[] getVotantesQueYaVotaron() {
        return votantesQueYaVotaron;
    }

    public void setVotantesQueYaVotaron(Votante[] votantesQueYaVotaron) {
        this.votantesQueYaVotaron = votantesQueYaVotaron;
    }
}