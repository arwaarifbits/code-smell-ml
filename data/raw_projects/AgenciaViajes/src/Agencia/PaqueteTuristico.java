package Agencia;

public class PaqueteTuristico {
    private String codigo;
    private String nombre;
    private Destino destino;
    private int duracion;
    private double precioPorPersona;
    private Actividad[] actividades;

    public PaqueteTuristico(String codigo, String nombre, Destino destino, int duracion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.destino = destino;
        this.duracion = duracion;
        this.precioPorPersona = precio;
        this.actividades = new Actividad[10];
    }

    public void agregarActividad(Actividad a) {
        for (int i = 0; i < actividades.length; i++) {
            if (actividades[i] == null) {
                actividades[i] = a;
                break;
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecioPorPersona() {
        return precioPorPersona;
    }

    public void setPrecioPorPersona(double precioPorPersona) {
        this.precioPorPersona = precioPorPersona;
    }

    public Actividad[] getActividades() {
        return actividades;
    }

    public void setActividades(Actividad[] actividades) {
        this.actividades = actividades;
    }
}