package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int[] num = new int[11];
        int i;
        // Scanner sc = new Scanner(System.in);
        solicitarNumeros();
        num[10] = 0;
        while(true){
            num[num[10]] = leerNumero();
            if(num[num[10]] > 0){
                num[10]++;
            }
            else {
                System.out.println("Intoroduce porfavor un número entero");
                continue;
            }
            if (num[num[10]] == 10){
                break;
            }
        }
        //Algoridmo Burbuja
        for (i = 0; i < num.length-1; i++) {
            for (int j = 0; j < num.length-1; j++) {
                if(num[i] > num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        for (i = 0; i < num.length -1; i++) {
            System.out.println(num[i]);
        }
    }

    private static void solicitarNumeros(){
        System.out.println("Introduce 10 numeros ENTEROS por pantalla \n" +
                "-------------------------------------------");
    }
    private static int leerNumero(){
        return new Scanner(System.in).nextInt();
    }
}

