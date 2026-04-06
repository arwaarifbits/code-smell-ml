package Agencia;

import java.time.LocalDate;

public class ReservaViaje {
    private int idReserva;
    private PaqueteTuristico paquete;
    private Cliente cliente;
    private LocalDate fechaViaje;
    private int numeroPersonas;
    private double costeTotal;
    private EstadoReserva estado;

    public ReservaViaje(int id, PaqueteTuristico paquete, Cliente cliente, LocalDate fechaViaje, int personas) {
        this.idReserva = id;
        this.paquete = paquete;
        this.cliente = cliente;
        this.fechaViaje = fechaViaje;
        this.numeroPersonas = personas;
        this.costeTotal = paquete.getPrecioPorPersona() * personas;
        this.estado = EstadoReserva.SOLICITADA;
    }

    public void confirmar() {
        if (estado == EstadoReserva.SOLICITADA) {
            estado = EstadoReserva.CONFIRMADA;
        }
    }

    public void cancelar(LocalDate hoy) {
        if (estado == EstadoReserva.CONFIRMADA || estado == EstadoReserva.SOLICITADA) {
            if (fechaViaje.minusDays(30).isBefore(hoy)) {
                costeTotal *= 0.75; // penalización del 25%
            }
            estado = EstadoReserva.CANCELADA;
        }
    }

    @Override
    public String toString() {
        return "Reserva " + idReserva + ": " + paquete.getNombre() + " para " + cliente.getNombre() +
                " [" + estado + "] - Total: " + costeTotal;

    }

    public String resumen() {
        return toString();
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
}
