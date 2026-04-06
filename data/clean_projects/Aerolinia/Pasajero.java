package Vuelos;

class Pasajero {
    private String dni;
    private String nombre;
    private String apellido;

    Pasajero(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }
}

