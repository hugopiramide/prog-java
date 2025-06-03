package com.liceolapaz.des.hcd;

import java.util.Scanner;

public class Concierto {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean estadoBucle = true;
        while (estadoBucle){
            menu();
            int opcionMenu = sc.nextInt();
            switch (opcionMenu){
                case 0:
                    estadoBucle = false;
                    System.exit(0);
                    break;
                case 1:
                    Asistente.reservarEntrada();
                    break;
                case 2:
                    System.out.println(Asistente.mostrarEntrada());
                    break;
                case 3:
                    System.out.println(Asistente.mostrarEntradasVendidas());
                    break;
                case 4:
                    System.out.println(Asistente.mostrarEntradasDisponibles());
                    break;
                default:
                    System.out.println("OPCIÓN INTRODUCIDA NO VALIDA");
                    break;
            }
        }
    }
    public static void menu(){
        System.out.print("GESTOR CONCIERTOS\n" +
                "1. Reservar entrada\n" +
                "2. Mostrar entrada\n" +
                "3. Listar entradas vendidas\n" +
                "4. Mostrar número de entradas disponibles\n" +
                "0. Salir\n" +
                "Escoja una opción: ");
    }
}
