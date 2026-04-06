package Almacen;

public class Producto {
    private String sku;
    private String nombre;
    private int stockMinimo;

    public Producto(String sku, String nombre, int stockMinimo) {
        this.sku = sku;
        this.nombre = nombre;
        this.stockMinimo = stockMinimo;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}