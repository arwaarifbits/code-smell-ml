package Concesionarios;

public class Vendedor {
    private int id;
    private String nombre;
    private Cliente[] cartera;

    public Vendedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.cartera = new Cliente[10];
    }

    public void agregarCliente(Cliente c) {
        for (int i = 0; i < cartera.length; i++) {
            if (cartera[i] == null) {
                cartera[i] = c;
                return;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente[] getCartera() {
        return cartera;
    }

    public void setCartera(Cliente[] cartera) {
        this.cartera = cartera;
    }
}