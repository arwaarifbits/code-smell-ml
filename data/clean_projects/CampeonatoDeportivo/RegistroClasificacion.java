package Campeonato;

public class RegistroClasificacion {
    private Equipo equipo;
    private int puntos, jugados, ganados, empatados, perdidos, gf, gc;

    public RegistroClasificacion(Equipo equipo) {
        this.equipo = equipo;
    }

    public void actualizar(int golesFavor, int golesContra) {
        jugados++;
        gf += golesFavor;
        gc += golesContra;

        if (golesFavor > golesContra) {
            ganados++; puntos += 3;
        } else if (golesFavor == golesContra) {
            empatados++; puntos += 1;
        } else {
            perdidos++;
        }
    }

    public Equipo getEquipo() { return equipo; }
    public int getPuntos() { return puntos; }
    public int getGolAverage() { return gf - gc; }

    @Override
    public String toString() {
        return "RegistroClasificacion{" +
                "equipo=" + equipo +
                ", puntos=" + puntos +
                ", jugados=" + jugados +
                ", ganados=" + ganados +
                ", empatados=" + empatados +
                ", perdidos=" + perdidos +
                ", gf=" + gf +
                ", gc=" + gc +
                '}';
    }
}