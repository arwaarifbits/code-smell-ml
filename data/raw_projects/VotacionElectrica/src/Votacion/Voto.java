package Votacion;

public class Voto {
    private Votante votante;
    private Opcion opcion;

    public Voto(Votante votante, Opcion opcion) {
        this.votante = votante;
        this.opcion = opcion;
    }

    public Votante getVotante() {
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }
}