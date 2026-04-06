package Gestion;

import java.time.LocalDate;

public class Tarea {
    private int id;
    private String descripcion;
    private LocalDate fechaLimite;
    private Empleado asignado;
    private EstadoTarea estado;

    public Tarea(int id, String descripcion, LocalDate fechaLimite) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.estado = EstadoTarea.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Empleado getAsignado() {
        return asignado;
    }

    public void setAsignado(Empleado asignado) {
        this.asignado = asignado;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }




    public void asignarEmpleado(Empleado e) {
        this.asignado = e;
        this.estado = EstadoTarea.EN_PROGRESO;
    }

    public void marcarCompletada() {
        this.estado = EstadoTarea.COMPLETADA;
    }


}