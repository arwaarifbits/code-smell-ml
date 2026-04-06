package Vuelos;

import java.time.LocalDate;

class Reserva {
    private static int contador = 1;

    private int id;
    private Vuelo vuelo;
    private Pasajero pasajero;
    private Asiento asiento;
    private double precioFinal;
    private EstadoReserva estado;

    Reserva(Vuelo vuelo, Pasajero pasajero, Asiento asiento) {
        this.id = contador++;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.precioFinal = asiento.getPrecio();
        this.estado = EstadoReserva.ACTIVA;

        asiento.setEstado(EstadoAsiento.OCUPADO);
    }

    public int getId() {
        return id;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void cancelar() {
        LocalDate hoy = LocalDate.now();
        long dias = vuelo.getFechaSalida().toEpochDay() - hoy.toEpochDay();

        if (dias >= 2) {
            System.out.println("cancelación sin penalizacion. devolucion completa");
            precioFinal = 0;
        } else {
            precioFinal *= 0.5;
            System.out.println("cancelación con penalizacion. devolucion del 50%: " + precioFinal + "€");
        }

        asiento.setEstado(EstadoAsiento.LIBRE);
        estado = EstadoReserva.CANCELADA;
    }
}
