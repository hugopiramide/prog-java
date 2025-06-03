package com.liceolapaz.net.hcd;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Gestor {
    private static HashMap<String, Empleado> empleado = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            escribirMenu();
            switch (sc.nextInt()){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    importarEmpleados();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }while (true);
    }

    private static void importarEmpleados() {
        System.out.print("Escriba la ruta del fichero : ");
        String ruta = sc.next();
        File fichero = new File(ruta);
        if(!fichero.isFile()){
            System.out.println("La ruta" + ruta +" no es un fichero");
            return;
        }
        try {
            Scanner escaner = new Scanner(fichero);
            String linea;
            if(escaner.hasNextLine()){
                escaner.nextLine();
            }
            while (escaner.hasNextLine()){
                linea = escaner.nextLine();
                String[] campos = linea.split(", ");
                if(campos.length != 8){
                    System.out.println("Formato de fichero incorrecto");
                    return;
                }
                String dni = campos[0].substring(0, campos[0].length()-1);
                if(!comprobarDni(dni)){
                    System.out.println("Fomato de DNI incorrecto. EJ : 12345678Z");
                    return;
                }
                String nombre = campos[1].substring(1, campos[1].length()-1);
                String apellido1 = campos[2].substring(1,campos[2].length()-1);
                String fechaTexto = campos[4].substring(1, campos[4].length()-1);

                Date fechaNacimiento = validarFecha(fechaTexto);
                if (fechaNacimiento == null){
                    System.out.println("Formato de fecha incorrecto, yyyy/M/d");
                }
                String salarioTexto = campos[5].substring(1, campos[5].length()-1);
                double salario;
                try {
                    salario = Double.parseDouble(salarioTexto);
                } catch (NumberFormatException e) {
                    return;
                }
                String departamentoTexto = campos[6];

                int departamento;
                try {
                    departamento = Integer.parseInt(departamentoTexto);
                } catch (NumberFormatException e) {
                    return;
                }
                String dniJefe;

            }
        } catch (FileNotFoundException e) {
            System.out.println("La ruta " + ruta + " no es valida");
        }

    }

    private static Date validarFecha(String fechaTexto) {
        SimpleDateFormat sdf = new SimpleDateFormat(fechaTexto);
        sdf.setLenient(false); // Para que la fecha sea permisiva o no
        try{
            return sdf.parse(fechaTexto);

        } catch (ParseException e) {
            return null;
        }
    }

    private static boolean comprobarDni(String dni) {
        if(dni.length() != 9){
            return false;
        }
        String numeroTexto = dni.substring(0,9);
        int numero;
        try{
            numero = Integer.parseInt(numeroTexto);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            char letra =  dni.charAt(8);
            if (letra != letras.charAt(numero % letras.length())){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void escribirMenu() {
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
}
