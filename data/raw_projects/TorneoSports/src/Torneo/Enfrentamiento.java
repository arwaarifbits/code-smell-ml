package Torneo;

public class Enfrentamiento {
    private Equipo equipoA;
    private Equipo equipoB;
    private String resultado;
    private Equipo equipoGanador;
    private EstadoEnfrentamiento estado;

    public Enfrentamiento(Equipo a, Equipo b) {
        this.equipoA = a;
        this.equipoB = b;
        this.estado = EstadoEnfrentamiento.PENDIENTE;
    }

    public void finalizar(String resultado, Equipo ganador) {
        this.resultado = resultado;
        this.equipoGanador = ganador;
        this.estado = EstadoEnfrentamiento.FINALIZADO;
    }

    public String resumen() {
        return equipoA.getNombre() + " vs " + equipoB.getNombre() + " " +
                (estado == EstadoEnfrentamiento.FINALIZADO ? resultado + " | Ganador: " + equipoGanador.getNombre() : "PENDIENTE");
    }

    public Equipo getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public EstadoEnfrentamiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnfrentamiento estado) {
        this.estado = estado;
    }
}