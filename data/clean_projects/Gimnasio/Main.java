package Gimnasio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Socio[] socios = new Socio[10];
        Entrenador[] entrenadores = new Entrenador[5];
        ClaseDirigida[] clases = new ClaseDirigida[10];

        entrenadores[0] = new Entrenador(1, "Laura");

        clases[0] = new ClaseDirigida("YOGA", entrenadores[0], LocalDate.now().plusDays(2), LocalTime.of(18, 0), "Sala 1", 5);

        // registrar socio
        System.out.print("id socio: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("nombre: ");
        String nombre = sc.nextLine();
        System.out.print("año nacimiento: ");
        int año = sc.nextInt();
        System.out.print("tipo membresía (0=BASICA 1=PREMIUM 2=VIP): ");
        int tipo = sc.nextInt();

        Socio s = new Socio(id, nombre, LocalDate.of(año, 1, 1), TipoMembresia.values()[tipo]);
        socios[0] = s;


        if (s.getEstado() == EstadoSocio.ACTIVO && (s.getMembresia() == TipoMembresia.PREMIUM || s.getMembresia() == TipoMembresia.VIP)) {
            boolean ok = clases[0].inscribir(s);
            System.out.println(ok ? "inscripción realizada" : "clase llena");
        } else {
            System.out.println("no puedes inscribirte: membresía o estado inválido");
        }

        System.out.print("registrar acceso idSocio: ");
        int idAcceso = sc.nextInt();

        for (Socio socio : socios) {
            if (socio != null && socio.getIdSocio() == idAcceso) {
                if (socio.getEstado() == EstadoSocio.ACTIVO) {
                    System.out.println("acceso permitido");
                    if (socio.getMembresia() != TipoMembresia.BASICA) {
                        for (ClaseDirigida c : clases) {
                            if (c != null && c.getFecha().equals(LocalDate.now())) {
                                for (Socio inscrito : c.getInscritos()) {
                                    if (inscrito != null && inscrito.getIdSocio() == idAcceso) {
                                        System.out.println("tienes clase hoy: " + c.getNombre());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("socio inactivo, acceso denegado");
                }
            }
        }
    }
}