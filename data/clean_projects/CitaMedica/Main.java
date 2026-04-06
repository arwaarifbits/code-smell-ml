package Cita;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Paciente[] pacientes = new Paciente[10];
        Medico[] medicos = new Medico[5];
        Cita[] citas = new Cita[20];

        medicos[0] = new Medico(1, "Dr. Pérez", Especialidad.MEDICINA_GENERAL);
        medicos[1] = new Medico(2, "Dra. Gómez", Especialidad.CARDIOLOGIA);
        medicos[0].agregarDisponibilidad(LocalDate.now().plusDays(2));
        medicos[1].agregarDisponibilidad(LocalDate.now().plusDays(2));

        System.out.print("dni paciente: ");
        String dni = sc.nextLine();
        System.out.print("nombre paciente: ");
        String nombre = sc.nextLine();
        System.out.print("año nacimiento: ");
        int año = sc.nextInt();
        Paciente p = new Paciente(dni, nombre, LocalDate.of(año, 1, 1));
        pacientes[0] = p;

        System.out.println("elige especialidad: 0=MEDICINA_GENERAL 1=PEDIATRIA 2=TRAUMATOLOGIA 3=CARDIOLOGIA");
        int esp = sc.nextInt();
        System.out.print("dias hasta la cita: ");
        int dias = sc.nextInt();
        LocalDate fecha = LocalDate.now().plusDays(dias);

        for (Medico m : medicos) {
            if (m != null && m.getEspecialidad().ordinal() == esp && m.estaDisponible(fecha)) {
                Cita c = new Cita(1001, p, m, fecha);
                citas[0] = c;
                System.out.println("cita programada con " + m.getNombre() + " el " + fecha);
                break;
            }
        }
    }
}