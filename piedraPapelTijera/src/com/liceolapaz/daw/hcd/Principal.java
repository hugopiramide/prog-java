package com.liceolapaz.daw.hcd;

import java.security.SecureRandom;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        while(true) {
            menu();
            int menu = almacenarDato();
            switch (menu) {
                case 0:
                    System.out.println("Saliendo...");
                    System.exit(0);
                case 1:
                    System.out.print("Escriba su jugada (Piedra, Papel, Tijera, Lagarto o Spock): ");
                    String tipoJugadaPrograma = arrayJuego(aleatorio());
                    String tipoJugada = almacenarDatoString().toLowerCase();
                    if (tipoJugada == tipoJugadaPrograma){
                        System.out.println("EMPATE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                    }else{
                    switch (tipoJugada) {
                        case "piedra":
                            if (tipoJugadaPrograma == "lagarto" || tipoJugadaPrograma == "tijera") {
                                System.out.println("GANASTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else if(tipoJugadaPrograma == "spock"|| tipoJugadaPrograma == "papel"){
                                System.out.println("PERDISTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else{
                                System.out.println("JUGADA NO PERMITIDA, EL ORDENADOR HABÍA JUGADO: "+tipoJugadaPrograma);
                            }
                            break;
                        case "papel":
                            if (tipoJugadaPrograma == "piedra" || tipoJugadaPrograma == "spock") {
                                System.out.println("GANASTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else if(tipoJugadaPrograma == "lagarto"|| tipoJugadaPrograma == "tijera"){
                                System.out.println("PERDISTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else{
                                System.out.println("JUGADA NO PERMITIDA, EL ORDENADOR HABÍA JUGADO: "+tipoJugadaPrograma);
                            }
                            break;
                        case "tijera":
                            if (tipoJugadaPrograma == "lagarto" || tipoJugadaPrograma == "papel") {
                                System.out.println("GANASTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else if(tipoJugadaPrograma == "piedra"|| tipoJugadaPrograma == "spock"){
                                System.out.println("PERDISTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else{
                                System.out.println("JUGADA NO PERMITIDA, EL ORDENADOR HABÍA JUGADO: "+tipoJugadaPrograma);
                            }
                            break;
                        case "lagarto":
                            if (tipoJugadaPrograma == "spock" || tipoJugadaPrograma == "papel") {
                                System.out.println("GANASTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else if(tipoJugadaPrograma == "tijera"|| tipoJugadaPrograma == "piedra"){
                                System.out.println("PERDISTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else{
                                System.out.println("JUGADA NO PERMITIDA, EL ORDENADOR HABÍA JUGADO: "+tipoJugadaPrograma);
                            }
                            break;
                        case "spock":
                            if (tipoJugadaPrograma == "piedra" || tipoJugadaPrograma == "tijera") {
                                System.out.println("GANASTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else if(tipoJugadaPrograma == "lagarto"|| tipoJugadaPrograma == "papel"){
                                System.out.println("PERDISTE, EL PROGRAMA ESCOGIÓ: "+tipoJugadaPrograma);
                            }else{
                                System.out.println("JUGADA NO PERMITIDA, EL ORDENADOR HABÍA JUGADO: "+tipoJugadaPrograma);
                            }
                            break;
                        default:
                            System.out.println("JUGADA NO PERMITIDA, EL ORDENADOR HABÍA JUGADO: "+tipoJugadaPrograma);
                    }
                    }
                    break;
                default:
                    System.out.println("VALOR INTRODUCIDO NO VALIDO");
            }
        }
    }

    private static int almacenarDato() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static String arrayJuego(int aleatorio){
        String[] jugada = new String[5];
        jugada[0] = "piedra";
        jugada[1] = "papel";
        jugada[2] = "tijera";
        jugada[3] = "lagarto";
        jugada[4] = "spock";
        return jugada[aleatorio];
    }

    private static int aleatorio(){
        SecureRandom random = new SecureRandom();
        return random.nextInt(4);
    }

    private static String almacenarDatoString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static void menu(){
        System.out.print("\nPIEDRA PAPEL TIJERA LAGARTO SPOCK \n" +
                "1.Jugar\n" +
                "0.Salir\n" +
                "Escoja una opción: ");
    }
}
