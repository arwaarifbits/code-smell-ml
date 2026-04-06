package Gestion;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Empleado[] empleados = new Empleado[5];
        Proyecto proyecto = new Proyecto("WebApp", "Sistema de gestión", LocalDate.now(), LocalDate.now().plusMonths(3));

        proyecto.agregarFase(new Fase("ANALISIS"));
        proyecto.agregarFase(new Fase("DISEÑO"));

        empleados[0] = new Empleado(1, "Ana", "Programadora");
        empleados[1] = new Empleado(2, "Luis", "Tester");

        System.out.println("crear nueva tarea");
        System.out.print("id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("descripcion: ");
        String desc = sc.nextLine();

        System.out.print("dias hasta la fecha limite: ");
        int dias = sc.nextInt();

        Tarea nueva = new Tarea(id, desc, LocalDate.now().plusDays(dias));

        System.out.println("elige fase:");
        Fase[] fases = proyecto.getFases();
        for (int i = 0; i < fases.length; i++) {
            if (fases[i] != null) {
                System.out.println(i + " - " + fases[i].getNombre());
            }
        }

        int posFase = sc.nextInt();
        fases[posFase].agregarTarea(nueva);

        System.out.println("elige empleado:");
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null) {
                System.out.println(i + " - " + empleados[i].getNombre());
            }
        }

        int posEmp = sc.nextInt();
        nueva.asignarEmpleado(empleados[posEmp]);

        System.out.println("marcar tarea como completada? 1=si 0=no");
        int opc = sc.nextInt();
        if (opc == 1) {
            nueva.marcarCompletada();
        }

        proyecto.actualizarEstado();

        System.out.println("estado del proyecto: " + proyecto.getEstado());
    }
}