package Almacen;

public class Proveedor {
    private int id;
    private String nombre;
    private Producto[] productos;

    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.productos = new Producto[10];
    }

    public void agregarProducto(Producto p) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = p;
                break;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
}