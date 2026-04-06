package Almacen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto[] productos = new Producto[20];
        Proveedor[] proveedores = new Proveedor[10];
        Ubicacion[] ubicaciones = new Ubicacion[10];
        OrdenCompra[] ordenes = new OrdenCompra[20];

        int opcion;

        do {
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar proveedor");
            System.out.println("3. Crear ubicación");
            System.out.println("4. Movimiento de stock");
            System.out.println("5. Ver ubicación de producto");
            System.out.println("6. Generar orden si hay bajo stock");
            System.out.println("7. Recibir orden");
            System.out.println("8. Ver productos bajo stock mínimo");
            System.out.println("0. Salir");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("sku: ");
                    String sku = sc.nextLine();
                    System.out.print("nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("stock mínimo: ");
                    int min = sc.nextInt();

                    Producto p = new Producto(sku, nombre, min);
                    for (int i = 0; i < productos.length; i++) {
                        if (productos[i] == null) {
                            productos[i] = p;
                            break;
                        }
                    }
                    System.out.println("producto registrado");
                    break;

                case 2:
                    System.out.print("id proveedor: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("nombre proveedor: ");
                    String nomProv = sc.nextLine();

                    Proveedor prov = new Proveedor(id, nomProv);
                    for (int i = 0; i < proveedores.length; i++) {
                        if (proveedores[i] == null) {
                            proveedores[i] = prov;
                            break;
                        }
                    }

                    System.out.println("productos:");
                    for (int i = 0; i < productos.length; i++) {
                        if (productos[i] != null) {
                            System.out.println(i + " - " + productos[i].getNombre());
                        }
                    }

                    System.out.print("elige producto que suministra: ");
                    int pos = sc.nextInt();
                    prov.agregarProducto(productos[pos]);

                    System.out.println("proveedor registrado");
                    break;

                case 3: // ubicación
                    System.out.print("codigo ubicación: ");
                    String cod = sc.nextLine();
                    Ubicacion u = new Ubicacion(cod);
                    for (int i = 0; i < ubicaciones.length; i++) {
                        if (ubicaciones[i] == null) {
                            ubicaciones[i] = u;
                            break;
                        }
                    }
                    System.out.println("ubicación creada");
                    break;

                case 4:
                    System.out.println("productos:");
                    for (int i = 0; i < productos.length; i++) {
                        if (productos[i] != null) {
                            System.out.println(i + " - " + productos[i].getNombre());
                        }
                    }
                    System.out.print("elige producto: ");
                    int pp = sc.nextInt();

                    System.out.println("ubicaciones:");
                    for (int i = 0; i < ubicaciones.length; i++) {
                        if (ubicaciones[i] != null) {
                            System.out.println(i + " - " + ubicaciones[i].getCodigo());
                        }
                    }
                    System.out.print("elige ubicación: ");
                    int uu = sc.nextInt();

                    System.out.print("cantidad: ");
                    int cant = sc.nextInt();
                    System.out.print("tipo (0=ENTRADA 1=SALIDA): ");
                    int tipo = sc.nextInt();

                    new MovimientoStock(productos[pp], cant, TipoMovimiento.values()[tipo], ubicaciones[uu]);
                    System.out.println("movimiento registrado");
                    break;

                case 5:
                    System.out.println("productos:");
                    for (int i = 0; i < productos.length; i++) {
                        if (productos[i] != null) {
                            System.out.println(i + " - " + productos[i].getNombre());
                        }
                    }

                    System.out.print("elige producto: ");
                    int prodUbic = sc.nextInt();
                    Producto buscado = productos[prodUbic];

                    System.out.println("ubicaciones con stock de " + buscado.getNombre() + ":");
                    for (Ubicacion ub : ubicaciones) {
                        if (ub != null && ub.getStockTotal(buscado) > 0) {
                            System.out.println(ub.getCodigo() + " -> " + ub.getStockTotal(buscado) + " unidades");
                        }
                    }
                    break;

                case 6:
                    for (Producto prod : productos) {
                        if (prod != null) {
                            int total = 0;
                            for (Ubicacion ub : ubicaciones) {
                                if (ub != null) {
                                    total += ub.getStockTotal(prod);
                                }
                            }

                            if (total < prod.getStockMinimo()) {
                                // buscar proveedor que lo suministra
                                Proveedor proveedor = null;
                                for (Proveedor provi : proveedores) {
                                    if (provi != null) {
                                        for (Producto pk : provi.getProductos()) {
                                            if (pk != null && pk.getSku().equals(prod.getSku())) {
                                                proveedor = provi;
                                                break;
                                            }
                                        }
                                    }
                                    if (proveedor != null) break;
                                }

                                if (proveedor != null) {
                                    OrdenCompra orden = new OrdenCompra(1000 + prod.hashCode() % 1000, proveedor, prod, prod.getStockMinimo() * 2);
                                    for (int i = 0; i < ordenes.length; i++) {
                                        if (ordenes[i] == null) {
                                            ordenes[i] = orden;
                                            System.out.println("orden generada: " + orden.resumen());
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 7:
                    System.out.println("ordenes pendientes:");
                    for (int i = 0; i < ordenes.length; i++) {
                        if (ordenes[i] != null && ordenes[i].getEstado() == EstadoOrden.PENDIENTE) {
                            System.out.println(i + " - " + ordenes[i].resumen());
                        }
                    }

                    System.out.print("elige orden: ");
                    int ord = sc.nextInt();

                    System.out.println("ubicaciones:");
                    for (int i = 0; i < ubicaciones.length; i++) {
                        if (ubicaciones[i] != null) {
                            System.out.println(i + " - " + ubicaciones[i].getCodigo());
                        }
                    }

                    System.out.print("elige ubicación para recibir: ");
                    int ubRec = sc.nextInt();

                    ordenes[ord].recibir(ubicaciones[ubRec]);
                    System.out.println("orden recibida y stock actualizado");
                    break;

                case 8:
                    System.out.println("productos bajo stock mínimo:");
                    for (Producto prod : productos) {
                        if (prod != null) {
                            int total = 0;
                            for (Ubicacion ub : ubicaciones) {
                                if (ub != null) {
                                    total += ub.getStockTotal(prod);
                                }
                            }

                            if (total < prod.getStockMinimo()) {
                                System.out.println(prod.getNombre() + " -> " + total + " unidades (mínimo: " + prod.getStockMinimo() + ")");
                            }
                        }
                    }
                    break;
            }

        } while (opcion != 0);
    }
}