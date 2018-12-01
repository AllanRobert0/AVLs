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
    
    // Algoritmo para Inserção em AVL
    // Insere um nó contendo a chave x na árvore apontada por p.
    // h verdadeiro se, e somente se, a altura da árvore com raiz p foi (alterada) aumentada com a inserção 
                                             //necessita passar a arvore para ter acesso a sua
                                             //variavel h
    public noArvore InsereAVL(int x, noArvore p){
        
        if(p == null){System.out.println("pri 1");
            p = InsereNo(p, x);
            this.setH(true);
            //System.out.println("INSERIDO: "+p.getInfo());
        }else if(x < p.getInfo()){System.out.println("pri 2");
            p.setEprox( InsereAVL(x, p.getEprox()) ); //= InsereAVL(x, p.getEprox());
        }        
        if(this.getH()){ // a sub-árvore à esquerda de p foi alterada
            
            switch(p.getBal()){
                
                case 1:
                    p.setBal(0);
                    this.setH(false);
                    break;
                case 0:
                    p.setBal(-1);                    
                    break;
                case -1:
                    RotacaoDireita(p);
                    break;                
            }
            
        }else if(x > p.getInfo()){
           p.setDprox( InsereAVL(x, p.getDprox()) );// = InsereAVL(x, p.getDprox());
        }
        if(this.getH()){ // a sub-árvore à direita de p foi alterada
            
            switch(p.getBal()){
                
                case -1:
                    p.setBal(0);
                    this.setH(false);
                    break;
                case 0:
                    p.setBal(1);                    
                    break;
                case 1:
                    RotacaoEsquerda(p);
                    break;                 
                
            }
        }        
        return p;
    }
    
    public noArvore InsereNo(noArvore p, int x){
        p = new noArvore(x);
        return(p);
    }
        
    public static void RotacaoDireita(noArvore p){ //caso 1
        
    }
    
    public static void RotacaoEsquerda(noArvore p){
        
    }
    
    public static int ContaNos(noArvore p){
        if(p == null){
            return 0;
        }else{
        System.out.println("\nNo:"+p.getInfo());
        return 1 + ContaNos(p.getEprox())+ ContaNos(p.getDprox());
        }
    }  
    
}
