package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        while(true) {
            menuCalculadora();
            int dato = almacenarDatoMenu();
            switch (dato) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Ingrese el valor del primer operando : ");
                    double n1 = primerOperando();
                    System.out.print("Ingrese el valor del segundo operando : ");
                    double n2 = segundoOperando();
                    System.out.print("El resultado de la suma de ambos números es : " + (n1 + n2));
                    break;
                case 2:
                    System.out.print("Ingrese el valor del primer operando : ");
                    double j1 = primerOperando();
                    System.out.print("Ingrese el valor del segundo operando : ");
                    double j2 = segundoOperando();
                    System.out.print("El resultado de la resta de ambos números es : " + (j1 - j2));
                    break;
                case 3:
                    System.out.print("Ingrese el valor del primer operando : ");
                    double s1 = primerOperando();
                    System.out.print("Ingrese el valor del segundo operando : ");
                    double s2 = segundoOperando();
                    System.out.print("El resultado de la multiplicacion de ambos números es : " + (s1 * s2));
                    break;
                case 4:
                    System.out.print("Ingrese el valor del primer operando : ");
                    double f1 = primerOperando();
                    System.out.print("Ingrese el valor del segundo operando : ");
                    double f2 = segundoOperando();
                    System.out.print("El resultado de la suma de ambos números es : " + (f1 / f2));
                    break;
            }
        }
    }

    private static double segundoOperando() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static double primerOperando() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static int almacenarDatoMenu() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void menuCalculadora() {
        System.out.print("\nCALCULADORA\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Producto\n" +
                "4. División\n" +
                "0. Salir\n" +
                "Escoja una opción : ");
    }
}

