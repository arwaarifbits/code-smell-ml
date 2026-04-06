package Red;

import java.util.Scanner;

public class RedSocial {

    private Usuario[] usuarios = new Usuario[100];
    private Publicacion[] publicaciones = new Publicacion[500];

    private int totalUsuarios = 0;
    private int totalPublicaciones = 0;
    private int totalComentarios = 0;

    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("1. Registrar usuario");
            System.out.println("2. Seguir usuario");
            System.out.println("3. Crear publicación");
            System.out.println("4. Comentar");
            System.out.println("5. Me gusta");
            System.out.println("6. Ver feed");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrar();
                    break;

                case 2:
                    seguir();
                    break;

                case 3:
                    publicar();
                    break;

                case 4:
                    comentar();
                    break;

                case 5:
                    meGusta();
                    break;

                case 6:
                    feed();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 0);
    }

    private void registrar() {
        System.out.print("Username: ");
        String u = sc.nextLine();

        if (buscarUsuario(u) != null) {
            System.out.println("Ya existe.");
            return;
        }

        System.out.print("Password: ");
        String p = sc.nextLine();

        System.out.print("Email: ");
        String e = sc.nextLine();

        usuarios[totalUsuarios] = new Usuario(u, p, e);
        totalUsuarios++;

        System.out.println("Registrado.");
    }

    private void seguir() {
        Usuario a = pedirUsuario("Tu username");
        Usuario b = pedirUsuario("A quién seguir");

        if (a != null && b != null && a != b) {
            a.seguir(b);
            System.out.println("Ahora sigues a " + b.getUsername());
        }
    }

    private void publicar() {
        Usuario autor = pedirUsuario("Tu username");
        if (autor == null) return;

        System.out.print("Texto: ");
        String texto = sc.nextLine();

        publicaciones[totalPublicaciones] = new Publicacion(totalPublicaciones, texto, autor);
        totalPublicaciones++;

        System.out.println("Publicación creada.");
    }

    private void comentar() {
        Usuario autor = pedirUsuario("Tu username");
        if (autor == null) return;

        System.out.print("ID publicación: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id < 0 || id >= totalPublicaciones) {
            System.out.println("ID inválido.");
            return;
        }

        System.out.print("Comentario: ");
        String texto = sc.nextLine();

        Comentario c = new Comentario(totalComentarios, texto, autor);
        totalComentarios++;

        publicaciones[id].añadirComentario(c);

        System.out.println("Comentario añadido.");
    }

    private void meGusta() {
        System.out.print("ID publicación: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id >= 0 && id < totalPublicaciones) {
            publicaciones[id].darMeGusta();
            System.out.println("Me gusta añadido.");
        }
    }

    private void feed() {
        Usuario u = pedirUsuario("Tu username");
        if (u == null) return;

        System.out.println("Feed de " + u.getUsername() + ":");

        for (int i = totalPublicaciones - 1; i >= 0; i--) {
            Usuario autor = publicaciones[i].getAutor();

            for (Usuario seguido : u.getSeguidos()) {
                if (seguido == autor) {
                    System.out.println("[" + publicaciones[i].getId() + "] "
                            + autor.getUsername() + ": "
                            + publicaciones[i].getTexto()
                            + " Likes: " + publicaciones[i].getMeGusta()
                            + " Fecha: " + publicaciones[i].getFecha());
                    break;
                }
            }
        }
    }

    private Usuario buscarUsuario(String username) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getUsername().equals(username)) {
                return usuarios[i];
            }
        }
        return null;
    }

    private Usuario pedirUsuario(String mensaje) {
        System.out.print(mensaje + ": ");
        String nombre = sc.nextLine();
        return buscarUsuario(nombre);
    }
}