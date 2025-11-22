/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Puga
 */
public class TpClase {
    private int cdTpClase;
    private String nmClase;
    private boolean lgEliminado;

    public TpClase() {
    }

    public TpClase(int cdTpClase, String nmClase, boolean lgEliminado) {
        this.cdTpClase = cdTpClase;
        this.nmClase = nmClase;
        this.lgEliminado = lgEliminado;
    }

    public int getCdTpClase() {
        return cdTpClase;
    }

    public void setCdTpClase(int cdTpClase) {
        this.cdTpClase = cdTpClase;
    }

    public String getNmClase() {
        return nmClase;
    }

    public void setNmClase(String nmClase) {
        this.nmClase = nmClase;
    }

    public boolean isLgEliminado() {
        return lgEliminado;
    }

    public void setLgEliminado(boolean lgEliminado) {
        this.lgEliminado = lgEliminado;
    }

    @Override
    public String toString() {
        return nmClase;
    }
    
    
}
