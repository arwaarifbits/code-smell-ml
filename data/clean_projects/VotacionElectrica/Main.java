package Votacion;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Votante[] censo = new Votante[10];

        censo[0] = new Votante("12345678A", "Ana", "ana@mail.com");
        censo[1] = new Votante("87654321B", "Luis", "luis@mail.com");

        Opcion[] opciones = new Opcion[2];
        opciones[0] = new Opcion(1, "Sí");
        opciones[1] = new Opcion(2, "No");

        Votacion votacion = new Votacion(100, "¿Estás de acuerdo con la propuesta?", LocalDate.now().minusDays(1), LocalDate.now().plusDays(1), opciones);

        System.out.print("dni votante: ");
        String dni = sc.nextLine();

        Votante votante = null;
        for (Votante v : censo) {
            if (v != null && v.getDni().equals(dni)) {
                votante = v;
                break;
            }
        }

        if (votante == null) {
            System.out.println("votante no autorizado");
            return;
        }

        System.out.println("elige opción: 1=Sí 2=No");
        int op = sc.nextInt();

        boolean ok = votacion.emitirVoto(votante, opciones[op - 1]);
        System.out.println(ok ? "voto registrado" : "no se pudo emitir el voto");

        votacion.mostrarResultados();
    }
}