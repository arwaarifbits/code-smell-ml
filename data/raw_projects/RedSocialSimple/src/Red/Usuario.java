package Red;

public class Usuario {

    private String username;
    private String password;
    private String email;
    private Usuario[] seguidos = new Usuario[100];
    private Usuario[] seguidores = new Usuario[100];
    private int totalSeguidos = 0;
    private int totalSeguidores = 0;

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public void seguir(Usuario otro) {
        seguidos[totalSeguidos] = otro;
        totalSeguidos++;

        otro.seguidores[otro.totalSeguidores] = this;
        otro.totalSeguidores++;
    }

    public Usuario[] getSeguidos() {
        return seguidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSeguidos(Usuario[] seguidos) {
        this.seguidos = seguidos;
    }

    public Usuario[] getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Usuario[] seguidores) {
        this.seguidores = seguidores;
    }

    public int getTotalSeguidos() {
        return totalSeguidos;
    }

    public void setTotalSeguidos(int totalSeguidos) {
        this.totalSeguidos = totalSeguidos;
    }

    public int getTotalSeguidores() {
        return totalSeguidores;
    }

    public void setTotalSeguidores(int totalSeguidores) {
        this.totalSeguidores = totalSeguidores;
    }
}