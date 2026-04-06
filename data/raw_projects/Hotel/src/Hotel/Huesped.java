package Hotel;

public class Huesped {
    private String dni;
    private String nombre;
    private String paisOrigen;

    public Huesped(String dni, String nombre, String paisOrigen) {
        this.dni = dni;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
    }

    public String getDni() { return dni; }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getNombre() { return nombre; }
}