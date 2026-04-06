package Videoclub;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaPelicula sistemaPelicula = new SistemaPelicula();

        int opcion;

        do {
            System.out.println("MENU");
            System.out.println("1. Mostrar películas disponibles y su formato");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Que peli quieres alquilar");
            System.out.println("4. Mostrar alquileres");
            System.out.println("5. Devolver película");
            System.out.println("6. Contar formatos");
            System.out.println("7. Calcular multa manualmente");

            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Peliculas disponibles:");
                    for (Pelicula inv : sistemaPelicula.getInventario()) {
                        if (inv != null) {
                            System.out.println(inv);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Clientes:");
                    for (Cliente cln : sistemaPelicula.getClientes()) {
                            System.out.println(cln);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el id del cliente que quieras elegir para alquilar una peli");
                    int id = sc.nextInt();
                    Cliente cliente = sistemaPelicula.buscarClientePorId(id);

                    System.out.println("Introduce el ID de la película para alquilar:");
                    int idPeli = sc.nextInt();
                    Pelicula pelicula = sistemaPelicula.buscarPeliculaPorId(idPeli);

                    System.out.println("Introduce el formato (DVD o BLURAY):");
                    String formatoStr = sc.next().toUpperCase();
                    Formato formato = Formato.valueOf(formatoStr);

                    sistemaPelicula.alquilar(cliente, pelicula, formato);
                    break;

                case 4:
                    System.out.println("Mostrar las peliculas alquiladas");
                    for (Alquiler palq : sistemaPelicula.getAlquilers()){
                        System.out.println(palq);
                    }

                    break;

                case 5:
                    System.out.println("Introduce el número del alquiler a devolver:");
                    int numAlq = sc.nextInt();
                    Alquiler alquilerADevolver = sistemaPelicula.getAlquilers()[numAlq];

                    if (alquilerADevolver == null) {
                        System.out.println("Ese alquiler no existe.");
                    } else {
                        sistemaPelicula.delvover(alquilerADevolver);
                    }
                    break;

                case 6:
                    System.out.println("Cual es el recuento que quieres contar? DVD o BLURAY");
                    for (int i = 0; i<Formato.values().length; i++){
                        System.out.println(i + " - " + Formato.values()[i]);
                    }
                    String formatoContar = sc.next().toUpperCase();
                    Formato formatoBuscado = Formato.valueOf(formatoContar);

                    int total = sistemaPelicula.contarFormato(formatoBuscado);
                    System.out.println("Hay " + total + " películas en formato " + formatoBuscado);
                    break;

                case 7:
                    System.out.println("Introduce el numero del alquiler para calcular multa:");
                    int num = sc.nextInt();

                    Alquiler alq = sistemaPelicula.getAlquilers()[num];

                    if (alq == null) {
                        break;
                    }

                    System.out.println("Introduce la fecha de devolucion (AAAA-MM-DD):");
                    String fechaStr = sc.next();
                    LocalDate fechaDev = LocalDate.parse(fechaStr);

                    sistemaPelicula.calcularRetrasoDevolucion(alq, fechaDev);
                    break;

                }

            } while (true);

    }
}