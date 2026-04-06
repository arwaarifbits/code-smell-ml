package Torneo;

import java.time.LocalDate;

public class Jugador {
    private String nickname;
    private String nombreReal;
    private LocalDate fechaNacimiento;

    public Jugador(String nickname, String nombreReal, LocalDate fechaNacimiento) {
        this.nickname = nickname;
        this.nombreReal = nombreReal;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
