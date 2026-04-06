package Vuelos;

class Asiento {
    private int numero;
    private TipoAsiento tipo;
    private EstadoAsiento estado;

    public Asiento(int numero, TipoAsiento tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = EstadoAsiento.LIBRE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoAsiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAsiento tipo) {
        this.tipo = tipo;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    double getPrecio() {
        if (tipo == TipoAsiento.TURISTA) {
            return 100;
        }
        if (tipo == TipoAsiento.BUSINESS){
            return 200;
        }
        return 300;
    }
}

