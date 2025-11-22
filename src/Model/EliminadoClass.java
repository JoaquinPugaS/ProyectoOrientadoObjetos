/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Puga
 */
public class EliminadoClass {
    private String nmEliminado;
    private boolean valor;

    public EliminadoClass() {
    }

    public EliminadoClass(String nmEliminado, boolean valor) {
        this.nmEliminado = nmEliminado;
        this.valor = valor;
    }

    public String getNmEliminado() {
        return nmEliminado;
    }

    public void setNmEliminado(String nmEliminado) {
        this.nmEliminado = nmEliminado;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  nmEliminado;
    }
    
    
    
}
