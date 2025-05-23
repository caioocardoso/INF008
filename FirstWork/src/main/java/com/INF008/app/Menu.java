package com.INF008.app;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuPrincipal(){
        int option;
        do{
            System.out.println("\33[H\33[2J");
            System.err.println("-------------------------------------------------------------------------------");
            System.err.println("\t\t\tSISTEMA DE GESTÃO DE EVENTOS PARA UNIVERSIDADES");
            System.err.println("-------------------------------------------------------------------------------");
            System.err.println("\\t1. ");
            System.err.println("\\t2. ");
            System.err.println("\\t3. ");
            System.err.println("\\t4. ");
            System.err.println("\\t5. ");
            System.err.println("\\t6. ");
            System.err.println("\\t0. Sair");
            System.err.println("-------------------------------------------------------------------------------");
            System.err.println("Escolha uma opção acima: ");
        
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 0:
                    System.out.println("\nSaindo do sistema...");
                    break;            
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
            }
        
        
        }while(option != 0);
    }
}
