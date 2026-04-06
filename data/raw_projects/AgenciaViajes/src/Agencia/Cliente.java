package Agencia;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String pasaporte;

    public Cliente(int id, String nombre, String pasaporte) {
        this.idCliente = id;
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }
}