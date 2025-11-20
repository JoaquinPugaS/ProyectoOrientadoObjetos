/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author Puga
 */
public class Venta {
    private int idVenta;
    private LocalDateTime fcIngreso;
    private int cdTpMetodoPago;

    public Venta() {
    }

    public Venta(int idVenta, LocalDateTime fcIngreso, int cdTpMetodoPago) {
        this.idVenta = idVenta;
        this.fcIngreso = fcIngreso;
        this.cdTpMetodoPago = cdTpMetodoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFcIngreso() {
        return fcIngreso;
    }

    public void setFcIngreso(LocalDateTime fcIngreso) {
        this.fcIngreso = fcIngreso;
    }

    public int getCdTpMetodoPago() {
        return cdTpMetodoPago;
    }

    public void setCdTpMetodoPago(int cdTpMetodoPago) {
        this.cdTpMetodoPago = cdTpMetodoPago;
    }
    
    
}
