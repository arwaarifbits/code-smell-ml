package Biblioteca;

import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Socio socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionPrevista;
    private LocalDate fechaDevolucionReal;
    private boolean finalizado;

    public Prestamo(Libro libro, Socio socio, LocalDate fechaPrestamo) {
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = fechaPrestamo.plusDays(15);
        this.fechaDevolucionReal = null;
        this.finalizado = false;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void finalizarPrestamo(LocalDate fechaDevolucion) {
        this.fechaDevolucionReal = fechaDevolucion;
        this.finalizado = true;
        libro.setEstado(EstadoLibro.DISPONIBLE);

        //esto es para ver si se a devuelto el libro (calcular los dias)
        if (fechaDevolucion.isAfter(fechaDevolucionPrevista)) {
            int diasRetraso = 0;
            LocalDate fecha = fechaDevolucionPrevista;
            while (fecha.isBefore(fechaDevolucion)) {
                diasRetraso++;
                fecha = fecha.plusDays(1);
            }

            //la penilazacion de dos dias
            int diasPenalizacion = diasRetraso * 2;  // NUEVO NOMBRE
            socio.setFechaFinPenalizacion(fechaDevolucion.plusDays(diasPenalizacion));

            System.out.println("El socio " + socio.getNombre() + " ha devuelto el libro con " + diasRetraso
                    + " dias de retraso. La penilazacion es de"
                    + diasPenalizacion + " dias");
        }
    }

    @Override
    public String toString() {
        String estado;
        if (finalizado) {
            estado = "FINALIZADO";
        } else {
            estado = "ACTIVO";
        }

        String devolucionInfo = "";
        if (fechaDevolucionReal != null) {
            devolucionInfo = ", Devolucion: " + fechaDevolucionReal;
        }

        return "Libro: " + libro.getTitulo() +
                ", Socio: " + socio.getNombre() + " " + socio.getApellido() +
                ", Prestamo: " + fechaPrestamo +
                ", Devolucion prevista: " + fechaDevolucionPrevista + devolucionInfo +
                ", Estado: " + estado;
    }
}