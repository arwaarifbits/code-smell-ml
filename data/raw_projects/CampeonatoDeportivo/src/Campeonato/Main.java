package Campeonato;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Equipo[] equipos = new Equipo[20];
        Jornada[] jornadas = new Jornada[20];
        RegistroClasificacion[] tabla = new RegistroClasificacion[20];

        int opcion;

        do {
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar jugador en equipo");
            System.out.println("3. Crear jornada");
            System.out.println("4. Crear partido en jornada");
            System.out.println("5. Registrar resultado de partido");
            System.out.println("6. Ver clasificación");
            System.out.println("7. Ver resultados de una jornada");
            System.out.println("8. Ver partidos de un equipo");
            System.out.println("0. Salir");
            System.out.print("opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("nombre equipo: ");
                    String nombre = sc.nextLine();
                    System.out.print("ciudad: ");
                    String ciudad = sc.nextLine();

                    Equipo eq = new Equipo(nombre, ciudad);

                    for (int i = 0; i < equipos.length; i++) {
                        if (equipos[i] == null) {
                            equipos[i] = eq;
                            tabla[i] = new RegistroClasificacion(eq);
                            break;
                        }
                    }

                    System.out.println("equipo registrado");
                    break;

                case 2:
                    System.out.println("equipos:");
                    for (int i = 0; i < equipos.length; i++) {
                        if (equipos[i] != null) {
                            System.out.println(i + " - " + equipos[i].getNombre());
                        }
                    }

                    System.out.print("elige equipo: ");
                    int posEq = sc.nextInt();
                    sc.nextLine();

                    System.out.print("nombre jugador: ");
                    String nj = sc.nextLine();
                    System.out.print("posicion (0=PORTERO 1=DEFENSA 2=CENTROCAMPISTA 3=DELANTERO): ");
                    int pos = sc.nextInt();
                    System.out.print("dorsal: ");
                    int dorsal = sc.nextInt();

                    Jugador jug = new Jugador(nj, Posicion.values()[pos], dorsal);
                    equipos[posEq].agregarJugador(jug);

                    System.out.println("jugador añadido");
                    break;

                case 3:
                    System.out.print("dias desde hoy: ");
                    int dias = sc.nextInt();

                    Jornada j = new Jornada(LocalDate.now().plusDays(dias));

                    for (int i = 0; i < jornadas.length; i++) {
                        if (jornadas[i] == null) {
                            jornadas[i] = j;
                            break;
                        }
                    }

                    System.out.println("jornada creada");
                    break;

                case 4:
                    System.out.println("jornadas:");
                    for (int i = 0; i < jornadas.length; i++) {
                        if (jornadas[i] != null) {
                            System.out.println(i + " - " + jornadas[i].getFecha());
                        }
                    }

                    System.out.print("elige jornada: ");
                    int posJ = sc.nextInt();

                    System.out.println("equipos:");
                    for (int i = 0; i < equipos.length; i++) {
                        if (equipos[i] != null) {
                            System.out.println(i + " - " + equipos[i].getNombre());
                        }
                    }

                    System.out.print("equipo local: ");
                    int loc = sc.nextInt();
                    System.out.print("equipo visitante: ");
                    int vis = sc.nextInt();

                    Partido p = new Partido(equipos[loc], equipos[vis]);
                    jornadas[posJ].agregarPartido(p);

                    System.out.println("partido creado");
                    break;

                case 5:
                    System.out.println("jornadas:");
                    for (int i = 0; i < jornadas.length; i++) {
                        if (jornadas[i] != null) {
                            System.out.println(i + " - " + jornadas[i].getFecha());
                        }
                    }

                    System.out.print("elige jornada: ");
                    int jRes = sc.nextInt();

                    Partido[] partidos = jornadas[jRes].getPartidos();

                    for (int i = 0; i < partidos.length; i++) {
                        if (partidos[i] != null) {
                            System.out.println(i + " - " + partidos[i].getLocal().getNombre() +
                                    " vs " + partidos[i].getVisitante().getNombre());
                        }
                    }

                    System.out.print("elige partido: ");
                    int pRes = sc.nextInt();

                    System.out.print("goles local: ");
                    int gl = sc.nextInt();
                    System.out.print("goles visitante: ");
                    int gv = sc.nextInt();

                    partidos[pRes].registrarResultado(gl, gv);

                    for (RegistroClasificacion rc : tabla) {
                        if (rc != null) {
                            if (rc.getEquipo() == partidos[pRes].getLocal()) rc.actualizar(gl, gv);
                            if (rc.getEquipo() == partidos[pRes].getVisitante()) rc.actualizar(gv, gl);
                        }
                    }

                    System.out.println("resultado registrado");
                    break;

                case 6:
                    RegistroClasificacion[] copia = tabla.clone();

                    for (int i = 0; i < copia.length - 1; i++) {
                        for (int k = i + 1; k < copia.length; k++) {
                            if (copia[i] != null && copia[k] != null) {
                                boolean peor =
                                        copia[i].getPuntos() < copia[k].getPuntos() ||
                                                (copia[i].getPuntos() == copia[k].getPuntos() &&
                                                        copia[i].getGolAverage() < copia[k].getGolAverage());

                                if (peor) {
                                    RegistroClasificacion tmp = copia[i];
                                    copia[i] = copia[k];
                                    copia[k] = tmp;
                                }
                            }
                        }
                    }

                    System.out.println("CLASIFICACION:");
                    for (RegistroClasificacion rc : copia) {
                        if (rc != null) System.out.println(rc.toString());
                    }
                    break;

                case 7:
                    System.out.println("jornadas:");
                    for (int i = 0; i < jornadas.length; i++) {
                        if (jornadas[i] != null) {
                            System.out.println(i + " - " + jornadas[i].getFecha());
                        }
                    }

                    System.out.print("elige jornada: ");
                    int jVer = sc.nextInt();

                    System.out.println("RESULTADOS:");
                    for (Partido partido : jornadas[jVer].getPartidos()) {
                        if (partido != null && partido.getEstado() == EstadoPartido.FINALIZADO) {
                            System.out.println(partido.getLocal().getNombre() + " " +
                                    partido.getGolesLocal() + " - " +
                                    partido.getGolesVisitante() + " " +
                                    partido.getVisitante().getNombre());
                        }
                    }
                    break;

                case 8:
                    System.out.println("equipos:");
                    for (int i = 0; i < equipos.length; i++) {
                        if (equipos[i] != null) {
                            System.out.println(i + " - " + equipos[i].getNombre());
                        }
                    }

                    System.out.print("elige equipo: ");
                    int eqBuscado = sc.nextInt();
                    Equipo buscado = equipos[eqBuscado];

                    System.out.println("PARTIDOS DE " + buscado.getNombre() + ":");

                    for (Jornada jornada : jornadas) {
                        if (jornada != null) {
                            for (Partido partido : jornada.getPartidos()) {
                                if (partido != null &&
                                        (partido.getLocal() == buscado || partido.getVisitante() == buscado)) {
                                    System.out.println(jornada.getFecha() + " -> " +
                                            partido.getLocal().getNombre() + " vs " +
                                            partido.getVisitante().getNombre());
                                }
                            }
                        }
                    }
                    break;
            }

        } while (true);
    }
}