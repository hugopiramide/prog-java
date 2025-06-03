package com.liceolapaz.net.hcd;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        do{
            escribirMenu();
            int opcion = leerOpcion();
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    escribirSubmenu();
                    int opcionSubmenu = leerOpcion();
                    switch (opcionSubmenu){
                        case 0:
                            System.exit(0);
                        case 1:
                            System.out.print("Escriba el valor del primer operando: ");
                            int valor1 = leerOpcion();
                            System.out.print("Escriba el valor del primer operando: ");
                            int valor2 = leerOpcion();
                            Entero operando1 = new Entero(valor1);
                            Entero operando2 = new Entero(valor2);
                            Numero resultado = null;
                            switch (opcion){
                                case 1:
                                    resultado = operando1.suma(operando2);
                                    break;
                                case 2:
                                    resultado = operando1.resta(operando2);
                                    break;
                                case 3:
                                    resultado = operando1.producto(operando2);
                                    break;
                                case 4:
                                    resultado = operando1.division(operando2);
                                    break;
                                default:
                                    System.out.println("Opción no valida");
                            }
                            if (resultado != null){
                                System.out.println("El resultado de la operación es : " + resultado.mostrar());
                            }
                            break;
                        case 2:
                            System.out.print("Escriba el numerador del primer operando: ");
                            valor1 = leerOpcion();
                            System.out.print("Escriba el denominador del primer operando: ");
                            valor2 = leerOpcion();
                            System.out.print("Escriba el numerador del segundo operando: ");
                            int valor3 = leerOpcion();
                            System.out.print("Escriba el denominador del segundo operando: ");
                            int valor4 = leerOpcion();
                            Racional operador1 = new Racional(valor1, valor2);
                            Racional operador2 = new Racional(valor3, valor4);
                            resultado = null;
                            switch (opcion){
                                case 1:
                                    resultado = operador1.suma(operador2);
                                    break;
                                case 2:
                                    resultado = operador1.resta(operador2);
                                    break;
                                case 3:
                                    resultado = operador1.producto(operador2);
                                    break;
                                case 4:
                                    resultado = operador1.division(operador2);
                                    break;
                            }
                            if (resultado != null){
                                System.out.println(resultado.mostrar());
                            }
                            break;
                        case 3:
                            System.out.print("Escriba el numerador del primer operando: ");
                            valor1 = leerOpcion();
                            System.out.print("Escriba el denominador del primer operando: ");
                            valor2 = leerOpcion();
                            System.out.print("Escriba el numerador del segundo operando: ");
                            valor3 = leerOpcion();
                            System.out.print("Escriba el denominador del segundo operando: ");
                            valor4 = leerOpcion();
                            Complejos op1 = new Complejos(valor1,valor2);
                            Complejos op2 = new Complejos(valor3,valor4);
                            resultado = null;
                            switch (opcion){
                                case 1:
                                    resultado = op1.suma(op2);
                                    break;
                                case 2:
                                    resultado = op1.resta(op2);
                                    break;
                                case 3:
                                    resultado = op1.producto(op2);
                                    break;
                                case 4:
                                    resultado = op1.division(op2);
                                    break;
                            }
                            if (resultado != null){
                                System.out.println(resultado.mostrar());
                            }
                            break;
                        default:
                            System.out.println("Opción no valida");
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while(true);
    }

    private static void escribirSubmenu() {
        System.out.println("" +
                "Tipo de números\n" +
                "1. Números enteros\n" +
                "2. Números racionales\n" +
                "3. Números complejos\n" +
                "0. Cancelar\n" +
                "Escoja una opción: ");
    }

    private static int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void escribirMenu() {
        System.out.println("" +
                "CALCULADORA\n" +
                "1. SUMA\n" +
                "2. RESTA\n" +
                "3. PRODUCTO\n" +
                "4. DIVISIÓN\n" +
                "0. SALIR");
    }
}
