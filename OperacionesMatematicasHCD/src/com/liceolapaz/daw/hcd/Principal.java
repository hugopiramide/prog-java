package com.liceolapaz.daw.hcd;

public class Principal {
    public static void main(String[] args) {
        while (true) {
            funciones.menu();
            int menu = funciones.almacenarMenu();
            switch (menu) {
                case 3:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Introduzca un valor de la base : ");
                    double base = funciones.base();
                    System.out.print("Introduzca el valor del exponente : ");
                    double exponente = funciones.exponente();
                    System.out.print("El resultado de la operación es : " + Math.pow(base, exponente));
                    break;
                case 2:
                    System.out.println("Introduzca el operando : ");
                    double operando = funciones.operando();
                    System.out.println("El resultado de la operación es : " + Math.sqrt(operando));
                    break;
                default:
                    System.out.println("El valor introducido no es valido");
            }
        }
    }

}
