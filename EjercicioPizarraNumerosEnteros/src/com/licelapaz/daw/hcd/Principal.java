package com.licelapaz.daw.hcd;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int[] num = new int[10];
        int[] num_ord = new int[10];
        int maximo = -1;
        int i;

        pedirNumeroEntero();

        //Bucle PIDIENDO y ALMACENANDO valores introducidos por el usuario

        for (i = 1; i < (num.length + 1); i++){
            System.out.print(i+" Introduzca un número entero : ");
            int numeroEntero = almacenarNumeroEntero();

            //En caso de que NO SEA un valor POSITIVO
            while (numeroEntero < 0 ){
                System.out.print( i + " ERROR, INTRODUZCA UN NÚMERO ENTERO : ");
                numeroEntero = almacenarNumeroEntero();
            }
            num[i - 1] = numeroEntero;
        }

        for ( i = 0; maximo < num[i]; i++){
            num[i] = maximo;
        }
        System.out.println(maximo);
    }

    private static void pedirNumeroEntero() {
        System.out.println("Intoroduce 10 números enteros POSITIVOS");
    }

    private static int almacenarNumeroEntero(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
