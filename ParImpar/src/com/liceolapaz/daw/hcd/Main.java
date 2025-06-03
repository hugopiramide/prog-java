package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Pedir número al usuario
        pedirNumero();
        // Leer el número y guardarlo
        int numero = leerNumero();
        // Comprobar si es par o impar y almacenarlo
        String resultado = comprobarNumero(numero);
        // Mostrar el mensaje
        System.out.println(resultado);

    }

    private static String comprobarNumero(int numero) {
        String texto = "";
        if(numero == 0 ){
            texto = "Este número no es válido";
        }else{
            texto = (numero % 2 == 0)?"Este número es Par": "Este número es Impar";
        }
        return texto;
    }

    private static int leerNumero() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void pedirNumero() {
        System.out.print("Escriba un número entero : ");
    }

}
