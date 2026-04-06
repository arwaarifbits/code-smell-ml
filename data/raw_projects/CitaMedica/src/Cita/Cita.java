package Cita;

import java.time.LocalDate;

public class Cita {
    private int idCita;
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;
    private EstadoCita estado;

    public Cita(int idCita, Paciente paciente, Medico medico, LocalDate fecha) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.estado = EstadoCita.PROGRAMADA;
        medico.ocuparFecha(fecha);
    }

    public void cancelar() {
        if (LocalDate.now().until(fecha).getDays() >= 1) {
            estado = EstadoCita.CANCELADA;
            medico.liberarFecha(fecha);
        } else {
            System.out.println("no se puede cancelar, faltan menos de 24 horas");
        }
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
}