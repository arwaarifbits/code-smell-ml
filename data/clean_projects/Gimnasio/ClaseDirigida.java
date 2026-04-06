package Gimnasio;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClaseDirigida {
    private String nombre;
    private Entrenador entrenador;
    private LocalDate fecha;
    private LocalTime hora;
    private String sala;
    private int capacidadMaxima;
    private Socio[] inscritos;

    public ClaseDirigida(String nombre, Entrenador entrenador, LocalDate fecha, LocalTime hora, String sala, int capacidadMaxima) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
        this.capacidadMaxima = capacidadMaxima;
        this.inscritos = new Socio[capacidadMaxima];
    }

    public boolean tienePlaza() {
        for (Socio s : inscritos) {
            if (s == null) return true;
        }
        return false;
    }

    public boolean inscribir(Socio s) {
        if (!tienePlaza()) return false;
        for (int i = 0; i < inscritos.length; i++) {
            if (inscritos[i] == null) {
                inscritos[i] = s;
                return true;
            }
        }
        return false;
    }

    public void cancelarInscripcion(Socio s) {
        for (int i = 0; i < inscritos.length; i++) {
            if (inscritos[i] != null && inscritos[i].getIdSocio() == s.getIdSocio()) {
                inscritos[i] = null;
                return;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Socio[] getInscritos() {
        return inscritos;
    }

    public void setInscritos(Socio[] inscritos) {
        this.inscritos = inscritos;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}
