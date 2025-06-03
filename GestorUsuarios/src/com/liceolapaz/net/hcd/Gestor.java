package com.liceolapaz.net.hcd;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Gestor {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<Integer, Usuario> userMap = new HashMap<>();
    public static void main(String[] args) {
        do{
            menu();
            int opcionMenu;
            try{
                opcionMenu = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: La opción debe ser un número ENTERO");
                continue;
            }
            switch (opcionMenu){
                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                case 1:
                    importarUsuarios();
                    break;
                case 2:
                    agregarUsuario();
                    break;
                case 3:
                    modificarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    exportarUsuarios();
                    break;
                default:
                    System.out.println("Error: Opción no valida");
                    break;
            }
        }while(true);
    }

    private static void exportarUsuarios() {
        System.out.print("Introduzca la ruta/nombre del fichero que vaya a querer exportar: ");
        String ruta = sc.nextLine();
        File f = new File(ruta);
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            // Se podría utilizar la librería Gson
            pw.println("[");
            int i = 0;
            int size = userMap.size();
            for (Usuario value : userMap.values()) {
                pw.print(value.toString());
                if (i < size - 1) {
                    pw.println(",");
                } else {
                    pw.println();
                }
                i++;
            }
            pw.println("]");
            pw.close();
            bw.close();
            fw.close();
            System.out.println("Exportado con ÉXITO");
        }catch (IOException e){
            System.out.println("ERROR: No puede ser un directorio");
            return;
        }
    }

    private static void eliminarUsuario() {
        System.out.print("Introduzca el id del usuario: ");
        int id;
        try{
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ser un número ENTERO !!");
            System.out.println("Error: " + e);
            return;
        }

        if(!userMap.containsKey(id)) {
            System.out.println("Error: El usuario con id: " + id + " no existe !!");
            return;
        }
        System.out.print("Introduzca el email del usuario: ");
        String email = sc.nextLine();
        System.out.print("Introduzca el nombre: ");
        String firs_name = sc.nextLine();
        System.out.print("Introduzca el apellido: ");
        String last_name = sc.nextLine();
        System.out.print("Introduzca la URL del avatar: ");
        String avatar = sc.nextLine();

        userMap.remove(id);
        System.out.println("Usuario eliminado con ÉXITO");
    }

    private static void modificarUsuario() {
        System.out.print("Introduzca el id del usuario: ");
        int id;
        try{
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ser un número ENTERO !!");
            return;
        }

        if(!userMap.containsKey(id)) {
            System.out.println("Error: El usuario con id: " + id + " no existe !!");
            return;
        }
        System.out.print("Introduzca el email del usuario: ");
        String email = sc.nextLine();
        System.out.print("Introduzca el nombre: ");
        String firs_name = sc.nextLine();
        System.out.print("Introduzca el apellido: ");
        String last_name = sc.nextLine();
        System.out.print("Introduzca la URL del avatar: ");
        String avatar = sc.nextLine();

        userMap.replace(id, new Usuario(id,email, firs_name ,last_name,avatar));
        System.out.println("Usuario modificado con ÉXITO");
    }

    private static void agregarUsuario() {
        System.out.print("Introduzca el id del usuario: "); // No recomendable, pero nos lo pide el enunciado...
        int id;
        try{
            id = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Error: Debe ser un número ENTERO !!");
            return;
        }
        // Comprobación de la existencia del id
        if(userMap.containsKey(id)) {
            System.out.println("Error: El usuario con id: " + id + " ya existe !!");
            return;
        }

        System.out.print("Introduzca el email del usuario: ");
        String email = sc.nextLine();
        System.out.print("Introduzca el nombre: ");
        String firs_name = sc.nextLine();
        System.out.print("Introduzca el apellido: ");
        String last_name = sc.nextLine();
        System.out.print("Introduzca la URL del avatar: ");
        String avatar = sc.nextLine();

        userMap.put(id, new Usuario(id,email, firs_name ,last_name,avatar));
        System.out.println("Usuario creado con ÉXITO");
    }

    private static void importarUsuarios() {
        System.out.print("Introduzca la ruta del fichero que vaya a importar: ");
        String ruta = sc.nextLine();
        File f = new File(ruta);
        // if(!f.exists()) --> Omitido
        if(!f.isFile()){
            System.out.println("La ruta: " + ruta + " no se trata de un fichero");
            return;
        }
        try{
            Scanner fichero = new Scanner(f);
            if(!fichero.hasNextLine()){
                System.out.println("Error, no contiene información");
                return;
            }
            HashMap<Integer,Usuario> pullUserMap = new HashMap<>();
            fichero.nextLine();
            while(Objects.equals(fichero.nextLine(), "  {")){
                String linea = fichero.nextLine();
                String[] lineaId = linea.split(": ");
                int id;
                try{
                    id = Integer.parseInt(lineaId[1].replace(",",""));
                }catch (NumberFormatException e){
                    System.out.println("Error: Formato de id Incorrecto");
                    return;
                }
                linea = fichero.nextLine();
                String[] lineaEmail = linea.split(": ");
                String email = lineaEmail[1].substring(1,lineaEmail[1].length() - 2);

                linea = fichero.nextLine();
                String[] lineaFirst_name = linea.split(": ");
                String first_name = lineaFirst_name[1].substring(1,lineaFirst_name[1].length() - 2);

                linea = fichero.nextLine();
                String[] lineaLast_name = linea.split(": ");
                String last_name = lineaLast_name[1].substring(1,lineaLast_name[1].length() - 2);

                linea = fichero.nextLine();
                String[] lineaAvatar = linea.split(": ");
                String avatar = lineaAvatar[1].substring(1, lineaAvatar[1].length() - 1);

                fichero.nextLine();

                pullUserMap.put(id, new Usuario(id,email,first_name,last_name,avatar));
            }
            userMap.putAll(pullUserMap);
            System.out.println("Exportado con ÉXITO");
            
        }catch (PatternSyntaxException e){
            System.out.println("ERROR: No se puedo exportar el fichero");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
        }
    }

    private static void menu() {
        System.out.print("""
                GESTOR USUARIOS
                1. Importar usuarios
                2. Añadir usuario
                3. Modificar usuario
                4. Eliminar usuario
                5. Exportar usuarios
                0. Salir
                Escoja una opción: """);
    }
}