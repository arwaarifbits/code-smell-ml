package Receta;

public class Usuario {
    private String username;
    private String email;
    private Receta[] favoritas;

    public Usuario(String username, String email) {
        this.username = username;
        this.email = email;
        this.favoritas = new Receta[20];
    }



    public void marcarFavorita(Receta r) {
        for (int i = 0; i < favoritas.length; i++) {
            if (favoritas[i] == null) {
                favoritas[i] = r;
                break;
            }
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Receta[] getFavoritas() {
        return favoritas;
    }

    public void setFavoritas(Receta[] favoritas) {
        this.favoritas = favoritas;
    }
}