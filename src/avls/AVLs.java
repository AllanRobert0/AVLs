/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avls;
import Input.Input;
import Modelo.*;
/**
 *
 * @author USER
 */
public class AVLs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Inicio");
        
        while(true){
            switch(Input.readInt("1. Inserir"
                    + "\n2. Remover"
                    + "\n3. Buscar"
                    + "\n0. Sair"
                    + "\n Escolha uma Opcao: ")){

                case 1:
                    System.out.println("\nIniciando Inserir");
                    
                    break;
                case 2:
                    System.out.println("Iniciando Remover");
                    
                    break;
                case 3:
                    System.out.println("Iniciando Buscar");
                    
                    break;
                case 0:
                    System.out.println("\n SAINDO.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n  !Opcao Invalida!\n");
            }
        }
    }
    
    // Algoritmo para Inserção em AVL
    // Insere um nó contendo a chave x na árvore apontada por p.
    // h verdadeiro se, e somente se, a altura da árvore com raiz p foi (alterada) aumentada com a inserção 
                                             //necessita passar a arvore para ter acesso a sua
                                             //variavel h
    public void InsereAVL(int x, noArvore p, ArvoreAVL arvore/*boolean h*/){
        
        if(p == null){            
            InsereNo(p, x);
            //h = true;
            arvore.setH(true);
        }else if(x < p.getInfo()){
            InsereAVL(x, p.getEprox(), arvore);
        }
        
        if(arvore.getH()){ // a sub-árvore à esquerda de p foi alterada
            
            switch(p.getBal()){
                
                case 1:
                    p.setBal(0);
                    arvore.setH(false);
                    break;
                case 0:
                    p.setBal(-1);                    
                    break;
                case -1:
                    RotacaoDireita(p,arvore);
                    break;                
            }
            
        }else if(x > p.getInfo()){
            InsereAVL(x, p.getDprox(), arvore);
        }
        if(arvore.getH()){ // a sub-árvore à direita de p foi alterada
            
            switch(p.getBal()){
                
                case -1:
                    p.setBal(0);
                    arvore.setH(false);
                    break;
                case 0:
                    p.setBal(1);                    
                    break;
                case 1:
                    RotacaoEsquerda(p,arvore);
                    break;                 
                
            }
        }
        
        
    }
    
    public void InsereNo(noArvore p, int x){
        
    }
    
    public void RotacaoDireita(noArvore p, ArvoreAVL arvore){ //caso 1
    
    }
    
    public void RotacaoEsquerda(noArvore p, ArvoreAVL arvore){
        
    }
}
