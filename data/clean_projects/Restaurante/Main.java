package Restaurante;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Plato[] menu = new Plato[5];
        Cliente[] clientes = new Cliente[5];
        Pedido[] pedidos = new Pedido[10];

        menu[0] = new Plato("Hamburguesa", "Carne con queso", 5.0, Categoria.PRINCIPAL);
        menu[1] = new Plato("Patatas", "Fritas", 2.0, Categoria.ENTRANTE);
        menu[2] = new Plato("Coca-Cola", "Bebida fría", 1.5, Categoria.BEBIDA);

        System.out.print("id cliente: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("nombre: ");
        String nombre = sc.nextLine();
        System.out.print("direccion: ");
        String dir = sc.nextLine();
        System.out.print("telefono: ");
        String tel = sc.nextLine();

        Cliente c = new Cliente(id, nombre, dir, tel);
        clientes[0] = c;

        Pedido p = new Pedido(1001, c);


        System.out.println("elige plato:");
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.println(i + " - " + menu[i].getNombre());
            }
        }

        int opcion = sc.nextInt();
        System.out.print("cantidad: ");
        int cantidad = sc.nextInt();

        LineaPedido lp = new LineaPedido(menu[opcion], cantidad);
        p.agregarLinea(lp);

        p.calcularCosteTotal();
        pedidos[0] = p;

        System.out.println("pedido creado. total: " + p.getCosteTotal() + " €");
        System.out.println("estado: " + p.getEstado());
    }
}