/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Puga
 */
public class Inventario {
    private int idInventario;
    private int idProducto;
    private int stockCritico;
    private int stock;

    public Inventario() {
    }

    public Inventario(int idInventario, int idProducto, int stockCritico, int stock) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.stockCritico = stockCritico;
        this.stock = stock;
    }

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

    public int getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(int stockCritico) {
        this.stockCritico = stockCritico;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Inventario{" + "idInventario=" + idInventario + ", idProducto=" + idProducto + ", stockCritico=" + stockCritico + ", stock=" + stock + '}';
    }
    
    
    
}
