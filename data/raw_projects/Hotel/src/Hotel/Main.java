package Hotel;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Habitacion[] habitaciones = new Habitacion[10];
        Huesped[] huespedes = new Huesped[20];
        Reserva[] reservas = new Reserva[20];
        Estancia[] estancias = new Estancia[20];

        habitaciones[0] = new Habitacion(101, TipoHabitacion.INDIVIDUAL, 50);
        habitaciones[1] = new Habitacion(102, TipoHabitacion.DOBLE, 80);
        habitaciones[2] = new Habitacion(201, TipoHabitacion.SUITE, 150);

        int opcion;

        do {
            System.out.println("1. Registrar huésped");
            System.out.println("2. Crear reserva");
            System.out.println("3. Check-in");
            System.out.println("4. Añadir cargo extra");
            System.out.println("5. Check-out");
            System.out.println("6. Ver ocupación por fecha");
            System.out.println("0. Salir");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: // registrar huésped
                    System.out.print("dni: ");
                    String dni = sc.nextLine();
                    System.out.print("nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("pais origen: ");
                    String pais = sc.nextLine();

                    Huesped h = new Huesped(dni, nombre, pais);

                    for (int i = 0; i < huespedes.length; i++) {
                        if (huespedes[i] == null) {
                            huespedes[i] = h;
                            break;
                        }
                    }

                    System.out.println("huésped registrado");
                    break;

                case 2:
                    System.out.print("dni del huésped: ");
                    String dniBuscado = sc.nextLine();
                    Huesped huesped = null;

                    for (Huesped hu : huespedes) {
                        if (hu != null && hu.getDni().equals(dniBuscado)) {
                            huesped = hu;
                            break;
                        }
                    }

                    if (huesped == null) {
                        System.out.println("huésped no encontrado");
                        break;
                    }

                    System.out.print("tipo habitación (0=INDIVIDUAL 1=DOBLE 2=SUITE): ");
                    int tipo = sc.nextInt();
                    System.out.print("días hasta entrada: ");
                    int diasEntrada = sc.nextInt();
                    System.out.print("noches de estancia: ");
                    int noches = sc.nextInt();

                    LocalDate entrada = LocalDate.now().plusDays(diasEntrada);
                    LocalDate salida = entrada.plusDays(noches);

                    Habitacion seleccionada = null;

                    for (Habitacion hab : habitaciones) {
                        if (hab != null &&
                                hab.getTipo().ordinal() == tipo &&
                                hab.disponibleEntre(entrada, salida)) {
                            seleccionada = hab;
                            break;
                        }
                    }

                    if (seleccionada == null) {
                        System.out.println("no hay habitaciones disponibles");
                        break;
                    }

                    Reserva r = new Reserva(huesped, seleccionada, entrada, salida);

                    for (int i = 0; i < reservas.length; i++) {
                        if (reservas[i] == null) {
                            reservas[i] = r;
                            break;
                        }
                    }

                    System.out.println("reserva creada en habitación " + seleccionada.getNumero());
                    break;

                case 3:
                    System.out.print("dni del huésped: ");
                    String dniCheckIn = sc.nextLine();

                    Reserva reservaCheckIn = null;

                    for (Reserva res : reservas) {
                        if (res != null &&
                                res.getHuesped().getDni().equals(dniCheckIn) &&
                                res.getFechaEntrada().equals(LocalDate.now())) {
                            reservaCheckIn = res;
                            break;
                        }
                    }

                    if (reservaCheckIn == null) {
                        System.out.println("no hay reservas para hoy");
                        break;
                    }

                    Estancia est = new Estancia(reservaCheckIn);

                    for (int i = 0; i < estancias.length; i++) {
                        if (estancias[i] == null) {
                            estancias[i] = est;
                            break;
                        }
                    }

                    System.out.println("check-in realizado");
                    break;

                case 4:
                    System.out.print("dni del huésped: ");
                    String dniCargo = sc.nextLine();

                    Estancia estanciaCargo = null;

                    for (Estancia es : estancias) {
                        if (es != null &&
                                es.getReserva().getHuesped().getDni().equals(dniCargo)) {
                            estanciaCargo = es;
                            break;
                        }
                    }

                    if (estanciaCargo == null) {
                        System.out.println("no hay estancia activa");
                        break;
                    }

                    System.out.print("monto del cargo: ");
                    double cargo = sc.nextDouble();

                    estanciaCargo.añadirCargo(cargo);

                    System.out.println("cargo añadido");
                    break;

                case 5:
                    System.out.print("dni del huésped: ");
                    String dniOut = sc.nextLine();

                    Estancia estanciaOut = null;

                    for (Estancia es : estancias) {
                        if (es != null &&
                                es.getReserva().getHuesped().getDni().equals(dniOut)) {
                            estanciaOut = es;
                            break;
                        }
                    }

                    if (estanciaOut == null) {
                        System.out.println("no hay estancia activa");
                        break;
                    }

                    Reserva resOut = estanciaOut.getReserva();

                    if (!resOut.getFechaSalida().equals(LocalDate.now())) {
                        System.out.println("no es la fecha de salida");
                        break;
                    }

                    double total = estanciaOut.calcularTotal();
                    resOut.getHabitacion().liberarFechas(resOut.getFechaEntrada(), resOut.getFechaSalida());

                    System.out.println("check-out realizado. total: " + total + " €");

                    break;

                case 6:
                    System.out.print("días desde hoy: ");
                    int dias = sc.nextInt();
                    LocalDate consulta = LocalDate.now().plusDays(dias);

                    System.out.println("ocupación del " + consulta + ":");

                    for (Habitacion hab : habitaciones) {
                        if (hab != null) {
                            boolean ocupada = !hab.disponibleEntre(consulta, consulta.plusDays(1));
                            System.out.println("habitación " + hab.getNumero() + " -> " + (ocupada ? "OCUPADA" : "DISPONIBLE"));
                        }
                    }
                    break;
            }

        } while (true);
    }
}