package Refugio;

import java.time.LocalDate;

public class SolicitudAdopcion {
    private Adoptante adoptante;
    private Mascota mascota;
    private LocalDate fecha;
    private EstadoSolicitud estado;

    public SolicitudAdopcion(Adoptante adoptante, Mascota mascota) {
        this.adoptante = adoptante;
        this.mascota = mascota;
        this.fecha = LocalDate.now();
        this.estado = EstadoSolicitud.ENVIADA;
        mascota.setEstado(EstadoMascota.EN_PROCESO);
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }
}