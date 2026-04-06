package Concesionarios;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vehiculo[] stock = new Vehiculo[20];
        Venta[] historico = new Venta[50];
        Cliente[] clientes = new Cliente[20];
        Vendedor[] vendedores = new Vendedor[10];

        vendedores[0] = new Vendedor(1, "Carlos");

        int opcion;

        do {
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Registrar venta");
            System.out.println("4. Reporte ventas por vendedor");
            System.out.println("5. Calcular comisiones vendedor");
            System.out.println("0. Salir");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("matricula: ");
                    String mat = sc.nextLine();

                    boolean existe = false;
                    for (Vehiculo v : stock) {
                        if (v != null && v.getMatricula().equals(mat)) {
                            existe = true;
                            break;
                        }
                    }
                    if (existe) {
                        System.out.println("ya existe un vehículo con esa matrícula");
                        break;
                    }

                    System.out.print("marca: ");
                    String marca = sc.nextLine();
                    System.out.print("modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("año: ");
                    int año = sc.nextInt();
                    System.out.print("precio base: ");
                    double precio = sc.nextDouble();
                    System.out.print("tipo (0=coche 1=moto 2=furgoneta): ");
                    int t = sc.nextInt();
                    System.out.print("estado (0=nuevo 1=seminuevo): ");
                    int e = sc.nextInt();
                    int km = 0;
                    if (e == 1) {
                        System.out.print("kilometraje: ");
                        km = sc.nextInt();
                    }

                    Vehiculo nuevo = new Vehiculo(mat, marca, modelo, año, precio,
                            TipoVehiculo.values()[t], EstadoVehiculo.values()[e], km);

                    for (int i = 0; i < stock.length; i++) {
                        if (stock[i] == null) {
                            stock[i] = nuevo;
                            break;
                        }
                    }

                    System.out.println("vehículo registrado");
                    break;

                case 2:
                    System.out.print("dni: ");
                    String dni = sc.nextLine();
                    System.out.print("nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("telefono: ");
                    String tel = sc.nextLine();

                    Cliente c = new Cliente(dni, nombre, tel);

                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] == null) {
                            clientes[i] = c;
                            vendedores[0].agregarCliente(c);
                            break;
                        }
                    }

                    System.out.println("cliente registrado");
                    break;

                case 3:
                    System.out.println("vehículos disponibles:");
                    for (int i = 0; i < stock.length; i++) {
                        if (stock[i] != null) {
                            System.out.println(i + " - " + stock[i].getMarca() + " " + stock[i].getModelo());
                        }
                    }

                    System.out.print("elige vehículo: ");
                    int pos = sc.nextInt();
                    Vehiculo veh = stock[pos];

                    System.out.println("clientes:");
                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] != null) {
                            System.out.println(i + " - " + clientes[i].getNombre());
                        }
                    }

                    System.out.print("elige cliente: ");
                    int posC = sc.nextInt();
                    Cliente cli = clientes[posC];

                    System.out.print("precio final: ");
                    double pf = sc.nextDouble();

                    Venta venta = new Venta(1000 + pos, veh, vendedores[0], cli, pf);

                    for (int i = 0; i < historico.length; i++) {
                        if (historico[i] == null) {
                            historico[i] = venta;
                            break;
                        }
                    }

                    stock[pos] = null;

                    System.out.println("venta registrada");
                    break;

                case 4:
                    System.out.print("id vendedor: ");
                    int idV = sc.nextInt();

                    System.out.print("año inicio: ");
                    int ai = sc.nextInt();
                    System.out.print("año fin: ");
                    int af = sc.nextInt();

                    LocalDate inicio = LocalDate.of(ai, 1, 1);
                    LocalDate fin = LocalDate.of(af, 12, 31);

                    System.out.println("ventas del vendedor " + idV + ":");

                    for (Venta ve : historico) {
                        if (ve != null &&
                                ve.getVendedor().getId() == idV &&
                                (ve.getFechaVenta().isAfter(inicio.minusDays(1)) &&
                                        ve.getFechaVenta().isBefore(fin.plusDays(1)))) {

                            System.out.println("venta: " + ve.getPrecioFinal() + " €");
                        }
                    }
                    break;

                case 5:
                    System.out.print("id vendedor: ");
                    int idCom = sc.nextInt();

                    double total = 0;

                    for (Venta ve : historico) {
                        if (ve != null && ve.getVendedor().getId() == idCom) {
                            total += ve.getPrecioFinal() * 0.02;
                        }
                    }

                    System.out.println("comision total: " + total + " €");
                    break;
            }

        } while (true);
    }
}