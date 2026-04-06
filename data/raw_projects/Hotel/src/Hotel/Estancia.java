package Hotel;

public class Estancia {
    private Reserva reserva;
    private double cargosExtra;

    public Estancia(Reserva reserva) {
        this.reserva = reserva;
        this.cargosExtra = 0;
    }

    public void añadirCargo(double monto) {
        cargosExtra += monto;
    }

    public double calcularTotal() {
        long noches = reserva.getFechaEntrada().until(reserva.getFechaSalida()).getDays();
        return noches * reserva.getHabitacion().getPrecioPorNoche() + cargosExtra;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getCargosExtra() {
        return cargosExtra;
    }

    public void setCargosExtra(double cargosExtra) {
        this.cargosExtra = cargosExtra;
    }
}