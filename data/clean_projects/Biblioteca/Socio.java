package Biblioteca;

import java.time.LocalDate;

public class Socio {
    private String idSocio;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private LocalDate fechaFinPenalizacion;

    public Socio(String idSocio, String nombre, String apellido, LocalDate fechaNacimiento ,LocalDate fechaFinPenalizacion) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFinPenalizacion = fechaFinPenalizacion;
    }

    public String getIdSocio() {
        return idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaFinPenalizacion() {
        return fechaFinPenalizacion;
    }

    public void setFechaFinPenalizacion(LocalDate fechaFinPenalizacion) {
        this.fechaFinPenalizacion = fechaFinPenalizacion;
    }

    public boolean estaPenalizado() {
        if (fechaFinPenalizacion == null) {
            return false;
        }
        return LocalDate.now().isBefore(fechaFinPenalizacion) || LocalDate.now().isEqual(fechaFinPenalizacion);
    }

    @Override
    public String toString() {
        String penalizacionInfo;

        if (estaPenalizado()) {
            penalizacionInfo = ", PENALIZADO hasta: " + fechaFinPenalizacion;
        } else {
            penalizacionInfo = ", SIN PENALIZACIONES";
        }

        return "ID: " + idSocio + ", Nombre: " + nombre + " " + apellido +  ", Nacimiento: " + fechaNacimiento + fechaFinPenalizacion;
    }
}
