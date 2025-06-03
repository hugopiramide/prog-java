package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int[] num = new int[11];
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

        int maximo = -1;
        int i;
        for (i = 0; maximo < num[i]; i++){
            num[i] = maximo;
        }
        System.out.println(maximo);
    }

private static void solicitarNumeros(){
    System.out.println("Introduce 10 numeros ENTEROS por pantalla \n" +
            "-------------------------------------------");
    }
private static int leerNumero(){
    return new Scanner(System.in).nextInt();
    }
}

