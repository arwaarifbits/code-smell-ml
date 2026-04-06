package Almacen;

import java.time.LocalDate;

public class OrdenCompra {
    private int id;
    private Proveedor proveedor;
    private Producto producto;
    private int cantidad;
    private LocalDate fechaCreacion;
    private EstadoOrden estado;

    public OrdenCompra(int id, Proveedor proveedor, Producto producto, int cantidad) {
        this.id = id;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaCreacion = LocalDate.now();
        this.estado = EstadoOrden.PENDIENTE;
    }

    public void recibir(Ubicacion ubicacion) {
        if (estado == EstadoOrden.PENDIENTE) {
            new MovimientoStock(producto, cantidad, TipoMovimiento.ENTRADA, ubicacion);
            estado = EstadoOrden.RECIBIDA;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public String resumen() {
        return "Orden " + id + ": " + producto.getNombre() + " x" + cantidad + " [" + estado + "]";
    }
}