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
public class Producto {
    private int idProducto;
    private int cdTpMarca;
    private int cdTpUnidadMedida;
    private int cdTpClase;
    private int medida;
    private String nmProducto;
    private LocalDateTime fcIngreso;
    private LocalDateTime fcExpiracion;

    public Producto() {
    }

    public Producto(int idProducto, int cdTpMarca, int cdTpUnidadMedida, int cdTpClase, int medida, String nmProducto, LocalDateTime fcIngreso, LocalDateTime fcExpiracion) {
        this.idProducto = idProducto;
        this.cdTpMarca = cdTpMarca;
        this.cdTpUnidadMedida = cdTpUnidadMedida;
        this.cdTpClase = cdTpClase;
        this.medida = medida;
        this.nmProducto = nmProducto;
        this.fcIngreso = fcIngreso;
        this.fcExpiracion = fcExpiracion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCdTpMarca() {
        return cdTpMarca;
    }

    public void setCdTpMarca(int cdTpMarca) {
        this.cdTpMarca = cdTpMarca;
    }

    public int getCdTpUnidadMedida() {
        return cdTpUnidadMedida;
    }

    public void setCdTpUnidadMedida(int cdTpUnidadMedida) {
        this.cdTpUnidadMedida = cdTpUnidadMedida;
    }

    public int getCdTpClase() {
        return cdTpClase;
    }

    public void setCdTpClase(int cdTpClase) {
        this.cdTpClase = cdTpClase;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public String getNmProducto() {
        return nmProducto;
    }

    public void setNmProducto(String nmProducto) {
        this.nmProducto = nmProducto;
    }

    public LocalDateTime getFcIngreso() {
        return fcIngreso;
    }

    public void setFcIngreso(LocalDateTime fcIngreso) {
        this.fcIngreso = fcIngreso;
    }

    public LocalDateTime getFcExpiracion() {
        return fcExpiracion;
    }

    public void setFcExpiracion(LocalDateTime fcExpiracion) {
        this.fcExpiracion = fcExpiracion;
    }
    
    
}
