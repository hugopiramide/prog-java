package com.liceolapaz.net.hcd;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Gestor {
    private static Scanner sc = new Scanner(System.in);
    private static final HashMap<Integer, Departament> listaDepartamentos = new HashMap<>();

    public static void main(String[] args) {
        do{
            menu();
            switch (sc.nextInt()){
                case 1:
                    importDepartaments();
                    break;
                case 2:
                    agregarDepartamento();
                    break;
                case 3:
                    modificarDepartamento();
                    break;
                case 4:
                    eliminarDepartamento();
                    break;
                case 5:
                    exportarDepartamentos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Introduce una opción del menú válida");
                    break;
            }
        }while(true);
    }

    private static void exportarDepartamentos() {
        //
        System.out.print("Introduzca la ruta del fichero en donde quiere exportar los departamentos: ");
        String ruta = sc.nextLine();
        File importFile = new File(ruta);
//        if(!importFile.isFile()){
//            System.out.println("La ruta indicada : " + ruta + " , no se trata de un archivo");
//            return;
//        }

        try {

            FileWriter fw = new FileWriter(importFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("num_depto;nombre;nombre_corto;planta;cif_director;correo_e");

            for (Map.Entry<Integer, Departament> entry : listaDepartamentos.entrySet()) {
                Departament dpt = entry.getValue();

                pw.println(dpt.toString());
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {return;}
    }

    private static void eliminarDepartamento() {
        System.out.print("Introduzca el número de departamento: ");
        int num_dpto = 0;
        try {
            num_dpto = Integer.parseInt(sc.nextLine());
            
        } catch (InputMismatchException e) {
            System.out.println("Error: debe introducir un número entero.");
            sc.nextLine();
            return;
        }
        if(!listaDepartamentos.containsKey(num_dpto)){
            System.out.println("Error: El número de departamento no existe!!");
            return;
        }
//        for (Integer clave : listaDepartamentos.keySet()) {
//            if (clave != num_dpto) {
//                System.out.println("Error: El número de departamento no existe!!");
//                return;
//            }
//        }

        listaDepartamentos.remove(num_dpto);
    }

    private static void modificarDepartamento() {
        System.out.print("Introduzca el número de departamento: ");
        int num_dpto=0;
        try {
            num_dpto = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: debe introducir un número entero.");
            sc.nextLine();
            return;
        }

        if(!listaDepartamentos.containsKey(num_dpto)){
            System.out.println("Error: El número de departamento no existe!!");
            return;
        }

//        for (Integer clave : listaDepartamentos.keySet()) {
//            if(clave == num_dpto){
//                System.out.println("Error: El número de departamento no existe!!");
//                return;
//            }
//        }
        //Aquí podríamos crear una función para no repetir código...

        System.out.print("Introduzca el nombre del departamento: ");
        String nombre = sc.nextLine();

        System.out.print("Introduzca el nombre corto (alias) del departamento: ");
        String nombre_corto = sc.next();

        System.out.print("Introduzca la planta del departamento: ");
        int planta;
        try{
            planta = sc.nextInt();
        }catch (NumberFormatException e){
            System.out.println("Error: introduzca un valor entero");
            sc.nextLine();
            return;
        }

        System.out.print("Introduzca el cif del director: ");
        String cif_director = sc.next();
        if (!Character.isUpperCase((cif_director.charAt(cif_director.length() - 1)))){
            System.out.println("Formato incorrecto de cif_director, tiene que contener al final, una letra MAYÚSCULA");
            return;
        }
        try{
            String parteNumerica = cif_director.substring(0, cif_director.length() - 2);
            Integer.parseInt(parteNumerica);
            if(parteNumerica.length() != 8){
                System.out.println("El cif tiene que tener este formato EJ: 24590632-F");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto de cif_director, tiene que tener este formato EJ: 24590632-F");
            return;
        }

        System.out.print("Introduzca el correo electrónico: ");
        String correo = sc.next();
        if(!correo.endsWith("@empresa.es")){
            System.out.println("Formato incorrecto de Correo Electrónico, tiene que acabar por @empresa.es");
            return;
        }

        listaDepartamentos.replace(num_dpto, new Departament(num_dpto,nombre,nombre_corto,planta,cif_director,correo));
    }

    private static void agregarDepartamento() {
        System.out.print("Introduzca el número de departamento: ");
        int num_dpto=0;
        try {
                num_dpto = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debe introducir un número entero.");
                sc.nextLine();
                return;
            }
        //.keySet() coje todos los valores clave del hasmap y .values() solo los valores
        if(listaDepartamentos.containsKey(num_dpto)){
            System.out.println("Error: Número de departamento existente!!");
            return;
        }
//        for (Integer clave : listaDepartamentos.keySet()) {
//            if(clave == num_dpto){
//                System.out.println("Error: Número de departamento existente!!");
//                return;
//            }
//        }
        //Aquí podríamos crear una función para no repetir código...

        System.out.print("Introduzca el nombre del departamento: ");
        String nombre = sc.nextLine();

        System.out.print("Introduzca el nombre corto (alias) del departamento: ");
        String nombre_corto = sc.next();

        System.out.print("Introduzca la planta del departamento: ");
        int planta;
        try{
            planta = sc.nextInt();
        }catch (NumberFormatException e){
            System.out.println("Error: introduzca un valor entero");
            sc.nextLine();
            return;
        }

        System.out.print("Introduzca el cif del director: ");
        String cif_director = sc.next();
        if (!Character.isUpperCase((cif_director.charAt(cif_director.length() - 1)))){
            System.out.println("Formato incorrecto de cif_director, tiene que contener al final, una letra MAYÚSCULA");
            return;
        }
        try{
            String parteNumerica = cif_director.substring(0, cif_director.length() - 2);
            Integer.parseInt(parteNumerica);
            if(parteNumerica.length() != 8){
                System.out.println("El cif tiene que tener este formato EJ: 24590632-F");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto de cif_director, tiene que tener este formato EJ: 24590632-F");
            return;
        }

        System.out.print("Introduzca el correo electrónico: ");
        String correo = sc.next();
        if(!correo.endsWith("@empresa.es")){
            System.out.println("Formato incorrecto de Correo Electrónico, tiene que acabar por @empresa.es");
            return;
        }

        listaDepartamentos.put(num_dpto, new Departament(num_dpto,nombre,nombre_corto,planta,cif_director,correo));
    }

    private static void importDepartaments(){
        System.out.print("Introduzca la ruta del fichero que vaya a Importar: ");
        String ruta = sc.next();
        File importFile = new File(ruta);
        if(!importFile.isFile()){
            System.out.println("La ruta indicada : " + ruta + " , no se trata de un archivo");
            return;
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(importFile);
        } catch (FileNotFoundException e) {return;}
        HashMap<Integer, Departament> departamentos = new HashMap<>();

            if(scanner.hasNextLine()){
                scanner.nextLine();
            }
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                if(parts.length != 6){
                    System.out.println("Formato incorrecto de datos");
                    return;
                }
                int num_dpto;
                try{
                    num_dpto = Integer.parseInt(parts[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Formato de número de departamento incorrecto");
                    return;
                }
                String nombre = parts[1];
                String nombre_corto = parts[2];
                int planta;
                try{
                    planta = Integer.parseInt(parts[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Formato incorrecto de planta");
                    return;
                }

                if (!Character.isUpperCase((parts[4].charAt(parts[4].length() - 1)))){
                    System.out.println("Formato incorrecto de cif_director");
                    return;
                }
                try{
                    String parteNumerica = parts[4].substring(0, parts[4].length() - 2);
                    Integer.parseInt(parteNumerica);
                } catch (NumberFormatException e) {
                    System.out.println("Formato incorrecto de cif_director");
                    return;
                }
                String cif_director = parts[4];

                if(!parts[5].endsWith("@empresa.es")){
                    System.out.println("Formato incorrecto de Correo Electrónico");
                    return;
                }
                String correo = parts[5];
                departamentos.put(num_dpto,new Departament(num_dpto,nombre,nombre_corto,planta,cif_director,correo));
            }

            listaDepartamentos.putAll(departamentos);
        System.out.println("Departamentos añadidos con ÉXITO");
    }

    public static void menu(){
        System.out.print("""
                GESTOR DEPARTAMENTOS
                1. Importar departamentos
                2. Añadir departamento
                3. Modificar departamento
                4. Eliminar departamento
                5. Exportar departamentos
                0. Salir
                Escoja una opción: """);
    }
}
