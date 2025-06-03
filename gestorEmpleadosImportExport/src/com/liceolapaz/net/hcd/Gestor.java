package com.liceolapaz.net.hcd;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestor {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<Integer, Empleado> empleadosHashMap = new HashMap<>();
    public static void main(String[] args) {
        do {
            menu();
            int opcionMenu = 0;
            try {
                opcionMenu = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Error: tiene que introducir un número entero");
                return;
            }
            switch (opcionMenu) {
                case 0:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                case 1:
                    importarEmpleados();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Error: Opción del menú invalido");
            }
        } while (true);
    }

    private static void agregarEmpleado() {
        System.out.print("Introduzca el numero de empleado: ");
        int num_empleado;
        try{
            num_empleado = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e ){
            System.out.println("Error: Introduzca un número valido");
            return;
        }
        if(empleadosHashMap.containsKey(num_empleado)){
            System.out.println("Error: Empleado "+ num_empleado +" existente");
            return;
        }
        System.out.print("Introduzca el DNI del empleado: ");
        String dni = sc.nextLine();
        if (dni.length() != 9){
            System.out.println("Error: Longitud de dni incorrecta, esta debe ser de 9");
            return;
        }
        System.out.print("Introduzca el nombre del empleado: ");
        String nombre = sc.nextLine();

        System.out.print("Introduzca el primer apellido del empleado: ");
        String primer_apellido = sc.nextLine();

        System.out.print("Introduzca el segundo apellido del empleado: ");
        String segundo_apellido = sc.nextLine();

        System.out.print("Introduzca la fecha de nacimiento: ");
        String fecha_nacimiento = sc.nextLine();
        if(!validarFecha(fecha_nacimiento)){
            return;
        }

        System.out.print("Introduzca el salario: ");
        String stringSalario = sc.nextLine();
        double salario;
        try{
            salario = Double.parseDouble(stringSalario);
        }catch (NumberFormatException e){
            System.out.println("Error: formato de salario incorrecto");
            return;
        }

        System.out.print("Introduzca el número de departamento: ");
        int num_dpt;
        try{
            num_dpt = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Error: Formato de salario incorrecto");
            return;
        }

        System.out.print("Introduzca el dni de jefe, en caso de que no lo tenga, no escribas y dale INTRO: ");
        String dni_jefe = sc.nextLine();
        if(dni_jefe.isEmpty()){
            dni_jefe = "null";
        }
        empleadosHashMap.put(num_empleado, new Empleado(dni,nombre,primer_apellido,segundo_apellido,fecha_nacimiento,salario,num_dpt,dni_jefe));
    }

    private static void importarEmpleados() {
        System.out.print("Introduzca la ruta del archivo que vaya a importar: ");
        String ruta = sc.nextLine();
        File f = new File(ruta);
        if(!f.exists()){
            System.out.println("Error: El archivo no fué encontrado");
            return;
        }
        try{
           HashMap<Integer, Empleado> empleadoHashMapTemp = new HashMap<>();
           Scanner contenido = new Scanner(f);
           if(!contenido.hasNextLine()) {
               System.out.println("Error: El archivo no tiene contenido");
               return;
           }
           // Saltamos la cabecera
           contenido.nextLine();
           contenido.nextLine();
           contenido.nextLine();
           while(contenido.hasNextLine()){
               contenido.nextLine();
               int num_empleado;
               try{
                   num_empleado = Integer.parseInt(contenido.nextLine().substring(9));
               }catch (NumberFormatException e ){
                   System.out.println("Error: El empleado no contiene un número válido");
                   return;
               }
               if (contenido.nextLine().equals("===============")){
                   String[] partesDni = contenido.nextLine().split(": ");
                   if (partesDni[1].length() != 9){
                       System.out.println("Error: Longitud de dni incorrecta, esta debe ser de 9");
                       return;
                   }
                   String dni = partesDni[1];

                   String[] partesNombre = contenido.nextLine().split(": ");
                   String nombre = partesNombre[1];

                   String[] partesApellido1 = contenido.nextLine().split(": ");
                   String primer_apellido = partesApellido1[1];

                   String[] partesApellido2 = contenido.nextLine().split(": ");
                   String segundo_apellido = partesApellido2[1];

                   String[] partesFechaNacimiento = contenido.nextLine().split(": ");
                   if(!validarFecha(partesFechaNacimiento[1])){
                       return;
                   }
                   String fecha_nacimiento = partesFechaNacimiento[1];

                   String[] partesSalario = contenido.nextLine().split(": ");
                   double salario;
                   try{
                       salario = Double.parseDouble(partesSalario[1]);
                   }catch (NumberFormatException e){
                       System.out.println("Error: formato de salario incorrecto");
                       return;
                   }

                   String[] partesNumDepartamento = contenido.nextLine().split(": ");
                   int num_departamento;
                   try{
                       num_departamento = Integer.parseInt(partesNumDepartamento[1]);
                   }catch (NumberFormatException e ){
                       System.out.println("Error: formato de número de departamento incorrecto");
                       return;
                   }

                   String[] partesDniJefe =  contenido.nextLine().split(": ");
                   if (!"null".equals(partesDniJefe[1]) && partesDniJefe[1].length() != 9){
                       System.out.println("Error: Formato de dni Jefe incorrecto");
                       return;
                   }
                   String dni_jefe = partesDniJefe[1];
                   empleadoHashMapTemp.put(num_empleado, new Empleado(dni,nombre,primer_apellido,segundo_apellido,fecha_nacimiento,salario,num_departamento,dni_jefe));
               }
           }
           empleadosHashMap.putAll(empleadoHashMapTemp);
           System.out.println("IMPORTADO CON ÉXITO");
        }catch (IOException e ){
            return;
        }
    }
    private static void menu() {
        System.out.print("""
                    GESTOR EMPLEADOS
                    1. Importar empleados
                    2. Añadir empleado
                    3. Modificar empleado
                    4. Eliminar empleado
                    5. Exportar empleados
                    0. Salir
                    Escoja una opción: """);
    }

    private static boolean validarFecha(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
        try{
            sdf.parse(fecha);
        } catch (Exception e) {
            System.out.println("Error: Formato de fecha incorrecto, debe ser yyyy/M/dd ");
            return false;
        }
        return true;
    }
}