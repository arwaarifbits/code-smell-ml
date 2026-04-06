package Vuelos;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Vuelo[] vuelos = {
                    new Vuelo("V001", "Valencia", "Madrid", LocalDate.of(2026, 1, 10), 100),
                    new Vuelo("V002", "Valencia", "Barcelona", LocalDate.of(2026, 1, 12), 6)
            };

            System.out.print("dni: ");
            String dni = sc.nextLine();
            System.out.print("nombre: ");
            String nombre = sc.nextLine();
            System.out.print("apellido: ");
            String apellido = sc.nextLine();
            Pasajero pasajero = new Pasajero(dni, nombre, apellido);

            System.out.print("origen: ");
            String origen = sc.nextLine();
            System.out.print("destino: ");
            String destino = sc.nextLine();
            System.out.print("fecha (yyyy-mm-dd): ");
            LocalDate fecha = LocalDate.parse(sc.nextLine());

            boolean encontrado = false;

            for (Vuelo v : vuelos) {
                if (v.getOrigen().equalsIgnoreCase(origen) &&
                        v.getDestino().equalsIgnoreCase(destino) &&
                        v.getFechaSalida().equals(fecha)) {

                    encontrado = true;
                    System.out.println("vuelo encontrado: " + v.getCodigo());

                    for (Asiento a : v.getAsientos()) {
                        if (a.getEstado() == EstadoAsiento.LIBRE) {
                            System.out.println("asiento " + a.getNumero() + " - " + a.getTipo() + " - " + a.getPrecio() + "€");
                        }
                    }

                    System.out.print("elige asiento (número): ");
                    int num = sc.nextInt();
                    Asiento elegido = v.getAsientos()[num - 1];

                    if (elegido.getEstado() == EstadoAsiento.OCUPADO) {
                        System.out.println("ese asiento está ocupado.");
                        return;
                    }

                    Reserva reserva = new Reserva(v, pasajero, elegido);
                    System.out.println("reserva confirmada. id: " + reserva.getId() + " - precio: " + reserva.getPrecioFinal() + "€");

                    sc.nextLine();
                    System.out.print("¿cancelar reserva? (s/n): ");
                    String cancelar = sc.nextLine();

                    if (cancelar.equalsIgnoreCase("s")) {
                        reserva.cancelar();
                    }
                }
            }

            if (!encontrado) {
                System.out.println("no hay vuelos que coincidan con la búsqueda.");
            }

            sc.close();
        }
    }