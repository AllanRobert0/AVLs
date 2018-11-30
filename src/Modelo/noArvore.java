/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USER
 */
public class noArvore {
    
    private int Info,Bal;
    private noArvore Eprox,Dprox;

    public noArvore(int Info) {
        this.Info = Info;
        this.Bal = 0;
        this.Eprox = null;
        this.Dprox = null;
    }

    public int getInfo() {
        return Info;
    }

    public void setInfo(int Info) {
        this.Info = Info;
    }

    public int getBal() {
        return Bal;
    }

    public void setBal(int Bal) {
        this.Bal = Bal;
    }

    public noArvore getEprox() {
        return Eprox;
    }

    public void setEprox(noArvore Eprox) {
        this.Eprox = Eprox;
    }

    public noArvore getDprox() {
        return Dprox;
    }

    public void setDprox(noArvore Dprox) {
        this.Dprox = Dprox;
    }
    
    
}
