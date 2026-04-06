package Restaurante;

import java.time.LocalDate;

public class Pedido {
    private int numeroPedido;
    private Cliente cliente;
    private LineaPedido[] lineas;
    private LocalDate fechaPedido;
    private double costeTotal;
    private EstadoPedido estado;

    public Pedido(int numeroPedido, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.lineas = new LineaPedido[10];
        this.fechaPedido = LocalDate.now();
        this.estado = EstadoPedido.RECIBIDO;
    }

    public void agregarLinea(LineaPedido lp) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] == null) {
                lineas[i] = lp;
                return;
            }
        }
    }

    public void calcularCosteTotal() {
        double total = 0;
        for (LineaPedido lp : lineas) {
            if (lp != null) {
                total += lp.getSubtotal();
            }
        }
        this.costeTotal = total;
    }

    public void actualizarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LineaPedido[] getLineas() {
        return lineas;
    }

    public void setLineas(LineaPedido[] lineas) {
        this.lineas = lineas;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}