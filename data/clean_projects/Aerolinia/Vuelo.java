package Vuelos;

import java.time.LocalDate;

class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private LocalDate fechaSalida;
    private Asiento[] asientos;
    private TipoAsiento tipo;

    public Vuelo(String codigo, String origen, String destino, LocalDate fechaSalida, int numAsientos) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;

        this.asientos = new Asiento[numAsientos];

        for (int i = 0; i < this.asientos.length; i++) {

            TipoAsiento tipo;

            if (i < 2) {
                tipo = TipoAsiento.TURISTA;
            } else if (i < 4) {
                tipo = TipoAsiento.BUSINESS;
            } else {
                tipo = TipoAsiento.PRIMERA_CLASE;
            }

            this.asientos[i] = new Asiento(i + 1, tipo);
        }
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setAsientos(Asiento[] asientos) {
        this.asientos = asientos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public Asiento[] getAsientos() {
        return asientos;
    }
}
