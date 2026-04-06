package Videoclub;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private Genero genero;
    private Formato formato;

    public Pelicula(int id, Formato formato, Genero genero, String director, String titulo) {
        this.id = id;
        this.formato = formato;
        this.genero = genero;
        this.director = director;
        this.titulo = titulo;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "ID PELICULA: " + id + "Formato: " + formato + "Genero: " + genero + "Director: " + director + "Titulo:" + titulo;
    }
}