package com.INF008.app;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu(){
        int option;
        do{
            System.out.println("\33[H\33[2J");
            System.err.println("-------------------------------------------------------------------------------");
            System.err.println("\t\t\tACADEMIC EVENT MANAGEMENT SYSTEM");
            System.err.println("-------------------------------------------------------------------------------");
            System.err.println("\t1. Register Event.");
            System.err.println("\t2. Register participant.");
            System.err.println("\t3. Register participant for the event.");
            System.err.println("\t4. ");
            System.err.println("\t5. ");
            System.err.println("\t6. ");
            System.err.println("\t0. Leave");
            System.err.println("-------------------------------------------------------------------------------");
            System.err.print("Choose an option: ");
        
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerEvent();
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
                    System.out.println("\nLeaving the system...");
                    break;            
                default:
                    System.out.println("\nInvalid option, please try again.");
            }
        }while(option != 0);
    }

    public static void registerEvent(){
        System.out.println("\33[H\33[2J");
        System.err.println("-------------------------------------------------------------------------------");
        System.err.println("\t\t\tREGISTER EVENT");
        System.err.println("-------------------------------------------------------------------------------");
        System.err.println("\t1. Lecture.");
        System.err.println("\t2. Workshop.");
        System.err.println("\t3. Short course.");
        System.err.println("\t4. Academic fair.");
        System.err.println("\t0. Leave");
        System.err.println("-------------------------------------------------------------------------------");
        System.err.print("Escolha uma opção acima: ");

        int type;
        type = scanner.nextInt();
        scanner.nextLine();


        if(type == 0) return;

    }
}
