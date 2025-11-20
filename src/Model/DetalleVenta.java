package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Puga
 */
public class DetalleVenta {
    private int idDetalleVenta;
    private int idVenta;
    private int idInventario;
    private int cantidad;
    private boolean lgEliminado = false;

    public DetalleVenta() {
    }

    public DetalleVenta(int idInventario, int cantidad) {
        this.idInventario = idInventario;
        this.cantidad = cantidad;
    }
    
    public DetalleVenta(int idDetalleVenta, int idVenta, int idInventario, int cantidad) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.idInventario = idInventario;
        this.cantidad = cantidad;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isLgEliminado() {
        return lgEliminado;
    }

    public void setLgEliminado(boolean lgEliminado) {
        this.lgEliminado = lgEliminado;
    }
    
    
}
