package Discusion;

public class Foro {
    private TemaForo tema;
    private Hilo[] hilos;

    public Foro(TemaForo tema) {
        this.tema = tema;
        this.hilos = new Hilo[20];
    }

    public boolean agregarHilo(Hilo h) {
        for (int i = 0; i < hilos.length; i++) {
            if (hilos[i] == null) {
                hilos[i] = h;
                return true;
            }
        }
        return false;
    }

    public Hilo[] getHilosOrdenadosPorUltimaFecha() {
        Hilo[] copia = new Hilo[hilos.length];
        System.arraycopy(hilos, 0, copia, 0, hilos.length);

        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = i + 1; j < copia.length; j++) {
                if (copia[i] != null && copia[j] != null &&
                        copia[i].getUltimaFecha().isBefore(copia[j].getUltimaFecha())) {
                    Hilo temp = copia[i];
                    copia[i] = copia[j];
                    copia[j] = temp;
                }
            }
        }

        return copia;
    }

    public TemaForo getTema() {
        return tema;
    }

    public void setTema(TemaForo tema) {
        this.tema = tema;
    }

    public Hilo[] getHilos() {
        return hilos;
    }

    public void setHilos(Hilo[] hilos) {
        this.hilos = hilos;
    }
}