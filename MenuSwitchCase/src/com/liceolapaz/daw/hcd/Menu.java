package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        printMenu();
        operacionMenu(almacenarDatos());

    }

    private static void operacionMenu(int valor) {
        switch (valor) {
            case 1:
                System.out.print("Opción 1 escogida");
                break;
            case 2:
                System.out.println("Opción 2 escogida");
                break;
            case 3:
                System.out.println("Opción 3 escogida");
                break;
            case 4:
                System.out.println("Opción 4 escogida");
                break;
            default:
                System.out.println("Opción inexistente");
               // System.exit(0); --> Se utiliza para exitear todo el programa
        }

    }

    private static int almacenarDatos() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void printMenu() {
        System.out.print("""
                MENÚ PRINCIPAL
                1. Opcion 1
                2. Opcion 2
                3. Opcion 3
                4. Opcion 4
                Escoja opcion :""");
    }
}
