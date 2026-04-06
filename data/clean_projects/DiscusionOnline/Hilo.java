package Discusion;

import java.time.LocalDate;

public class Hilo {
    private String titulo;
    private Usuario autor;
    private LocalDate fechaCreacion;
    private Mensaje[] mensajes;

    public Hilo(String titulo, Usuario autor, String textoInicial) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaCreacion = LocalDate.now();
        this.mensajes = new Mensaje[20];
        this.mensajes[0] = new Mensaje(autor, textoInicial);
    }

    public boolean agregarMensaje(Mensaje m) {
        for (int i = 0; i < mensajes.length; i++) {
            if (mensajes[i] == null) {
                mensajes[i] = m;
                return true;
            }
        }
        return false;
    }

    public LocalDate getUltimaFecha() {
        LocalDate ultima = fechaCreacion;
        for (Mensaje m : mensajes) {
            if (m != null && m.getFechaPublicacion().isAfter(ultima)) {
                ultima = m.getFechaPublicacion();
            }
        }
        return ultima;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Mensaje[] getMensajes() {
        return mensajes;
    }

    public void setMensajes(Mensaje[] mensajes) {
        this.mensajes = mensajes;
    }
}