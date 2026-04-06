package Red;

import java.time.LocalDate;

public class Comentario {
    private int id;
    private String texto;
    private LocalDate fechaCreacion;
    private Usuario autor;

    public Comentario(int id, String texto, Usuario autor) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.fechaCreacion = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}