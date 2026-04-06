package Discusion;

import java.time.LocalDate;

public class Mensaje {
    private Usuario autor;
    private String texto;
    private LocalDate fechaPublicacion;

    public Mensaje(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.fechaPublicacion = LocalDate.now();
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
