package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Pedir el nombre al usuario
        pedirNombre();
        // Leer de teclado y almacenarlo
        String nombreUsuario = leerNombre();
        // Saludar al usuario
        saludarUsuario(nombreUsuario);
    }

    private static void saludarUsuario(String nombreUsuario) {
        System.out.println("¡ Hola, " + nombreUsuario + " ! ");
    }

    private static String leerNombre() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static void pedirNombre(){
        System.out.print("Escriba su Nombre : ");
    }
}
