package Videoclub;

import java.time.LocalDate;

public class Alquiler {
    private Pelicula pelicula;
    private Cliente cliente;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private double coste;
    SistemaPrecio sistemaPrecio;
    private Estado estado;



    public Alquiler(Pelicula pelicula, Cliente cliente, LocalDate fechaAlquiler, double coste) {
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.fechaAlquiler = fechaAlquiler;
        sistemaPrecio = new SistemaPrecio();
        this.coste = coste;
        this.fechaDevolucion = fechaAlquiler.plusDays(7);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "pelicula=" + pelicula +
                ", cliente=" + cliente +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaDevolucion=" + fechaDevolucion +
                ", coste=" + coste +
                ", sistemaPrecio=" + sistemaPrecio +
                ", estado=" + estado +
                '}';
    }
}
