package Almacen;

import java.time.LocalDate;

public class MovimientoStock {
    private Producto producto;
    private int cantidad;
    private TipoMovimiento tipo;
    private LocalDate fecha;
    private Ubicacion ubicacion;

    public MovimientoStock(Producto producto, int cantidad, TipoMovimiento tipo, Ubicacion ubicacion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.fecha = LocalDate.now();
        this.ubicacion = ubicacion;
        ubicacion.moverStock(producto, cantidad, tipo);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
