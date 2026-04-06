package Almacen;

public class Ubicacion {
    private String codigo;
    private Producto[] productos;
    private int[] cantidades;

    public Ubicacion(String codigo) {
        this.codigo = codigo;
        this.productos = new Producto[20];
        this.cantidades = new int[20];
    }

    public void moverStock(Producto p, int cantidad, TipoMovimiento tipo) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = p;
                cantidades[i] = (tipo == TipoMovimiento.ENTRADA) ? cantidad : -cantidad;
                return;
            }
            if (productos[i].getSku().equals(p.getSku())) {
                cantidades[i] += (tipo == TipoMovimiento.ENTRADA) ? cantidad : -cantidad;
                return;
            }
        }
    }

    public int getStockTotal(Producto p) {
        int total = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getSku().equals(p.getSku())) {
                total += cantidades[i];
            }
        }
        return total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public int[] getCantidades() {
        return cantidades;
    }

    public void setCantidades(int[] cantidades) {
        this.cantidades = cantidades;
    }
}
