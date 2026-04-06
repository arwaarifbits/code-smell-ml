package Videoclub;

public class SistemaPrecio {
    private Precio[] precios;

    public SistemaPrecio() {
        precios = new Precio[] {
          new Precio(Formato.DVD, 10),
          new Precio(Formato.BLURAY, 20)
        };
    }

    public double RecuperarPrecio(Formato formato) {
        for(Precio p : precios) {
            if (p.formato == formato) return p.price;
        }

        return -1;

    }
}
