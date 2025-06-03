package com.liceolapaz.des.hcd;

import java.util.Scanner;

public class Asistente {
    private final static int MAX_ASISTENTES = 26000;
    private static Asistente[] asistentes = new Asistente[MAX_ASISTENTES];
    private static final Scanner sc = new Scanner(System.in);
    private String nombre,apellidos,email,tipo_entrada,dni,fecha_nacimiento;
    protected static int entrada_ID = 0;
    public Asistente(String email,String tipo_entrada){
        this.email = email;
        this.tipo_entrada = tipo_entrada;
    }
    public Asistente(String nombre, String apellidos, String dni, String email, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public static int mostrarEntradasVendidas(){
        return Pista.getContador_asistentes_pista() + Backstage.getContador_baskstage() + Grada.getContador_asistentes_grada();
    }


    public static int mostrarEntradasDisponibles(){
        return MAX_ASISTENTES - mostrarEntradasVendidas();
    }
    public static void reservarEntrada(){
        menuEntrada();
        if(sc.nextInt() == 2){
            menuEntradaBackstage();
            if (sc.nextInt() == 1 && comprobarAsistenteCompra(Backstage.getPrecioBackstage())){
                Asistente asistente = solicitarDatosUsuario(sc);

                asistentes[mostrarEntradasVendidas()] = new Asistente(asistente.email, "backstage");
                Backstage.reservarEntrada(asistente.nombre,asistente.apellidos,asistente.dni,asistente.email,asistente.fecha_nacimiento);
            }
            else if(comprobarAsistenteCompra(Pista.getPRECIO_PISTA())){
                Asistente asistente = solicitarDatosUsuario(sc);

                asistentes[mostrarEntradasVendidas()] = new Asistente(asistente.email,"pista");
                Pista.reservarEntrada(asistente.nombre,asistente.apellidos,asistente.dni,asistente.email,asistente.fecha_nacimiento);
            }
        }
        else if(comprobarAsistenteCompra(Grada.getPrecio_grada())){

            Asistente asistente = solicitarDatosUsuario(sc);
            
            System.out.print("Fila(1-25): ");
            int fila = sc.nextInt();

            while(fila < 1 || fila > 25){
                System.out.print("ERROR, LA FILA NO EXISTE, Introduce de nuevo la fila : ");
                fila = sc.nextInt();
            }
            System.out.print("Asiento(1-1000): ");
            int asiento = sc.nextInt();
            while(asiento < 1 || asiento > 1000){
                System.out.print("ERROR,EL ASIENTO NO EXISTE, Introduce de nuevo el asiento : ");
                asiento = sc.nextInt();
            }

            asistentes[mostrarEntradasVendidas()] = new Asistente(asistente.email,"grada");
            Grada.reservarEntrada(asistente.nombre,asistente.apellidos,asistente.dni,asistente.email,asistente.fecha_nacimiento,fila,asiento);
        }
    }
    private static Asistente solicitarDatosUsuario(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.next();

        System.out.print("Apellidos: ");
        String apellidos = sc.next();

        System.out.print("DNI: ");
        String dni = sc.next();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Fecha de nacimiento (YYYYMMDD): ");
        String fechaNacimiento = sc.next();

        return new Asistente(nombre, apellidos, dni, email, fechaNacimiento);
    }

    public String mostrarEntrada(){
        System.out.print("Introduzca su email: ");
        String email = sc.next();
        for(int i = 0; i < MAX_ASISTENTES - 1; i++){
            if(asistentes[i] != null && email.equals(asistentes[i].email)){
                switch (asistentes[i].tipo_entrada){
                    case "Backstage":
                        return "Entrada"+ Backstage.entrada_ID +" de backstage, Precio de "+Backstage.getPrecioBackstage()+", Nombre"+ this.nombre + "";
                    case "Pista":
                        break;
                    case "Grada":
                        break;
                }
            }
        }
        return "Correo no encontrado o no existente";
    }

    private static boolean comprobarAsistenteCompra(double precio){
        //Comprobamos si el asistente está de acuerdo con el precio de dicha entrada
        System.out.print("El total sería de " + precio + "$\n" +
                "COMPRAR\n" +
                "1. Si\n" +
                "2. No\n" +
                "Escoja una opción : ");
        return sc.nextInt() == 1;
    }

    public static void menuEntrada(){
        System.out.print("TIPO DE ENTRADA\n" +
                "1. Grada\n" +
                "2. Pista\n" +
                "Escoja una opción: ");
    }
    public static void menuEntradaBackstage(){
        System.out.print("QUIERES ACCEDER AL BACKSTAGE?\n" +
                "1. Si\n" +
                "2. No\n" +
                "Escoja una opcion: ");
    }
}