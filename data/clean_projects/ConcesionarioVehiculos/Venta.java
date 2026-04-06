package Concesionarios;

import java.time.LocalDate;

public class Venta {
    private int idVenta;
    private Vehiculo vehiculo;
    private Vendedor vendedor;
    private Cliente cliente;
    private double precioFinal;
    private LocalDate fechaVenta;

    public Venta(int idVenta, Vehiculo vehiculo, Vendedor vendedor, Cliente cliente, double precioFinal) {
        this.idVenta = idVenta;
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.precioFinal = precioFinal;
        this.fechaVenta = LocalDate.now();
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}