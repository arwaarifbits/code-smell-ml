package Biblioteca;

import java.time.LocalDate;

public class SistemaBiblioteca {
    private Libro[] libros;
    private Socio[] socios;
    private Prestamo[] prestamos;

    private int contadorLibros;
    private int contadorSocios;
    private int contadorPrestamos;

    public SistemaBiblioteca(int maxLibros, int maxSocios, int maxPrestamos) {
        libros = new Libro[maxLibros];
        socios = new Socio[maxSocios];
        prestamos = new Prestamo[maxPrestamos];
        contadorLibros = 0;
        contadorSocios = 0;
        contadorPrestamos = 0;
    }

    public boolean agregarLibro(Libro libro) {
        if (libro == null) {
            return false;
        }

        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i] != null && libros[i].getIsbn().equals(libro.getIsbn())) {
                return false;
            }
        }

        if (contadorLibros < libros.length) {
            libros[contadorLibros] = libro;
            contadorLibros++;
            return true;
        }
        return false;
    }

    public boolean eliminarLibro(String isbn) {
        if (isbn == null) {
            return false;
        }

        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i] != null && libros[i].getIsbn().equals(isbn)) {
                for (int j = i; j < contadorLibros - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                contadorLibros--;
                libros[contadorLibros] = null;
                return true;
            }
        }
        return false;
    }

    public Libro buscarLibroPorISBN(String isbn) {
        if (isbn == null) {
            return null;
        }

        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i] != null && libros[i].getIsbn().equals(isbn)) {
                return libros[i];
            }
        }
        return null;
    }

    public void mostrarLibros() {
        System.out.println("LISTA DE LIBROS ");
        if (contadorLibros == 0) {
            System.out.println("No hay libros");
        } else {
            for (int i = 0; i < contadorLibros; i++) {
                if (libros[i] != null) {
                    System.out.println((i + 1) + ". " + libros[i]);
                }
            }
        }
    }

    public boolean registrarSocio(Socio socio) {
        for (int i = 0; i < contadorSocios; i++) {
            if (socios[i].getIdSocio().equals(socio.getIdSocio())) {
                return false;
            }
        }

        if (contadorSocios < socios.length) {
            socios[contadorSocios] = socio;
            contadorSocios++;
            return true;
        }
        return false;
    }

    public Socio buscarSocioPorID(String idSocio) {
        for (int i = 0; i < contadorSocios; i++) {
            if (socios[i].getIdSocio().equals(idSocio)) {
                return socios[i];
            }
        }
        return null;
    }

    public void mostrarSocios() {
        System.out.println("LISTA DE SOCIOS ");
        if (contadorSocios == 0) {
            System.out.println("No hay socios registrados");
        } else {
            for (int i = 0; i < contadorSocios; i++) {
                System.out.println((i + 1) + ". " + socios[i]);
            }
        }
    }

    public int contarPrestamosActivosPorSocio(String idSocio) {
        int contador = 0;
        for (int i = 0; i < contadorPrestamos; i++) {
            if (!prestamos[i].isFinalizado() &&
                    prestamos[i].getSocio().getIdSocio().equals(idSocio)) {
                contador++;
            }
        }
        return contador;
    }


    public boolean realizarPrestamo(String isbn, String idSocio) {
        Libro libro = buscarLibroPorISBN(isbn);
        Socio socio = buscarSocioPorID(idSocio);

        if (libro == null) {
            System.out.println("Error: Libro no encontrado.");
            return false;
        }

        if (socio == null) {
            System.out.println("Error: Socio no encontrado.");
            return false;
        }

        if (socio.estaPenalizado()) {
            System.out.println("Error: El socio este penalizado hasta " + socio.getFechaFinPenalizacion());
            return false;
        }

        if (libro.getEstado() != EstadoLibro.DISPONIBLE) {
            System.out.println("Error: El libro no esta disponible");
            return false;
        }

        if (contarPrestamosActivosPorSocio(idSocio) >= 5) {
            System.out.println("Error: El socio ya tiene 5 libros prestados");
            return false;
        }

        if (contadorPrestamos < prestamos.length) {
            Prestamo prestamo = new Prestamo(libro, socio, LocalDate.now());
            prestamos[contadorPrestamos] = prestamo;
            contadorPrestamos++;
            libro.setEstado(EstadoLibro.PRESTADO);
            System.out.println("Prestamo hecho, devolucion prevista: " + prestamo.getFechaDevolucionPrevista());
            return true;
        }

        System.out.println("Error: Muchos prestamos realizados");
        return false;
    }

    public boolean devolverLibro(String isbn, String idSocio) {
        for (int i = 0; i < contadorPrestamos; i++) {
            Prestamo prestamo = prestamos[i];
            if (!prestamo.isFinalizado() &&
                    prestamo.getLibro().getIsbn().equals(isbn) &&
                    prestamo.getSocio().getIdSocio().equals(idSocio)) {

                prestamo.finalizarPrestamo(LocalDate.now());
                System.out.println("Libro devuelto");
                return true;
            }
        }

        System.out.println("Error: No se encontra un prestamo activo con esos datos");
        return false;
    }

    public void mostrarPrestamosActivos() {
        System.out.println("\n PRESTAMOS ACTIVOS ");
        boolean hayActivos = false;
        for (int i = 0; i < contadorPrestamos; i++) {
            if (!prestamos[i].isFinalizado()) {
                System.out.println((i + 1) + ". " + prestamos[i]);
                hayActivos = true;
            }
        }
        if (!hayActivos) {
            System.out.println("No hay prestamos activos");
        }
    }

    public void mostrarPrestamosRetrasados() {
        System.out.println("\n PRESTAMOS CON RETRASO ");
        LocalDate hoy = LocalDate.now();
        boolean hayRetrasados = false;

        for (int i = 0; i < contadorPrestamos; i++) {
            Prestamo prestamo = prestamos[i];
            if (!prestamo.isFinalizado() && hoy.isAfter(prestamo.getFechaDevolucionPrevista())) {
                int diasRetraso = 0;
                LocalDate fecha = prestamo.getFechaDevolucionPrevista();
                while (fecha.isBefore(hoy)) {
                    diasRetraso++;
                    fecha = fecha.plusDays(1);
                }

                System.out.println((i + 1) + ". " + prestamo);
                System.out.println("Dias de retraso: " + diasRetraso);
                hayRetrasados = true;
            }
        }

        if (!hayRetrasados) {
            System.out.println("No hay prestamos con retraso");
        }
    }
}