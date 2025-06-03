package com.liceolapaz.daw.hcd;

import java.security.SecureRandom;
import java.util.Scanner;

public class Bucle {
    public static void main(String[] args) {
        NumeroBuscar();
        MaximoIntentos();
        almacenarMaximoIntentos();

        int numeroIntentos = 0;
        while (numeroIntentos < almacenarMaximoIntentos()) {
            int numeroAlatorio = generarNumeroAleatorio(1,10);
            numeroIntentos++;
            System.out.println("El número generado es " + numeroAlatorio);
        }
    }

    private static int almacenarMaximoIntentos() {
        Scanner sc1 = new Scanner(System.in);
        return sc1.nextInt();
    }

    private static int generarNumeroAleatorio(int min, int max) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(max - min + 1) + min;
    }

    private static void MaximoIntentos() {
        System.out.print("Ingresa un máximo de intentos : ");
    }

    private static void operacionBucle() {

    }

    private static int NumeroBuscar() {
        System.out.print("Introduzca un número entre 1 y 10 : ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
