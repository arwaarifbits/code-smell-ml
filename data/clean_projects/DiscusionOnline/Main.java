package Discusion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Usuario[] usuarios = new Usuario[10];
        Foro[] foros = new Foro[3];
        foros[0] = new Foro(TemaForo.PROGRAMACION);
        foros[1] = new Foro(TemaForo.OCIO);
        foros[2] = new Foro(TemaForo.NOTICIAS);

        usuarios[0] = new Usuario("abel", "1234", "abel@mail.com", RolUsuario.MIEMBRO);

        System.out.print("usuario: ");
        String user = sc.nextLine();
        Usuario u = null;
        for (Usuario us : usuarios) {
            if (us != null && us.getUsername().equals(user)) {
                u = us;
                break;
            }
        }

        if (u == null) {
            System.out.println("usuario no encontrado");
            return;
        }

        System.out.print("foro (0=PROGRAMACION 1=OCIO 2=NOTICIAS): ");
        int f = sc.nextInt(); sc.nextLine();
        System.out.print("titulo del hilo: ");
        String titulo = sc.nextLine();
        System.out.print("mensaje inicial: ");
        String texto = sc.nextLine();

        Hilo h = new Hilo(titulo, u, texto);
        foros[f].agregarHilo(h);

        System.out.println("hilo creado");

        System.out.print("respuesta al hilo: ");
        String respuesta = sc.nextLine();
        h.agregarMensaje(new Mensaje(u, respuesta));

        System.out.println("contenido del hilo:");
        for (Mensaje m : h.getMensajes()) {
            if (m != null) {
                System.out.println(m.getAutor().getUsername() + ": " + m.getTexto());
            }
        }

        System.out.println("hilos en el foro:");
        Hilo[] ordenados = foros[f].getHilosOrdenadosPorUltimaFecha();
        for (Hilo hilo : ordenados) {
            if (hilo != null) {
                System.out.println(hilo.getTitulo() + " (último mensaje: " + hilo.getUltimaFecha() + ")");
            }
        }
    }
}