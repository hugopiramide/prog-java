package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Edad {
    public static void main(String[] args) {
       pedirAnhoNacimiento();
       System.out.print(operacionEdad(almacenarAnhoNacimiento()));

    }

    private static String operacionEdad(int varibale1) {
        String edad = "";
        if(varibale1 >= 18){
            edad = "Usted tiene la mayoría de edad";
        } else { edad = "Usted no tiene la mayoría de edad";}
        return edad;
    }

    private static int almacenarAnhoNacimiento() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void pedirAnhoNacimiento() {
        System.out.print("Ingrese la año de nacimiento : ");
    }

}
