package com.liceolapaz.daw.hcd;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class Gestor {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<Integer, Jugador> mapJugadores = new HashMap<>();
    public static void main(String[] args) {
        do {
            menu();
            int opcionMenu;
            try{
                opcionMenu = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error: Introduzca un valor entero");
                return;
            }
            switch (opcionMenu){
                case 0:
                    System.out.print("Saliendo...");
                    sc.close();
                    System.exit(0);
                    break;
                case 1:
                    importarJugadores();
                    break;
                case 2:
                    agregarJugador();
                    break;
                case 3:
                    modificarJugador();
                    break;
                case 4:
                    eliminarJugador();
                    break;
                case 5:
                    exportarJugadores();
                    break;
                default:
                    System.out.println("Error: Introduzca una opción válida");
            }
        }while(true);
    }

    private static void exportarJugadores() {
        System.out.print("Introduzca la ruta del fichero de jugadores que vaya a querer exportar: ");
        String ruta = sc.nextLine();
        File f = new File(ruta);

        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            LocalDateTime fechaActual = LocalDateTime.now();
            pw.println("Fecha listado: " + fechaActual.getDayOfMonth() + "/"+fechaActual.getDayOfMonth() +"/" +fechaActual.getYear()+ " "+fechaActual.getHour()+ ":" +fechaActual.getMinute()+ ":" +fechaActual.getSecond());
            pw.println("Cantidad de jugadores: "+ mapJugadores.size());
            pw.print("::::::::::::::::\n");

            for(Jugador jugador : mapJugadores.values()){
                pw.print(jugador.toString());
            }
            pw.close();
            bw.close();
            fw.close();
            System.out.println("Jugadores Exportados con Éxito");
        }catch (IOException e){
            System.out.println("Error: "+ e);
        }
    }

    private static void eliminarJugador() {
        System.out.print("Introduzca el id del jugador: ");
        int id;
        try{
            id = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e ){
            System.out.println("Error: Formato de id invalido");
            return;
        }
        if(!mapJugadores.containsKey(id)){
            System.out.println("Error: id " + id +" no existe");
            return;
        }
        mapJugadores.remove(id);
        System.out.println("Jugador eliminado con Éxito");
    }

    private static void modificarJugador() {
        System.out.print("Introduzca el id del jugador: ");
        int id;
        try{
            id = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e ){
            System.out.println("Error: Formato de id invalido");
            return;
        }
        if(!mapJugadores.containsKey(id)){
            System.out.println("Error: id " + id +" no existe");
            return;
        }
        System.out.print("Introduzca el nombre del jugador: ");
        String first_name = sc.nextLine();


        System.out.print("Introduzca el apellido del jugador: ");
        String last_name = sc.nextLine();


        System.out.print("Introduzca la posicion del jugador: ");
        String posicion = sc.nextLine();
        if(posicion.length() != 1){
            System.out.println("Error: Formato de posición no valido. Tiene que tener una longitud de 1 Carácter");
           return;
        }

        System.out.print("Introduzca el peso del jugador: ");
        int weight_pounds;
        try{
            weight_pounds = Integer.parseInt(sc.nextLine());
        }catch (NullPointerException e){
            return;
        }catch (NumberFormatException e ){
            System.out.println("Error: Formato de weight_pounds incorrecto");
            return;
        }

        System.out.print("Introduzca la conference del jugador: ");
        String conference = sc.nextLine();

        System.out.print("Introduzca la division del jugador: ");
        String division = sc.nextLine();

        System.out.print("Introduzca el nombre del equipo del jugador: ");
        String team_name = sc.nextLine();

        mapJugadores.replace(id, new Jugador(id,first_name,last_name,posicion,weight_pounds,conference,division,team_name));
        System.out.println("Jugador modificado con Éxito");
    }

    private static void agregarJugador() {
        System.out.print("Introduzca el id del jugador: ");
        int id;
        try{
            id = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e ){
            System.out.println("Error: Formato de id invalido");
            return;
        }
        if(mapJugadores.containsKey(id)){
            System.out.println("Error: id: " + id +" ya existe");
            return;
        }
        System.out.print("Introduzca el nombre del jugador: ");
        String first_name = sc.nextLine();


        System.out.print("Introduzca el apellido del jugador: ");
        String last_name = sc.nextLine();


        System.out.print("Introduzca la posicion del jugador: ");
        String posicion = sc.nextLine();

        if(posicion.length() != 1) {
            System.out.println("Error: Formato de posición no valido. Tiene que tener una longitud de 1 Carácter");
            return;
        }
        System.out.print("Introduzca el peso del jugador: ");
        int weight_pounds;
        try{
            weight_pounds = Integer.parseInt(sc.nextLine());
        }catch (NullPointerException e){
            return;
        }catch (NumberFormatException e ){
            System.out.println("Error: Formato de weight_pounds incorrecto");
            return;
        }
        
        System.out.print("Introduzca la conference del jugador: ");
        String conference = sc.nextLine();

        System.out.print("Introduzca la division del jugador: ");
        String division = sc.nextLine();

        System.out.print("Introduzca el nombre del equipo del jugador: ");
        String team_name = sc.nextLine();
        
        mapJugadores.put(id, new Jugador(id,first_name,last_name,posicion,weight_pounds,conference,division,team_name));
        System.out.println("Jugador añadido con Éxito");
    }

    private static void importarJugadores() {
        System.out.print("Introduzca la ruta del fichero de jugadores que vaya a importar: ");
        String ruta = sc.nextLine();
        File f = new File(ruta);
        if(!f.exists()){
            System.out.println("Error: El fichero no existe");
            return;
        }
        if(!f.isFile()){
            System.out.println("Error: La ruta: " + ruta + ", no se trata de un fichero");
            return;
        }
        try{
            Scanner fichero = new Scanner(f);
            if(!fichero.hasNextLine()){
                System.out.println("Error: Este fichero está vacío");
                return;
            }
            HashMap<Integer,Jugador> mapJugadoresTemp = new HashMap<>();
            fichero.nextLine();
            fichero.nextLine();
            fichero.nextLine();
            while(fichero.hasNextLine() && fichero.nextLine().equals("::::::::::::::::")){
                String[] idpartes = fichero.nextLine().split("=> ");
                int id;
                try{
                    id = Integer.parseInt(idpartes[1]);
                }catch (NumberFormatException e ){
                    System.out.println("Error: Formato de id invalido");
                    return;
                }
                // En caso de que se haya creado un jugador anteriormente
                if(mapJugadores.containsKey(id)){
                    System.out.println("Error: id " + id + " ya existe");
                    return;
                }
                String[] first_namepartes = fichero.nextLine().split("=> ");
                String first_name = first_namepartes[1].substring(1, first_namepartes[1].length() - 1);


                String[] last_namepartes = fichero.nextLine().split("=> ");
                String last_name = last_namepartes[1].substring(1, last_namepartes[1].length() - 1);


                String[] positionpartes = fichero.nextLine().split("=> ");
                String position = positionpartes[1].substring(1, positionpartes[1].length() - 1);


                String[] weight_poundspartes = fichero.nextLine().split("=> ");
                int weight_pounds;
                try{
                    weight_pounds = Integer.parseInt(weight_poundspartes[1]);
                }catch (NullPointerException e){
                    return;
                }catch (NumberFormatException e ){
                    System.out.println("Error: Formato de weight_pounds incorrecto");
                   return;
                }

                String[] conferencepartes = fichero.nextLine().split("=> ");
                String conference = conferencepartes[1].substring(1,conferencepartes[1].length() -1 );

                String[] divisionpartes = fichero.nextLine().split("=> ");
                String division = divisionpartes[1].substring(1, divisionpartes[1].length() -1);

                String[] team_namepartes = fichero.nextLine().split("=> ");
                String team_name = team_namepartes[1].substring(1, team_namepartes[1].length()-1);

                mapJugadoresTemp.put(id, new Jugador(id,first_name,last_name,position,weight_pounds,conference,division,team_name));
            }
            mapJugadores.putAll(mapJugadoresTemp);
            System.out.println("Jugadores Importados con Éxito");
        }catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no econtrado");
        }
    }
    private static void menu() {
        System.out.print("""
                GESTOR JUGADORES
                1. Importar jugadores
                2. Añadir jugador
                3. Modificar jugador
                4. Eliminar jugador
                5. Exportar jugadores
                0. Salir
                Escoja una opción: """);
    }
}
