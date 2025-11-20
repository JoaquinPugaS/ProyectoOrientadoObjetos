/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Puga
 */
public class TpMedida {
    
    private int cdTpUnidadMedida;
    private String nmUnidadMedida;
    private boolean lgEliminado;

    public TpMedida() {
    }

    public TpMedida(int cdTpUnidadMedida, String nmUnidadMedida, boolean lgEliminado) {
        this.cdTpUnidadMedida = cdTpUnidadMedida;
        this.nmUnidadMedida = nmUnidadMedida;
        this.lgEliminado = lgEliminado;
    }

    public int getCdTpUnidadMedida() {
        return cdTpUnidadMedida;
    }

    public void setCdTpUnidadMedida(int cdTpUnidadMedida) {
        this.cdTpUnidadMedida = cdTpUnidadMedida;
    }

    public String getNmUnidadMedida() {
        return nmUnidadMedida;
    }

    public void setNmUnidadMedida(String nmUnidadMedida) {
        this.nmUnidadMedida = nmUnidadMedida;
    }

    public boolean isLgEliminado() {
        return lgEliminado;
    }

    public void setLgEliminado(boolean lgEliminado) {
        this.lgEliminado = lgEliminado;
    }
    
     
    
}
