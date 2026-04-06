package Videoclub;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SistemaPelicula {
    private Pelicula[] inventario;
    private Alquiler[] alquilers;
    private Cliente[] clientes;
    private final SistemaPrecio sistemaPrecio;


    public SistemaPelicula() {
        this.sistemaPrecio = new SistemaPrecio();
        this.alquilers = new Alquiler[40];

        inventario = new Pelicula[] {
                new Pelicula(1, Formato.DVD, Genero.DRAMA, "Eric", "Ejercicio11"),
                new Pelicula(2, Formato.DVD, Genero.DRAMA, "Eric", "Ejercicio12"),
                new Pelicula(3, Formato.BLURAY, Genero.DRAMA, "Eric", "Ejercicio13")
        };

        clientes = new Cliente[] {
                new Cliente("Almussfaes", Suscripcion.PREMIUM, "Abel", 1),
                new Cliente("Almussfaes", Suscripcion.PREMIUM, "Abel", 2),
                new Cliente("Almussfaes", Suscripcion.PREMIUM, "Abel", 3)
        };

    }


    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Pelicula[] getInventario() {
        return inventario;
    }

    public void setInventario(Pelicula[] inventario) {
        this.inventario = inventario;
    }

    public Alquiler[] getAlquilers() {
        return alquilers;
    }

    public void setAlquilers(Alquiler[] alquilers) {
        this.alquilers = alquilers;
    }

    public Cliente buscarClientePorId(int id) {
        for (Cliente c : clientes) {
            if (c != null && c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    public Pelicula buscarPeliculaPorId(int id) {
        for (Pelicula p : inventario) {
            if (p != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    public int contarFormato(Formato formatoBuscado) {
        int contador = 0;

        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] != null && inventario[i].getFormato() == formatoBuscado) {
                contador++;
            }
        }

        return contador;
    }

    public boolean esPeliculaDisponible(Pelicula pelicula, Formato formato){
        for(Pelicula p : inventario) {
            if (p.getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && p.getFormato().equals(formato)){
                return true;
            }
        }
        return false;
    }

    private boolean AddAlquier(Alquiler aql) {
        for (int i = 0; i < alquilers.length; i++) {
            if (alquilers[i] == null) {
                alquilers[i] = aql;
                return true;
            }
        }

        return false;
    }

    private boolean EliminarPelicula(Pelicula pelicula){
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == pelicula){
                inventario[i] = null;
                return true;
            }
        }
        return false;
    }

    private boolean anyadirPelicula(Pelicula pelicula){
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == null){
                inventario[i] = pelicula;
                return true;
            }
        }
        return false;
    }

    public void alquilar(Cliente cliente, Pelicula pelicula, Formato formato){

        if (!esPeliculaDisponible(pelicula, formato)) {
            System.out.println("No esta disponible");
            return;
        }

        double preu = sistemaPrecio.RecuperarPrecio(pelicula.getFormato());

        if (cliente.getSuscripcion() == Suscripcion.PREMIUM) preu -= 5;

        Alquiler aql = new Alquiler(pelicula, cliente, LocalDate.now(), preu);

       if (!AddAlquier(aql)) {
           System.out.println("No hay alquileres disponibles");
           return;
       }

        if (!EliminarPelicula(pelicula)) {
            System.out.println("No se ha podido eliminar la pelicula");
            return;
        }
    }

    public void delvover(Alquiler alquiler){
        LocalDate fechaDevolucion = LocalDate.now();
        alquiler.setEstado(Estado.DEVOLVUELTO);
        anyadirPelicula(alquiler.getPelicula());

        calcularRetrasoDevolucion(alquiler, fechaDevolucion);
    }

    public void calcularRetrasoDevolucion(Alquiler alq, LocalDate fechaDevolucion) {

        LocalDate fechaPrevista = alq.getFechaDevolucion();
        long diasRetraso = ChronoUnit.DAYS.between(fechaPrevista, fechaDevolucion);

        if (diasRetraso > 0) {
            double multa = diasRetraso * 1.0;
            alq.getCliente().setMultasPendientes(true);
            System.out.println("Retraso de " + diasRetraso + " dias. Multa: " + multa + "€");
        } else {
            System.out.println("Devolucion correcta, sin multa");
        }
    }
}