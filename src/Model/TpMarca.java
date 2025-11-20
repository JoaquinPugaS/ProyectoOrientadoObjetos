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
    private String nmMarca;
    private boolean lgEliminado;

    public TpMarca() {
    }

    public TpMarca(int cdTpMarca, String nmMarca, boolean lgEliminado) {
        this.cdTpMarca = cdTpMarca;
        this.nmMarca = nmMarca;
        this.lgEliminado = lgEliminado;
    }

    public int getCdTpMarca() {
        return cdTpMarca;
    }

    public void setCdTpMarca(int cdTpMarca) {
        this.cdTpMarca = cdTpMarca;
    }

    public String getNmMarca() {
        return nmMarca;
    }

    public void setNmMarca(String nmMarca) {
        this.nmMarca = nmMarca;
    }

    public boolean isLgEliminado() {
        return lgEliminado;
    }

    public void setLgEliminado(boolean lgEliminado) {
        this.lgEliminado = lgEliminado;
    }
    
    
}
