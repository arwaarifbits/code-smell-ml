package Red;

import java.time.LocalDate;

public class Publicacion {
    private int id;
    private String texto;
    private LocalDate fechaCreacion;
    private Usuario autor;
    private Comentario[] comentarios = new Comentario[100];
    private int totalComentarios = 0;
    private int meGusta = 0;
    private LocalDate fecha;

    public Publicacion(int id, String texto, Usuario autor) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.fechaCreacion = LocalDate.now();
    }

    public void añadirComentario(Comentario c) {
        comentarios[totalComentarios++] = c;
    }

    public void darMeGusta() {
        meGusta++;
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

    public Comentario[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentario[] comentarios) {
        this.comentarios = comentarios;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public int getTotalComentarios() {
        return totalComentarios;
    }

    public void setTotalComentarios(int totalComentarios) {
        this.totalComentarios = totalComentarios;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}