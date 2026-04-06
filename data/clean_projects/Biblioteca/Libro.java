package Biblioteca;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private EstadoLibro estado;


    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public Libro(){}

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Titulo: " + titulo + ", Autor: " + autor + ", Estado: " + estado;
    }
}