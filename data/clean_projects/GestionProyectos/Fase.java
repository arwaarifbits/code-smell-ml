package Gestion;

public class Fase {
    private String nombre;
    private Tarea[] tareas;

    public Fase(String nombre) {
        this.nombre = nombre;
        this.tareas = new Tarea[10];
    }

    public void agregarTarea(Tarea t) {
        for (int i = 0; i < tareas.length; i++) {
            if (tareas[i] == null) {
                tareas[i] = t;
                return;
            }
        }
        System.out.println("no se puede agregar mas tareas el array esta lleno");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarea[] getTareas() {
        return tareas;
    }

    public void setTareas(Tarea[] tareas) {
        this.tareas = tareas;
    }
}