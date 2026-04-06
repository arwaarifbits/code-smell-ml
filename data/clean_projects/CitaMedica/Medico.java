package Cita;

import java.time.LocalDate;

public class Medico {
    private int id;
    private String nombre;
    private Especialidad especialidad;
    private LocalDate[] disponibilidad;

    public Medico(int id, String nombre, Especialidad especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.disponibilidad = new LocalDate[30]; // máximo 30 días disponibles
    }

    public void agregarDisponibilidad(LocalDate fecha) {
        for (int i = 0; i < disponibilidad.length; i++) {
            if (disponibilidad[i] == null) {
                disponibilidad[i] = fecha;
                return;
            }
        }
    }

    public boolean estaDisponible(LocalDate fecha) {
        for (int i = 0; i < disponibilidad.length; i++) {
            if (fecha.equals(disponibilidad[i])) {
                return true;
            }
        }
        return false;
    }

    public void ocuparFecha(LocalDate fecha) {
        for (int i = 0; i < disponibilidad.length; i++) {
            if (fecha.equals(disponibilidad[i])) {
                disponibilidad[i] = null;
                return;
            }
        }
    }

    public void liberarFecha(LocalDate fecha) {
        agregarDisponibilidad(fecha);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate[] getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(LocalDate[] disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}