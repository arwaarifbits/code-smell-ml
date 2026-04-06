package Biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaBiblioteca sistema = new SistemaBiblioteca(100, 50, 200);

        sistema.registrarSocio(new Socio("1", "Maria", "Lopez", LocalDate.of(1985, 8, 22), null));
        sistema.registrarSocio(new Socio("2", "Carlos", "Alfa", LocalDate.of(2000, 3, 10), null));

        sistema.agregarLibro(new Libro("12", "Libro1", "Miguel"));
        sistema.agregarLibro(new Libro("34", "Libro2", "Abel"));

        while (true) {
            System.out.println("\n SISTEMA DE GESTION DE BIBLIOTECA ");
            System.out.println("1. Menu Bibliotecario");
            System.out.println("2. Menu Socio");
            System.out.println("3. Mostrar informacion general");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuBibliotecario(scanner, sistema);
                    break;
                case 2:
                    menuSocio(scanner, sistema);
                    break;
                case 3:
                    mostrarInformacionGeneral(sistema);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }

    private static void menuBibliotecario(Scanner scanner, SistemaBiblioteca sistema) {
        boolean volver = false;

        while (!volver) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Registrar nuevo socio");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Mostrar todos los socios");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarLibroMenu(scanner, sistema);
                    break;
                case 2:
                    eliminarLibroMenu(scanner, sistema);
                    break;
                case 3:
                    registrarSocioMenu(scanner, sistema);
                    break;
                case 4:
                    sistema.mostrarLibros();
                    break;
                case 5:
                    sistema.mostrarSocios();
                    break;
                case 6:
                    volver = true;
                    break;
            }
        }
    }

    private static void menuSocio(Scanner scanner, SistemaBiblioteca sistema) {
        boolean volver = false;

        while (!volver) {
            System.out.println("1. Tomar libro prestado");
            System.out.println("2. Devolver libro");
            System.out.println("3. Ver libros disponibles");
            System.out.println("4. Ver mis préstamos activos");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarPrestamoMenu(scanner, sistema);
                    break;
                case 2:
                    devolverLibroMenu(scanner, sistema);
                    break;
                case 3:
                    sistema.mostrarLibros();
                    break;
                case 4:
                    sistema.mostrarPrestamosActivos();
                    break;
                case 5:
                    volver = true;
                    break;
            }
        }
    }

    private static void agregarLibroMenu(Scanner scanner, SistemaBiblioteca sistema) {
        System.out.println("\n=== AGREGAR NUEVO LIBRO ===");
        scanner.nextLine();

        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Ingrese título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese autor: ");
        String autor = scanner.nextLine();

        Libro nuevoLibro = new Libro(isbn, titulo, autor);

        if (sistema.agregarLibro(nuevoLibro)) {
            System.out.println("Libro agregado con éxito.");
        } else {
            System.out.println("Error: No se pudo agregar el libro. Posible ISBN duplicado o capacidad llena.");
        }
    }

    private static void eliminarLibroMenu(Scanner scanner, SistemaBiblioteca sistema) {
        System.out.println("\n=== ELIMINAR LIBRO ===");
        scanner.nextLine();

        System.out.print("Ingrese ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine();

        if (sistema.eliminarLibro(isbn)) {
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("Error: No se encontró un libro con ese ISBN.");
        }
    }

    private static void registrarSocioMenu(Scanner scanner, SistemaBiblioteca sistema) {
        System.out.println("\nREGISTRAR NUEVO SOCIO");
        scanner.nextLine();

        System.out.print("Ingrese ID del socio: ");
        String idSocio = scanner.nextLine();

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese fecha de nacimiento (AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaStr);

        Socio nuevoSocio = new Socio(idSocio, nombre, apellido, fechaNacimiento, null);

        if (sistema.registrarSocio(nuevoSocio)) {
            System.out.println("Socio registrado");
        } else {
            System.out.println("Error: No se pudo registrar el socio");
        }

    }

    private static void realizarPrestamoMenu(Scanner scanner, SistemaBiblioteca sistema) {
        System.out.println("REALIZAR PRESTAMO");
        scanner.nextLine();

        System.out.print("Ingrese ID del socio: ");
        String idSocio = scanner.nextLine();

        System.out.print("Ingrese ISBN del libro: ");
        String isbn = scanner.nextLine();

        sistema.realizarPrestamo(isbn, idSocio);
    }

    private static void devolverLibroMenu(Scanner scanner, SistemaBiblioteca sistema) {
        System.out.println("\nDEVOLER LIBRO");
        scanner.nextLine();

        System.out.print("Ingrese ID del socio: ");
        String idSocio = scanner.nextLine();

        System.out.print("Ingrese ISBN del libro: ");
        String isbn = scanner.nextLine();

        sistema.devolverLibro(isbn, idSocio);
    }

    private static void mostrarInformacionGeneral(SistemaBiblioteca sistema) {
        sistema.mostrarLibros();
        sistema.mostrarSocios();
        sistema.mostrarPrestamosActivos();
        sistema.mostrarPrestamosRetrasados();
    }
}