package Agencia;

public class Destino {
    private String nombreCiudad;
    private String pais;

    public Destino(String ciudad, String pais) {
        this.nombreCiudad = ciudad;
        this.pais = pais;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}