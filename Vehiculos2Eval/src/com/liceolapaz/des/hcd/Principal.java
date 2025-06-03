package com.liceolapaz.des.hcd;

import java.util.Scanner;

public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static Vehiculo[] vehiculos = new Vehiculo[100];
    private static Moto[] motos = new Moto[50];
    private static Furgoneta[] furgonetas = new Furgoneta[20];
    private static int contador_coches = 0;
    private static int contador_motos = 0;
    private static int contador_furgonetas = 0;

    public static void main(String[] args) {
        while (true){
            menu();
            int opcion = sc.nextInt();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Tipo de vehiculo(Coche, Furgoneta, Moto): ");
                    String tipo_vehiculo = sc.next();
                    System.out.print("Tipo de motor(Gasolina, Diesel, Electrico, Hibrido): ");
                    String tipo_motor = sc.next();
                    Vehiculo.alquilarVehiculo("a","a");

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ERROR, Opcion del menú no existente");
                    break;
            }
        }
    }
    public static void menu(){
        System.out.print("ALQUILERES\n" +
                "1. Alquiler vehículo\n" +
                "2. Devolución vehículo\n" +
                "3. Listar vehículos alquilados\n" +
                "4. Mostrar número de vehículos sin alquilar\n" +
                "0. Salir\n" +
                "Escoja una opción: ");
    }
}
