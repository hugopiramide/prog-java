package com.liceolapaz.daw.hcd;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        while(true) {
            int contCroupier = 0;
            int contUsuario = 1;
            int numCroupier = 0;
            int numUsuario;
            int min = 1;
            int max = 11;
            boolean i = true;
            menu();
            int menu = almacenarDato();
            switch (menu) {
                case 0:
                    System.out.println("Saliendo...");
                    System.exit(0);
                case 1:
                    while (numCroupier < 15) {
                        numCroupier = numCroupier + numAleatorio(min, max);
                        contCroupier++;
                    }
                    if (numCroupier > 21) {
                        System.out.println("¡¡¡GANASTE, EL CROUPIER SACÓ " + numCroupier + "!!!");
                        break;
                    }
                    System.out.println("Croupier --> Numero generado: " + numCroupier);
                    System.out.println("Croupier --> En " + contCroupier + " tiradas");
                    numUsuario = numAleatorio(min, max);
                    System.out.println("Usuario --> Numero generado es: " + numUsuario);
                    //Seguir Jugando?? si,no.
                    while (i) {
                        contUsuario++;
                        menuOpcional();
                        menu = almacenarDato();
                        switch (menu) {
                            case 1:
                                numUsuario = numUsuario + numAleatorio(min, max);
                                i = funcion1(numUsuario);
                                break;
                            case 2:
                                i = funcion2(numUsuario, numCroupier, contUsuario, contCroupier);
                                break;
                            default:
                                System.out.println("ERROR, SOLO PUEDE ESCOGER ENTRE 1 y 2");
                        }
                    }
                    System.out.println("CROUPIER --> " + numCroupier);
                    System.out.print("USUARIO --> " + numUsuario);
                    break;
                case 2:
                    while (numCroupier < 15) {
                        numCroupier = numCroupier + numAleatorio(min, max);
                        contCroupier++;
                    }
                    if (numCroupier > 21) {
                        System.out.println("¡¡¡GANASTE, EL CROUPIER SACÓ " + numCroupier + "!!!");
                        break;
                    }
                    numUsuario = numAleatorio(min, max);
                    System.out.println("Usuario --> Numero generado es: " + numUsuario);
                    while (i) {
                        contUsuario++;
                        menuOpcional();
                        menu = almacenarDato();
                        switch (menu) {
                            case 1:
                                numUsuario = numUsuario + numAleatorio(min, max);
                                i = funcion1(numUsuario);
                                break;
                            case 2:
                                i = funcion2(numUsuario, numCroupier, contUsuario, contCroupier);
                                break;
                            default:
                                System.out.println("ERROR, SOLO PUEDE ESCOGER ENTRE 1 y 2");
                        }
                    }
                    System.out.println("CROUPIER --> " + numCroupier);
                    System.out.print("USUARIO --> " + numUsuario);
                    break;
                default:
                    System.out.println("ERROR, MENÚ INEXISTENTE");
            }
        }
    }

    private static int almacenarDato() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static boolean funcion1(int numUsuario){
        System.out.println(numUsuario);
        if (numUsuario == 21) {
            System.out.println("¡¡¡¡BLACKJACK!!!! Has ganado");
            return false;
        } else if (numUsuario > 21) {
            System.out.println("¡¡¡TE PASASTE, GANA EL CROUPIER!!!");
            return false;
        }
        return true;
    }

    private static boolean funcion2(int numUsuario, int numCroupier, int contUsuario, int contCroupier){
        if (numUsuario == numCroupier && contUsuario < contCroupier) {
            System.out.println("EMPATE CON EL CROUPIER\n¡¡¡HAS GANADO POR NUMERO DE TIRADAS!!!");
        } else if (numUsuario == numCroupier && contUsuario > contCroupier) {
            System.out.println("EMPATE CON EL CROUPIER\n¡¡¡EL CROUPIER HA GANADO POR NUMERO DE TIRADAS!!!");
        } else if (numUsuario > numCroupier) {
            System.out.println("!!!Has ganado!!!");
        } else {
            System.out.println("¡¡¡Ganó el Croupier!!!");
        }
        return false;
    }

    private static int numAleatorio(int min, int max){
        new Random();
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private static void menuOpcional(){
        System.out.print("¿Seguir Jugando?\n" +
                "1.Si\n" +
                "2.No\n" +
                "Escoja un opción: ");
    }

    private static void menu() {
        System.out.print("\nBLACKJACK\n" +
                "1.Modo Facil\n" +
                "2.Modo Normal\n" +
                "0.Salir\n" +
                "Escoja una Opción: ");
    }
}
