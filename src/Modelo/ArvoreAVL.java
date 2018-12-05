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
        
        if(p == null){
            p = InsereNo(p, x);
            this.setH(true);
        }else if(x < p.getInfo()){
            p.setEprox( InsereAVL(x, p.getEprox()) ); //= InsereAVL(x, p.getEprox());
        
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
                        p = RotacaoDireita(p);
                        this.setH(false);
                        break;
                }
            }
        }else if(x > p.getInfo()){
           p.setDprox( InsereAVL(x, p.getDprox()) );
        
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
                        p = RotacaoEsquerda(p);
                        this.setH(false);
                        break;
                }
            }
        }
        return p;
    }

    public noArvore InsereNo(noArvore p, int x){
        p = new noArvore(x);
        return(p);
    }

    public static noArvore RotacaoDireita(noArvore p){ //caso 1
        
        noArvore u,v;
        
        u = p.getEprox();
        if(u.getBal() == -1){// caso 1.1 - rotação a direita
            p.setEprox(u.getDprox());
            u.setDprox(p);
            p.setBal(0);
            p = u;
        }else{// caso 1.2 - Bal(u) = 1, rotação dupla-direita
            v = u.getDprox();
            u.setDprox(v.getEprox());
            v.setEprox(u);
            p.setEprox(v.getDprox());
            v.setDprox(p);
            switch (v.getBal()) {
                case 0:
                    u.setBal(0);
                    p.setBal(0);
                    break;
                case -1:
                    u.setBal(0);
                    p.setBal(0);
                    break;
                default:
                    u.setBal(-1);
                    p.setBal(0);
                    break;
            }
            p = v;
        }
        p.setBal(0);
        // h <- false; OPERACAO REALIZADA ONDE FUNCAO FOI CHAMADA
        return p;
    }
    
    public static noArvore RotacaoEsquerda(noArvore p){
        
        noArvore z,y;
        z = p.getDprox();
        if(z.getBal() == 1){// caso 1.1 - rotação a direita
            p.setDprox(z.getEprox());
            z.setEprox(p);
            p.setBal(0);
            p = z;
        }else{// caso 1.2 - Bal(u) = 1, rotação dupla-direita
            y = z.getEprox();
            z.setEprox(y.getDprox());
            y.setDprox(z);
            p.setDprox(y.getEprox());
            y.setEprox(p);
            switch (y.getBal()) {
                case 0:
                    z.setBal(0);
                    p.setBal(0);
                    break;
                case -1:
                    z.setBal(0);
                    p.setBal(0);
                    break;
                default:
                    z.setBal(-1);
                    p.setBal(0);
                    break;
            }
            p = y;
        }
        p.setBal(0);
        // h <- false; OPERACAO REALIZADA ONDE FUNCAO FOI CHAMADA
        return p;
    }
    
    public static int ContaNos(noArvore p){
        if(p == null){
            return 0;
        }else{
        //System.out.println("\nNo:"+p.getInfo());
        return 1 + ContaNos(p.getEprox())+ ContaNos(p.getDprox());
        }
    }
    
    public static void ImprimeArvore(noArvore p,int espaco){
        if(p != null){
            ImprimeArvore(p.getDprox(), espaco+1);
            for(int i = 1;i <= espaco;i++){
                System.out.print("-");
            }
            System.out.print(p.getInfo());
            ImprimeArvore(p.getEprox(), espaco+1);
        }else{
            System.out.println("");
        }
    }
    
    public static int Busca(int x, noArvore p){        
        if(p == null){
            return 0;
        }else if(p.getInfo() == x){
            return 1;
        }else if(x < p.getInfo()){
            return Busca(x, p.getEprox());
        }else{
            return Busca(x, p.getDprox());
        }        
    }
    
/*    public static int Remove(int x, noArvore p, noArvore f){//esta removendo sem precisar retornar o no alterado
        if(f == null){
            return 0;
        }//else if(p.getInfo() == f.getInfo()){
        //p = null;
        //return 1;
        //}
        else if(f.getInfo() == x){//no a ser removido encontrado
            
            if(f.getDprox() == null && f.getEprox() == null){ //e uma folha
                
                if(p.getDprox() == f){//verifica em qual lado esta o filho
                    p.setDprox(null);
                }else{
                    p.setEprox(null);
                }
                
            }else if(f.getEprox() == null){//esquerda e nulo
                
            }else{//direita e nulo
            
            }            
            return 1;
        }else if(x < p.getInfo()){
            return Remove(x, f,f.getEprox());
        }else{
            return Remove(x, f,f.getDprox());
        }
    } */
    
    
    public static noArvore Remove(int x, noArvore p){//esta removendo sem precisar retornar o no alterado
        if(p == null)
            return p;        
        else if(p.getDprox() == null && p.getEprox() == null){//arvore possui apenas um elemento
            if(p.getInfo() == x){                
                System.out.println("    !Removido - Arvore Vazia!");
                return null;
            }
        }else if(x < p.getInfo()){
            if(p.getEprox().getInfo() == x){//no a ser removido encontrado, e e o proximo a esquerda
                
                if(p.getEprox().getDprox() == null && p.getEprox().getEprox() == null){//e uma folha
                    p.setEprox(null);
                    System.out.println("    !Removido kk!");
                }
            return p;
            }else
            //return Remove(x, p);
            p.setEprox(Remove(x, p.getEprox()));
        }else{
            if(p.getDprox().getInfo() == x){//no a ser removido encontrado, e e o proximo a direita
                
                if(p.getDprox().getEprox() == null && p.getDprox().getDprox() == null){//e uma folha
                    p.setDprox(null);
                    System.out.println("    !Removido kk!");
                }
            return p;
            }else
            //return Remove(x, p);
            p.setDprox(Remove(x, p.getDprox()));
        }
        return p;
    }    
    
    
}
