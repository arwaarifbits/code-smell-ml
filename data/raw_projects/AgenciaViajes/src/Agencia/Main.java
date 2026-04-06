package Agencia;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Destino[] destinos = new Destino[20];
        PaqueteTuristico[] paquetes = new PaqueteTuristico[20];
        Cliente[] clientes = new Cliente[20];
        ReservaViaje[] reservas = new ReservaViaje[50];

        int opcion;

        do {
            System.out.println("1. Registrar destino");
            System.out.println("2. Registrar paquete turístico");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Buscar paquetes por destino");
            System.out.println("5. Buscar paquetes por duración");
            System.out.println("6. Crear reserva");
            System.out.println("7. Confirmar reserva");
            System.out.println("8. Cancelar reserva");
            System.out.println("9. Ver reservas de un cliente");
            System.out.println("0. Salir");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: // registrar destino
                    System.out.print("ciudad: ");
                    String ciudad = sc.nextLine();
                    System.out.print("pais: ");
                    String pais = sc.nextLine();

                    Destino d = new Destino(ciudad, pais);

                    for (int i = 0; i < destinos.length; i++) {
                        if (destinos[i] == null) {
                            destinos[i] = d;
                            break;
                        }
                    }

                    System.out.println("destino registrado");
                    break;

                case 2: // registrar paquete
                    System.out.println("destinos:");
                    for (int i = 0; i < destinos.length; i++) {
                        if (destinos[i] != null) {
                            System.out.println(i + " - " + destinos[i].getNombreCiudad());
                        }
                    }

                    System.out.print("elige destino: ");
                    int posD = sc.nextInt();
                    sc.nextLine();

                    System.out.print("codigo: ");
                    String cod = sc.nextLine();
                    System.out.print("nombre paquete: ");
                    String nomP = sc.nextLine();
                    System.out.print("duracion (dias): ");
                    int dur = sc.nextInt();
                    System.out.print("precio por persona: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    PaqueteTuristico pt = new PaqueteTuristico(cod, nomP, destinos[posD], dur, precio);

                    System.out.print("cuantas actividades quieres añadir? ");
                    int act = sc.nextInt();
                    sc.nextLine();
                    //Parapente, Excursion Turisita (consultar destino), Bailes Salsa
                    for (int i = 0; i < act; i++) {
                        System.out.print("nombre actividad: ");
                        String na = sc.nextLine();
                        System.out.print("descripcion: ");
                        String da = sc.nextLine();
                        pt.agregarActividad(new Actividad(na, da));
                    }

                    for (int i = 0; i < paquetes.length; i++) {
                        if (paquetes[i] == null) {
                            paquetes[i] = pt;
                            break;
                        }
                    }

                    System.out.println("paquete registrado");
                    break;

                case 3: // registrar cliente
                    System.out.print("id cliente: ");
                    int idC = sc.nextInt();
                    sc.nextLine();
                    System.out.print("nombre: ");
                    String nomC = sc.nextLine();
                    System.out.print("pasaporte: ");
                    String pas = sc.nextLine();

                    Cliente c = new Cliente(idC, nomC, pas);

                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] == null) {
                            clientes[i] = c;
                            break;
                        }
                    }

                    System.out.println("cliente registrado");
                    break;

                case 4: // buscar por destino
                    System.out.print("ciudad destino: ");
                    String cd = sc.nextLine();

                    System.out.println("paquetes encontrados:");
                    for (PaqueteTuristico p : paquetes) {
                        if (p != null && p.getDestino().getNombreCiudad().equalsIgnoreCase(cd)) {
                            System.out.println(p.getNombre());
                        }
                    }
                    break;

                case 5: // buscar por duración
                    System.out.print("duracion (dias): ");
                    int dias = sc.nextInt();

                    System.out.println("paquetes con duracion " + dias + " dias:");
                    for (PaqueteTuristico p : paquetes) {
                        if (p != null && p.getDuracion() == dias) {
                            System.out.println(p.getNombre());
                        }
                    }
                    break;

                case 6: // crear reserva
                    System.out.println("clientes:");
                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] != null) {
                            System.out.println(i + " - " + clientes[i].getNombre());
                        }
                    }

                    System.out.print("elige cliente: ");
                    int posC = sc.nextInt();

                    System.out.println("paquetes:");
                    for (int i = 0; i < paquetes.length; i++) {
                        if (paquetes[i] != null) {
                            System.out.println(i + " - " + paquetes[i].getNombre());
                        }
                    }

                    System.out.print("elige paquete: ");
                    int posP = sc.nextInt();

                    System.out.print("fecha viaje (AAAA-MM-DD): ");
                    String fecha = sc.next();
                    LocalDate fv = LocalDate.parse(fecha);

                    System.out.print("numero personas: ");
                    int np = sc.nextInt();

                    ReservaViaje r = new ReservaViaje(1000 + posP, paquetes[posP], clientes[posC], fv, np);

                    for (int i = 0; i < reservas.length; i++) {
                        if (reservas[i] == null) {
                            reservas[i] = r;
                            break;
                        }
                    }

                    System.out.println("reserva creada");
                    break;

                case 7: // confirmar reserva
                    System.out.println("reservas solicitadas:");
                    for (int i = 0; i < reservas.length; i++) {
                        if (reservas[i] != null && reservas[i].getEstado() == EstadoReserva.SOLICITADA) {
                            System.out.println(i + " - " + reservas[i].resumen());
                        }
                    }

                    System.out.print("elige reserva: ");
                    int posR = sc.nextInt();

                    reservas[posR].confirmar();
                    System.out.println("reserva confirmada");
                    break;

                case 8: // cancelar reserva
                    System.out.println("reservas activas:");
                    for (int i = 0; i < reservas.length; i++) {
                        if (reservas[i] != null &&
                                (reservas[i].getEstado() == EstadoReserva.SOLICITADA ||
                                        reservas[i].getEstado() == EstadoReserva.CONFIRMADA)) {
                            System.out.println(i + " - " + reservas[i].resumen());
                        }
                    }

                    System.out.print("elige reserva: ");
                    int posRC = sc.nextInt();

                    reservas[posRC].cancelar(LocalDate.now());
                    System.out.println("reserva cancelada");
                    break;

                case 9: // ver reservas de un cliente
                    System.out.println("clientes:");
                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] != null) {
                            System.out.println(i + " - " + clientes[i].getNombre());
                        }
                    }

                    System.out.print("elige cliente: ");
                    int posCL = sc.nextInt();

                    System.out.println("reservas del cliente:");
                    for (ReservaViaje rv : reservas) {
                        if (rv != null && rv.getCliente() == clientes[posCL]) {
                            System.out.println(rv.resumen());
                        }
                    }
                    break;
            }

        } while (opcion != 0);
    }
}