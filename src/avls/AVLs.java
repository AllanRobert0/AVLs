/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avls;
import Input.Input;
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
    
}
