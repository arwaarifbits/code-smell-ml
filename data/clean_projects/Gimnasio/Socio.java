package Gimnasio;

import java.time.LocalDate;

public class Socio {
    private int idSocio;
    private String nombre;
    private LocalDate fechaNacimiento;
    private TipoMembresia membresia;
    private EstadoSocio estado;

    public Socio(int idSocio, String nombre, LocalDate fechaNacimiento, TipoMembresia membresia) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.membresia = membresia;
        this.estado = EstadoSocio.ACTIVO;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoMembresia getMembresia() {
        return membresia;
    }

    public void setMembresia(TipoMembresia membresia) {
        this.membresia = membresia;
    }

    public EstadoSocio getEstado() {
        return estado;
    }
}