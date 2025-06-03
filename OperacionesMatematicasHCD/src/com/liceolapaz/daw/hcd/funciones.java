package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class funciones {
    public static void menu(){
        System.out.print("POTENCIAS Y RAICES CUADRADAS\n" +
                "1. Potencia\n" +
                "2. Raíz cuadrada\n" +
                "3. Salir\n" +
                "Escoja una opción : ");
    }
    public static int almacenarMenu() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static double base(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static double exponente(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static double operando(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
