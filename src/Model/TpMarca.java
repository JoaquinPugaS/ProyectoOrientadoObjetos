/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Puga
 */
public class TpMarca {
    private int cdTpMarca;
    private String nmMmarca;
    private boolean lgEliminado;

    public TpMarca() {
    }

    public TpMarca(int cdTpMarca, String nmMmarca, boolean lgEliminado) {
        this.cdTpMarca = cdTpMarca;
        this.nmMmarca = nmMmarca;
        this.lgEliminado = lgEliminado;
    }

    public int getCdTpMarca() {
        return cdTpMarca;
    }

    public void setCdTpMarca(int cdTpMarca) {
        this.cdTpMarca = cdTpMarca;
    }

    public String getNmMmarca() {
        return nmMmarca;
    }

    public void setNmMmarca(String nmMmarca) {
        this.nmMmarca = nmMmarca;
    }

    public boolean isLgEliminado() {
        return lgEliminado;
    }

    public void setLgEliminado(boolean lgEliminado) {
        this.lgEliminado = lgEliminado;
    }

    @Override
    public String toString() {
        return  nmMmarca;
    }
    
}
