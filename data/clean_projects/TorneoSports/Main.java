package Torneo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Jugador[] jugadores = new Jugador[50];
        Equipo[] equipos = new Equipo[20];
        Torneo[] torneos = new Torneo[5];

        int opcion;

        do {
            System.out.println("1. Registrar jugador");
            System.out.println("2. Crear equipo");
            System.out.println("3. Añadir jugador a equipo");
            System.out.println("4. Crear torneo");
            System.out.println("5. Inscribir equipo en torneo");
            System.out.println("6. Cerrar inscripciones y generar bracket");
            System.out.println("7. Ver enfrentamientos");
            System.out.println("8. Introducir resultado");
            System.out.println("9. Avanzar ronda");
            System.out.println("10. Ver jugadores de un equipo");
            System.out.println("11. Ver equipos de un torneo");
            System.out.println("0. Salir");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: // registrar jugador
                    System.out.print("nickname: ");
                    String nick = sc.nextLine();
                    System.out.print("nombre real: ");
                    String nombre = sc.nextLine();
                    System.out.print("fecha nacimiento (AAAA-MM-DD): ");
                    LocalDate fn = LocalDate.parse(sc.nextLine());

                    Jugador j = new Jugador(nick, nombre, fn);
                    for (int i = 0; i < jugadores.length; i++) {
                        if (jugadores[i] == null) {
                            jugadores[i] = j;
                            break;
                        }
                    }
                    System.out.println("jugador registrado");
                    break;

                case 2: // crear equipo
                    System.out.print("nombre equipo: ");
                    String ne = sc.nextLine();
                    Equipo eq = new Equipo(ne);
                    for (int i = 0; i < equipos.length; i++) {
                        if (equipos[i] == null) {
                            equipos[i] = eq;
                            break;
                        }
                    }
                    System.out.println("equipo creado");
                    break;

                case 3: // añadir jugador a equipo
                    System.out.println("jugadores:");
                    for (int i = 0; i < jugadores.length; i++) {
                        if (jugadores[i] != null) {
                            System.out.println(i + " - " + jugadores[i].getNickname());
                        }
                    }
                    System.out.print("elige jugador: ");
                    int pj = sc.nextInt();

                    System.out.println("equipos:");
                    for (int i = 0; i < equipos.length; i++) {
                        if (equipos[i] != null) {
                            System.out.println(i + " - " + equipos[i].getNombre());
                        }
                    }
                    System.out.print("elige equipo: ");
                    int pe = sc.nextInt();

                    equipos[pe].agregarJugador(jugadores[pj]);
                    System.out.println("jugador añadido al equipo");
                    break;

                case 4: // crear torneo
                    System.out.print("nombre torneo: ");
                    String nt = sc.nextLine();
                    System.out.print("fecha inicio (AAAA-MM-DD): ");
                    LocalDate fi = LocalDate.parse(sc.nextLine());
                    System.out.print("videojuego (0=LOL 1=VALORANT 2=CS): ");
                    int vj = sc.nextInt();
                    System.out.print("formato (0=ELIMINATORIA 1=LIGA): ");
                    int ft = sc.nextInt();

                    Torneo t = new Torneo(nt, Videojuego.values()[vj], fi, FormatoTorneo.values()[ft]);
                    for (int i = 0; i < torneos.length; i++) {
                        if (torneos[i] == null) {
                            torneos[i] = t;
                            break;
                        }
                    }
                    System.out.println("torneo creado");
                    break;

                case 5: // inscribir equipo
                    System.out.println("equipos:");
                    for (int i = 0; i < equipos.length; i++) {
                        if (equipos[i] != null) {
                            System.out.println(i + " - " + equipos[i].getNombre());
                        }
                    }
                    System.out.print("elige equipo: ");
                    int eqi = sc.nextInt();

                    System.out.println("torneos:");
                    for (int i = 0; i < torneos.length; i++) {
                        if (torneos[i] != null) {
                            System.out.println(i + " - " + torneos[i].getVideojuego() + " - " + torneos[i].getEquipos().length + " equipos");
                        }
                    }
                    System.out.print("elige torneo: ");
                    int ti = sc.nextInt();

                    torneos[ti].inscribirEquipo(equipos[eqi]);
                    System.out.println("equipo inscrito");
                    break;

                case 6: // cerrar inscripciones
                    System.out.println("torneos:");
                    for (int i = 0; i < torneos.length; i++) {
                        if (torneos[i] != null) {
                            System.out.println(i + " - " + torneos[i].getVideojuego());
                        }
                    }
                    System.out.print("elige torneo: ");
                    int tc = sc.nextInt();

                    torneos[tc].cerrarInscripciones();
                    System.out.println("inscripciones cerradas y bracket generado");
                    break;

                case 7: // ver enfrentamientos
                    System.out.print("torneo: ");
                    int tv = sc.nextInt();
                    Enfrentamiento[] enf = torneos[tv].getEnfrentamientos();
                    for (Enfrentamiento e : enf) {
                        if (e != null) {
                            System.out.println(e.resumen());
                        }
                    }
                    break;

                case 8: // introducir resultado
                    System.out.print("torneo: ");
                    int tr = sc.nextInt();
                    Enfrentamiento[] lista = torneos[tr].getEnfrentamientos();

                    for (int i = 0; i < lista.length; i++) {
                        if (lista[i] != null && lista[i].getEstado() == EstadoEnfrentamiento.PENDIENTE) {
                            System.out.println(i + " - " + lista[i].resumen());
                        }
                    }

                    System.out.print("el administrador elige el enfrentamiento: ");
                    int enfId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("resultado (ej. 2-1): ");
                    String res = sc.nextLine();

                    System.out.println("ganador (0=A 1=B): ");
                    int ganador = sc.nextInt();
                    Equipo ganadorEq;
                    if (ganador == 0) {
                        ganadorEq = lista[enfId].getEquipoA();
                    } else {
                        ganadorEq = lista[enfId].getEquipoB();
                    }


                    lista[enfId].finalizar(res, ganadorEq);
                    System.out.println("resultado registrado");
                    break;

                case 9: // avanzar ronda
                    System.out.print("torneo: ");
                    int ta = sc.nextInt();
                    torneos[ta].avanzarRonda();
                    System.out.println("ronda avanzada");
                    break;

                case 10: // ver jugadores de equipo
                    System.out.print("equipo: ");
                    int ve = sc.nextInt();
                    for (Jugador jj : equipos[ve].getJugadores()) {
                        if (jj != null) {
                            System.out.println(jj.getNickname() + " - " + jj.getNombreReal());
                        }
                    }
                    break;

                case 11: // ver equipos de torneo
                    System.out.print("torneo: ");
                    int vt = sc.nextInt();
                    for (Equipo eqx : torneos[vt].getEquipos()) {
                        if (eqx != null) {
                            System.out.println(eqx.getNombre());
                        }
                    }
                    break;
            }

        } while (opcion != 0);
    }
}