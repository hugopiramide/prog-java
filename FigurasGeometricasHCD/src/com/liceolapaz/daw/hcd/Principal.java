package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        while(true) {
            menuPrincipal();
            int dato = almancenarMenuPrincipal();
            switch (dato) {
                case 0:
                    System.out.print("Saliendo...");
                    System.exit(0);
                case 1:
                    System.out.print("Escriba el valor del primer lado (base) del triangulo : ");
                    double base = almacenarBase();
                    System.out.print("Escriba el valor de la altura de la pramide : ");
                    double altura = almacenarAltura();
                    System.out.print("Escriba el valor del segundo lado (der) del triangulo : ");
                    double der = almacenarDerPiramide();
                    System.out.print("Escriba el valor del segundo lado (izq) del triangulo : ");
                    double izq = almacenarIzqPiramide();
                    double area = (base * altura) / 2;
                    double perimetro = izq+base+der;
                    System.out.println("El area del triangulo es: " + area);
                    System.out.println("El perimetro es: " + perimetro);
                    break;
                case 2:
                    System.out.print("Escriba el valor del primer lado (base) del rectangulo : ");
                    base = almacenarBase();
                    System.out.print("Escriba el valor de la altura de la rectangulo : ");
                    altura = almacenarAltura();
                    area = base * altura;
                    System.out.println("El area del rectangulo es: " + area);
                    perimetro = (base + altura)*2;
                    System.out.println("El perimetro es: " + perimetro);
                    break;
                case 3:
                    System.out.print("Escriba el valor del primer lado (base) del cuadrado : ");
                    base = almacenarBase();
                    System.out.print("Escriba el valor del lado del cuadrado : ");
                    altura = almacenarAltura();
                    area = base * altura;
                    System.out.println("El area del cuadrado es: " + area);
                    perimetro = base * 4;
                    System.out.println("El perimetro es: " + perimetro);
                case 4:
                    System.out.print("Escriba el número de lados : ");
                    int lados = almacenarTotalLados();
                    System.out.print("Escriba el valor de uno de los lados : ");
                    base = almacenarBase();
                    System.out.print("Introduzca el valor del apotema : ");
                    double apotema = almacenarApotema();
                    perimetro = base * lados;
                    area = (perimetro * apotema)/2;
                    System.out.println("El perimetro es: " + perimetro);
                    System.out.println("El area del es: " + area);
                    break;
            }
        }
    }

    private static double almacenarApotema() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static int almacenarTotalLados() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static double almacenarAltura() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static double almacenarIzqPiramide() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static double almacenarDerPiramide() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static double almacenarBase() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static int almancenarMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void menuPrincipal() {
        System.out.print("FIGURAS GEOMÉTRICAS\n" +
                "1. Triángulo\n" +
                "2. Rectángulo\n" +
                "3. Cuadrado\n" +
                "4. Pentágono\n" +
                "0. Salir\n" +
                "Escoja una opción : ");
    }
}
