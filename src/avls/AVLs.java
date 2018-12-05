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
                    + "\n6. Limpa Arvore"
                    + "\n0. Sair"
                    + "\n Escolha uma Opcao: ")){

                case 1:
                    System.out.println("\nIniciando Inserir");                    
                    arvore.setP( arvore.InsereAVL(
                                Input.readInt(" Digite Um Numero: "), 
                                arvore.getP())
                    );
                    System.out.println("\nNumero Inserido!");
                    break;
                case 2:
                    System.out.println("\nIniciando Remocao\n");
                  /*  if(arvore.getP() == null)
                        System.out.println("    !Arvore Vazia!");
                    else if(arvore.Remove(Input.readInt(" Digite Numero Remover: "), arvore.getP(), arvore.getP()) == 1){
                        System.out.println("\n !Removido!");
                    }else{
                        System.out.println("\n !NAO Removido!");
                    }   */  
                    
                    if(arvore.getP() == null)
                        System.out.println("    !Arvore Vazia!");
                    else
                        arvore.setP(arvore.Remove(Input.readInt(" Digite Numero Remover: "), arvore.getP()));                       
                    break;
                case 3:
                    System.out.println("\nIniciando Busca\n");
                    if(arvore.getP() == null)
                        System.out.println("    !Arvore Vazia!");
                    else if(
                        arvore.Busca(Input.readInt(" Digite Numero Busca: "), arvore.getP()) == 1){
                        System.out.println("\n !Encontrado!");
                    }else{
                        System.out.println("\n !NAO Encontrado!");
                    }
                    
                    break;
                case 4:
                    System.out.println("\nIniciando Conta Nos");
                    if(arvore.getP() == null)
                        System.out.println("    !Arvore Vazia!");
                    else  
                    System.out.println("Nos Na Arvore: "+arvore.ContaNos(arvore.getP()));
                    break;
                case 5:
                    System.out.println("\nIniciando Imprime Arvore\n");
                    if(arvore.getP() == null)
                        System.out.println("    !Arvore Vazia!");
                    else    
                    ArvoreAVL.ImprimeArvore(arvore.getP(), 0);
                    break;                
                case 6:
                    System.out.println("\nIniciando Limpa Arvore");
                    arvore.setP(null);
                    System.out.println(" !Arvore Limpa!");
                    break;    
                case 0:
                    System.out.println("\n Finalizando. @Allan Roberto,TADS UCDB 2018.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n  !Opcao Invalida!\n");
            }
        }
    }
}