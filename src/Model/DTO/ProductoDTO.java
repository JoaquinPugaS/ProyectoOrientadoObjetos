/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DTO;

/**
 *
 * @author Puga
 */
public class ProductoDTO {
    private int idInventario;
    private int cantidadProducto;

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public ProductoDTO(int idProducto, int cantidadProducto) {
        this.idInventario = idProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public ProductoDTO() {
    }
    
}
