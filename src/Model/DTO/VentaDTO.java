/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DTO;

import Model.DetalleVenta;
import java.util.List;

/**
 *
 * @author Puga
 */
public class VentaDTO {
    
    private List<ProductoDTO> detalleVenta;
    private int tpMetodoPago;

    public VentaDTO(List<ProductoDTO> detalleVenta, int tpMetodoPago) {
        this.detalleVenta = detalleVenta;
        this.tpMetodoPago = tpMetodoPago;
    }

    public VentaDTO() {
    }

    public List<ProductoDTO> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<ProductoDTO> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public int getTpMetodoPago() {
        return tpMetodoPago;
    }

    public void setTpMetodoPago(int tpMetodoPago) {
        this.tpMetodoPago = tpMetodoPago;
    }
    
    
}
