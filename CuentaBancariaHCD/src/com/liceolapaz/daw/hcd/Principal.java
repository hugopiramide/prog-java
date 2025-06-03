package com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int tipoCuenta = 0;
        Integer cantidad = null;
        while(true) {
            escribirMenu();

            int dato = almacenarDatoMenu();
            if (dato == 1) {
                escribirMenuTipoCuenta();
                tipoCuenta = almacenarMenuTipoCuenta();
                if (tipoCuenta == 1) {
                    cantidad = datoCuenta();
                    while (cantidad < 0) {
                        System.out.println("LA CANTIDAD DEBE SER POSITIVA");
                        cantidad = datoCuenta();
                    }
                } else if (tipoCuenta == 2) {
                    cantidad = datoCuenta();
                } else if (tipoCuenta != 0) {
                    System.out.print("ERROR, OPCION INTRODUCIDA NO VALIDA\n");
                }
            } else if (dato == 2 && cantidad != null) {
                System.out.print("Escriba la cantidad : ");
                int retiradaDinero = almacenarDineroRetirada();
                cantidad = cantidad + retiradaDinero;
                System.out.print("El saldo de la cuenta es de " + cantidad + "\n");
            } else if (dato == 3 && cantidad != null) {
                System.out.print("Escriba la cantidad : ");
                int retiradaDinero = almacenarDineroRetirada();
                int cantidad1 = cantidad - retiradaDinero;
                if (cantidad1 >= 0 || tipoCuenta == 2){
                    cantidad = cantidad - retiradaDinero;
                    System.out.print("El saldo de la cuenta es de " + cantidad + "\n");
                }else{ System.out.print("No puedes estár en números rojos, tu saldo actual es "+cantidad+"\n");}
            } else if (dato == 0) {
                System.out.print("Saliendo...");
                System.exit(0);
            } else if (dato == 4 && cantidad != null) {
                System.out.print("El saldo de la cuenta es de " + cantidad + "\n");
            }else if (cantidad == null && dato <= 5 && dato > 0) {
                System.out.println("Error, no tiene una cuenta creada");
            }else{
                System.out.print("ERROR, opción introducida no valida\n");
            }
        }
    }

    private static int almacenarDineroRetirada() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int datoCuenta() {
        System.out.print("Escriba el saldo inicial : ");
        return almacenarDatoCuenta();
    }

    private static int almacenarDatoCuenta() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int almacenarMenuTipoCuenta() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int almacenarDatoMenu() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void escribirMenuTipoCuenta() {
        System.out.print("Tipo de cuenta\n"+
        "1. Cuenta normal\n"+
        "2. Cuenta Premium\n" +
        "0. Cancelar\n"+
        "Escoja una opción : ");
    }

    private static void escribirMenu() {
       System.out.print("BANCO\n" +
        "1. Crear cuenta\n"+
        "2. Ingresar dinero\n"+
        "3. Retirar dinero\n"+
        "4. Consultar saldo\n"+
        "0. Salir\n"+
        "Escoja una opción : ");
    }
}
