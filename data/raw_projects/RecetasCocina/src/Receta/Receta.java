package Receta;

public class Receta {
    private String nombre;
    private Usuario autor;
    private int tiempoPreparacion;
    private Dificultad dificultad;
    private Categoria categoria;
    private Ingrediente[] ingredientes;
    private Paso[] pasos;
    private int[] valoraciones;

    public Receta(String nombre, Usuario autor, int tiempo, Dificultad dificultad, Categoria categoria) {
        this.nombre = nombre;
        this.autor = autor;
        this.tiempoPreparacion = tiempo;
        this.dificultad = dificultad;
        this.categoria = categoria;
        this.ingredientes = new Ingrediente[10];
        this.pasos = new Paso[10];
        this.valoraciones = new int[50];
    }

    public void agregarIngrediente(Ingrediente i) {
        for (int j = 0; j < ingredientes.length; j++) {
            if (ingredientes[j] == null) {
                ingredientes[j] = i;
                break;
            }
        }
    }

    public void agregarPaso(Paso p) {
        for (int j = 0; j < pasos.length; j++) {
            if (pasos[j] == null) {
                pasos[j] = p;
                break;
            }
        }
    }

    public void valorar(int nota) {
        for (int i = 0; i < valoraciones.length; i++) {
            if (valoraciones[i] == 0) {
                valoraciones[i] = nota;
                break;
            }
        }
    }

    public double mediaValoracion() {
        int suma = 0, total = 0;
        for (int v : valoraciones) {
            if (v > 0) {
                suma += v;
                total++;
            }
        }
        return total > 0 ? (double) suma / total : 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Paso[] getPasos() {
        return pasos;
    }

    public void setPasos(Paso[] pasos) {
        this.pasos = pasos;
    }

    public int[] getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(int[] valoraciones) {
        this.valoraciones = valoraciones;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }
}