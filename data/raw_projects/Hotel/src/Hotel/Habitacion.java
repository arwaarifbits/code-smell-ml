package Hotel;

import java.time.LocalDate;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private double precioPorNoche;
    private EstadoHabitacion estado;
    private LocalDate[] calendario;

    public Habitacion(int numero, TipoHabitacion tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.estado = EstadoHabitacion.DISPONIBLE;
        this.calendario = new LocalDate[30]; // fechas ocupadas
    }

    public boolean disponibleEntre(LocalDate entrada, LocalDate salida) {
        for (LocalDate fecha = entrada; fecha.isBefore(salida); fecha = fecha.plusDays(1)) {
            for (LocalDate ocupada : calendario) {
                if (ocupada != null && ocupada.equals(fecha)) return false;
            }
        }
        return true;
    }

    public void ocuparFechas(LocalDate entrada, LocalDate salida) {
        for (LocalDate fecha = entrada; fecha.isBefore(salida); fecha = fecha.plusDays(1)) {
            for (int i = 0; i < calendario.length; i++) {
                if (calendario[i] == null) {
                    calendario[i] = fecha;
                    break;
                }
            }
        }
        estado = EstadoHabitacion.OCUPADA;
    }

    public void liberarFechas(LocalDate entrada, LocalDate salida) {
        for (int i = 0; i < calendario.length; i++) {
            if (calendario[i] != null &&
                    (calendario[i].isEqual(entrada) || calendario[i].isAfter(entrada)) &&
                    calendario[i].isBefore(salida)) {
                calendario[i] = null;
            }
        }
        estado = EstadoHabitacion.DISPONIBLE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public LocalDate[] getCalendario() {
        return calendario;
    }

    public void setCalendario(LocalDate[] calendario) {
        this.calendario = calendario;
    }
}