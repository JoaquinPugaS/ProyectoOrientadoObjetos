/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Puga
 */
public class TpMetodoPago {
    private int cdTpMetodoPago;
    private String nmMetodoPago;

    public TpMetodoPago() {
    }

    public TpMetodoPago(int cdTpMetodoPago, String nmMetodoPago) {
        this.cdTpMetodoPago = cdTpMetodoPago;
        this.nmMetodoPago = nmMetodoPago;
    }

    public int getCdTpMetodoPago() {
        return cdTpMetodoPago;
    }

    public void setCdTpMetodoPago(int cdTpMetodoPago) {
        this.cdTpMetodoPago = cdTpMetodoPago;
    }

    public String getNmMetodoPago() {
        return nmMetodoPago;
    }

    public void setNmMetodoPago(String nmMetodoPago) {
        this.nmMetodoPago = nmMetodoPago;
    }
    
    
}
