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
public class ArvoreAVL {
    
    private boolean h;
    private noArvore P;

    public ArvoreAVL() {
        this.h = false;
        this.P = null;
    }
    
    
    //funções da arvore

    public boolean getH() {
        return h;
    }

    public void setH(boolean h) {
        this.h = h;
    }

    public noArvore getP() {
        return P;
    }

    public void setP(noArvore P) {
        this.P = P;
    }
    
}
