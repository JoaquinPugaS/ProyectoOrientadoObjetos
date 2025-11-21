/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Puga
 */
public class GetInventario {
    private int idInventario;
    private int idProducto;
    private String nmProducto;
    private int medida;
    private String nmMedida;
    private int precioProducto;
    private int stock;
    private Boolean lgEliminado;

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNmProducto() {
        return nmProducto;
    }

    public void setNmProducto(String nmProducto) {
        this.nmProducto = nmProducto;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public String getNmMedida() {
        return nmMedida;
    }

    public void setNmMedida(String nmMedida) {
        this.nmMedida = nmMedida;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Boolean getLgEliminado() {
        return lgEliminado;
    }

    public void setLgEliminado(Boolean lgEliminado) {
        this.lgEliminado = lgEliminado;
    }

    public GetInventario(int idInventario, int idProducto, String nmProducto, int medida, String nmMedida, int precioProducto, int stock, Boolean lgEliminado) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.nmProducto = nmProducto;
        this.medida = medida;
        this.nmMedida = nmMedida;
        this.precioProducto = precioProducto;
        this.stock = stock;
        this.lgEliminado = lgEliminado;
    }

    public GetInventario() {
    }

    
}
