package Videoclub;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String direccion;
    private Suscripcion suscripcion;
    private boolean multasPendientes;

    public Cliente(String direccion, Suscripcion suscripcion, String nombre, int idCliente) {
        this.direccion = direccion;
        this.suscripcion = suscripcion;
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.multasPendientes = false;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isMultasPendientes() {
        return multasPendientes ;
    }

    public void setMultasPendientes(boolean multasPendientes) {
        this.multasPendientes = multasPendientes;
    }

    @Override
    public String toString() {
        return "Cliente" + "id=" + idCliente + ", nombre='" + nombre + ' ' + ", direccion='" + direccion + ' ' + ", suscripcion=" + suscripcion + ", multasPendientes=" + multasPendientes;
    }
}
