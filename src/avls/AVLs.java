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
        
        ArvoreAVL arvore = new ArvoreAVL(); //contem variaveis h,P;
        
        while(true){
            switch(Input.readInt("\n1. Inserir"
                    + "\n2. Remover"
                    + "\n3. Buscar"
                    + "\n4. Conta Nos"
                    + "\n5. Imprime Arvore"
                    + "\n0. Sair"
                    + "\n Escolha uma Opcao: ")){

                case 1:
                    System.out.println("\nIniciando Inserir");                    
                    arvore.setP( arvore.InsereAVL(
                                Input.readInt("\nDigite Um Numero: "), 
                                arvore.getP())
                    );                    
                    break;
                case 2:
                    System.out.println("Iniciando Remover");
                    
                    break;
                case 3:
                    System.out.println("Iniciando Buscar");
                    
                    break;
                case 4:
                    System.out.println("Iniciando Conta Nos");
                    System.out.println("\nNos Encontrados: "+arvore.ContaNos(arvore.getP()));
                    break;
                case 5:
                    System.out.println("Iniciando Improme Arvore\n");
                    ArvoreAVL.ImprimeArvore(arvore.getP(), 0);
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
}