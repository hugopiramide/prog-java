 ackage com.liceolapaz.daw.hcd;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        while(true) {
            menuPrincipal();
            int opcionMenu = almacenarOpcionMenu();
            switch (opcionMenu) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Escriba la cantidad : ");
                    int dolares = almacenarMoneda();
                    double resultadoDolares = (dolares * 0.9);
                    System.out.print("La cantidad en euros es : " + resultadoDolares);
                    break;
                case 2:
                    System.out.print("Escriba la cantidad : ");
                    int libras = almacenarMoneda();
                    double resultadoLibras = (libras * 1.2);
                    System.out.print("La cantidad en euros es : " + resultadoLibras);
                    break;
                case 3:
                    System.out.print("Escriba la cantidad : ");
                    int yens = almacenarMoneda();
                    double resultadoYens = (yens * 0.13);
                    System.out.print("La cantidad en euros es : " + resultadoYens);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    private static int almacenarMoneda() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int almacenarOpcionMenu() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void menuPrincipal() {
        System.out.print("CONVERSOR DE MONEDAS\n" +
                "1. Dólares\n" +
                "2. Libras\n" +
                "3. Yens\n" +
                "0. Salir\n" +
                "Escoja una opción : ");
    }
}
