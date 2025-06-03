package com.liceolapaz.des.hcd;

import java.util.Scanner;

public class Biblioteca {
    private static Socio[] socio = new Socio[1000]; //Creamos un array de instancias de Socios
    private static Libro[] libro = new Libro[5000]; //Ahora de libros

    public static void main(String[] args) {
        int countSocios = 0;
        int countLibros = 0;
        Boolean estadoBucle = true;
        while(estadoBucle){
            menu();
            int opcion = sc.nextInt();
            switch (opcion){
                case 0:
                    estadoBucle = false; //Ns prq sigo haciendo esta tontería
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                case 1:
                    if(countSocios >= 1000) {
                        System.out.println("Numero máximo de Socios en la Biblioteca");
                    }else{
                        System.out.print("Nombre: ");
                        String nombre = sc.next();
                        System.out.print("Apellidos: ");
                        String apellidos = sc.next();
                        System.out.print("DNI: ");
                        String dni = sc.next();
                        System.out.print("Email: ");
                        String email = sc.next();
                        System.out.print("Fecha de Nacimiento: ");
                        String date = sc.next();
                        try{
                            socio[countSocios] = new Socio(nombre,apellidos,dni,email,date,countSocios);
                            System.out.println("BIENVENIDO , TU NUMERO DE SOCIO ES --> " +countSocios+ " NO LO PIERDAS");
                            countSocios++;
                        }catch (Exception e){
                            System.out.println("ALGO SALIÓ MAL, VUELVE A INTRODUCIR EL FORMULARIO");
                        }
                    }
                    break;
                case 2:
                    if (countLibros >= 5000) {
                        System.out.println("Numero máximo de libros en la Biblioteca");
                    }else{
                        System.out.print("ISBN: ");
                        int isbn = sc.nextInt();
                        System.out.print("Título: ");
                        String titulo = sc.next();
                        System.out.print("Genero: ");
                        String genero = sc.next();
                        System.out.print("Páginas: ");
                        int paginas = sc.nextInt();
                        try{
                            libro[countLibros] = new Libro(isbn,titulo,genero,paginas);
                            countLibros = countLibros + 1;
                            System.out.println("LIBRO CREADO CON ÉXITO");
                        } catch (Exception e) {
                            System.out.println("ALGO SALIÓ MAL, VUELVE A INTRODUCIR EL FORMULARIO");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Introduzca el número de Socio: ");
                    int numSocio = sc.nextInt();
                    for (int i = 0; i < countSocios ;i++){
                        if(socio[i].getNum_socio() == numSocio){
                            System.out.print("Introduzca el ISBN: ");
                            int isbn = sc.nextInt();
                            for(int j = 0; j < countLibros;j++){
                                if(libro[j].getISBN() == isbn){
                                    if(socio[i].cogerLibro(libro[j])){
                                        System.out.println("LIBRO AÑADIDO CON ÉXITO");
                                    }else{
                                        System.out.println("LIBRO NO AÑADIDO");
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Introduzca el número de Socio: ");
                    numSocio = sc.nextInt();
                    for (int i = 0; i < countSocios ;i++){
                        if(socio[i].getNum_socio() == numSocio){
                            System.out.print("Introduzca el ISBN: ");
                            int isbn = sc.nextInt();
                            for(int j = 0; j < countLibros;j++){
                                if(libro[j].getISBN() == isbn){
                                    if (socio[i].devolverLibro(libro[j])){
                                        System.out.println("LIBRO DEVUELTO A LA BIBLIOTECA");
                                    }else {
                                        System.out.println("No puede devolverlo, el Libro está actualmente disponible en la biblioteca");
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 5:
                    listarLibrosDisponibles();
                    break;
                case 6:
                    listarLibrosNoDisponibles();
                    break;
                case 7:
                    System.out.print("Introduzca el número de Socio: ");
                    numSocio = sc.nextInt();
                    for (int i = 0; i < countSocios ;i++){
                        if(socio[i].getNum_socio() == numSocio){
                            socio[i].totalLibros();
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("OPCIÓN DEL MENÚ NO VALIDA");
                    break;
            }
        }
    }

    private static void listarLibrosDisponibles(){
        for (int i = 0; i < libro.length; i++){
            if(libro[i] != null && libro[i].getDisponibilidad()){
                System.out.println(libro[i].getTitulo());
            }
        }
    }

    private static void listarLibrosNoDisponibles(){
        for (int i = 0; i < libro.length; i++){
            if(libro[i] != null && !libro[i].getDisponibilidad()){
                System.out.println(libro[i].getTitulo());
            }
        }
    }

    private static final Scanner sc = new Scanner(System.in);
    private static void menu(){
        System.out.print("GESTOR BIBLIOTECA\n" +
                "1. Crear socio\n" +
                "2. Crear libro\n" +
                "3. Llevarse libro\n" +
                "4. Devolver libro\n" +
                "5. Mostrar libros disponibles\n" +
                "6. Mostrar libros no disponibles\n" +
                "7. Mostrar libros de un socio\n" +
                "0. Salir\n" +
                "Escoja una opción: ");
    }
}
