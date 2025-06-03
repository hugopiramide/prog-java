package com.liceolapaz.des.hcd;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            opcionesNumero();
            int opcionNumero = almacenarNumero();
            if (opcionNumero == 1) {
                System.out.print("Tienes un total de 3 intentos\n");
                int numAleatorio = numeroAleatorio1();
                int count = 0;
                for (int i = 1; i < 4; i++) {
                    System.out.print("Introduzca un numero : ");
                    int numero = almacenarNumero1();
                    if (numAleatorio > numero) {
                        System.out.println("¡¡El número aleatorio es mayor!!");
                    } else if (numAleatorio < numero) {
                        System.out.println("¡¡El número aleatorio es menor!!");
                    } else {
                        System.out.println("¡¡ACERTASTEE!!");
                        System.out.println("Has acertado el número en " + i + " intento(s)");
                        count++;
                        break;
                    }
                    ;
                }
                if (count == 0) {
                    System.out.println("¡¡No ha hacertado en el número máximo de intentos!!");
                }
                System.out.println("El número aleatorio es --> " + numAleatorio);

            } else if (opcionNumero == 2) {
                System.out.print("Tienes un total de 5 intentos\n");
                int numAleatorio = numeroAleatorio2();
                int count = 0;
                for (int i = 1; i < 6; i++) {
                    System.out.print("Introduzca un numero : ");
                    int numero = almacenarNumero1();
                    if (numero > numAleatorio) {
                        System.out.println("El número aleatorio es menor!!");
                    } else if (numero < numAleatorio) {
                        System.out.println("¡¡El número aleatorio es mayor!!");
                    } else {
                        System.out.println("¡¡ACERTASTEE!!");
                        System.out.println("Has acertado el número en " + i + " intentos");
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    System.out.println("¡¡No ha hacertado en el número máximo de intentos!!");
                }
                System.out.println("El número aleatorio es --> " + numAleatorio);

            } else if (opcionNumero == 0) {
                System.exit(0);
            } else {
                System.out.println("Opcion no valida");
            }
        }
    }
    private static int numeroAleatorio2(){
        SecureRandom random = new SecureRandom();
        return random.nextInt(50) + 1;
    }
    private static int almacenarNumero1() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    private static int numeroAleatorio1() {
        SecureRandom random = new SecureRandom();
        int rand_1 = random.nextInt(10) + 1;
        return rand_1;
    }

    private static int almacenarNumero() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void opcionesNumero() {
        System.out.print("\nADIVINA EL NÚMERO\n" +
                "1.Del 1 al 10\n" +
                "2.Del 1 al 50\n" +
                "0.Salir\n" +
                "Escoja una opción : ");
    }
}