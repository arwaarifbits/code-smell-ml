package Refugio;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Refugio[] refugios = new Refugio[5];
        Adoptante[] adoptantes = new Adoptante[10];
        SolicitudAdopcion[] solicitudes = new SolicitudAdopcion[50];

        refugios[0] = new Refugio(1, "Refugio Valencia", "Calle Luna 12");


        Mascota m = new Mascota(101, "Luna", Especie.PERRO, "Labrador", LocalDate.of(2022, 5, 10), "Muy juguetona");
        refugios[0].publicarMascota(m);

        adoptantes[0] = new Adoptante("12345678A", "Abel", "Algemesí");

        System.out.println("Mascotas disponibles:");
        for (Mascota masc : refugios[0].getMascotas()) {
            if (masc != null && masc.getEstado() == EstadoMascota.DISPONIBLE) {
                System.out.println(masc.getId() + " - " + masc.getNombre());
            }
        }

        SolicitudAdopcion s = new SolicitudAdopcion(adoptantes[0], m);
        solicitudes[0] = s;
        System.out.println("Solicitud enviada para " + m.getNombre());


        s.setEstado(EstadoSolicitud.APROBADA);

        for (SolicitudAdopcion sol : solicitudes) {
            if (sol != null && sol.getMascota() == m && sol != s) {
                sol.setEstado(EstadoSolicitud.RECHAZADA);
            }
        }

        System.out.println("Solicitudes de " + adoptantes[0].getNombre() + ":");
        for (SolicitudAdopcion sol : solicitudes) {
            if (sol != null && sol.getAdoptante() == adoptantes[0]) {
                System.out.println(sol.getMascota().getNombre() + " -> " + sol.getEstado());
            }
        }

        System.out.println("Mascotas en el refugio:");
        for (Mascota masc : refugios[0].getMascotas()) {
            if (masc != null) {
                System.out.println(masc.getNombre() + " -> " + masc.getEstado());
            }
        }
    }
}