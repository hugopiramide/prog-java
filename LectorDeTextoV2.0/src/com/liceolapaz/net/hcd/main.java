package com.liceolapaz.net.hcd;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String rutaFicheroDestino;
        String rutaFicheroOrigen;
        do {
            mainMenu();
            switch (sc.nextInt()){
                case 0:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Escriba la ruta del fichero de texto (Ruta Absoluta): ");
                    String rutaAbsoluta = sc.next();
                    leerFichero(rutaAbsoluta);
                    break;
                case 2:
                    menuCopiarFichero();
                    switch (sc.nextInt()){
                        case 0:
                            continue;
                        case 1:
                            System.out.print("Escriba la ruta del fichero origen: ");
                            rutaFicheroOrigen = sc.next();
                            System.out.print("Escriba la ruta del fichero Destino: ");
                            rutaFicheroDestino = sc.next();
                            copiarFicheroDeTexto(rutaFicheroOrigen, rutaFicheroDestino);
                            break;
                        case 2:
                            System.out.print("Escriba la ruta del fichero origen: ");
                            rutaFicheroOrigen = sc.next();
                            System.out.print("Escriba la ruta del fichero Destino: ");
                            rutaFicheroDestino = sc.next();
                            copiarFicheroEnBinario(rutaFicheroOrigen, rutaFicheroDestino);
                            break;
                        default:
                            System.out.println("Error, no me quemes, escoja una opción válida");
                    }
                    break;
                case 3:
                    System.out.print("Escriba la ruta del Directorio : ");
                    String rutaDirectorio = sc.next();
                    mostrarArchivosDirectorio(rutaDirectorio);
                    break;
                default:
                    System.out.println("Opción introducida no valida");
                    break;
            }
        }while(true);
    }

    // Mostrar Archivos Directorio
    private static void mostrarArchivosDirectorio(String rutaDirectorio) {
        File dir = new File(rutaDirectorio);

        if(dir.exists() && dir.isDirectory()){
            File[] archivos = dir.listFiles();
            if(dir.length() > 0 && archivos != null){
                for (int i = 0; i < archivos.length; i++) {
                    double sizeKB = (double) archivos[i].length() / 1024;
                    System.out.println(archivos[i].getName() + " - " + sizeKB +" KB");
                }
            }
        } else{
            System.out.println("La ruta " + dir + " no es un directorio");
        }
    }

    // Copia y pega fichero de texto
    private static void copiarFicheroDeTexto(String rutaFicheroOrigen, String rutaFicheroDestino) {
        try{
            ArrayList<String> textLineficheroOrigen = new ArrayList<>();

            File ficheroOrigen = new File(rutaFicheroOrigen);
            FileReader frOrigen = new FileReader(ficheroOrigen);
            BufferedReader brOrigen = new BufferedReader(frOrigen);

            File ficheroDestino = new File(rutaFicheroDestino);
            BufferedWriter bwDestino = new BufferedWriter(new FileWriter(ficheroDestino));
            PrintWriter pwDestino = new PrintWriter(bwDestino);

            String line;
            while((line = brOrigen.readLine()) != null){
                textLineficheroOrigen.add(line);
            }
            brOrigen.close();
            for (int i = 0; i < textLineficheroOrigen.size(); i++){
                pwDestino.println(textLineficheroOrigen.get(i));
            }
            pwDestino.close();

            System.out.print("Archivo copiado y pegado con ÉXITO");

        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {}
    }

    // Copia y pega fichero Binario, Problemilla aquí
    private static void copiarFicheroEnBinario(String rutaFicheroOrigen, String rutaFicheroDestino) {
        try{
            File ficheroOrigen = new File(rutaFicheroOrigen);
            FileInputStream fisOrigen = new FileInputStream(ficheroOrigen);
            BufferedInputStream bisOrigen = new BufferedInputStream(fisOrigen);

            File ficheroDestino = new File(rutaFicheroDestino);
            BufferedOutputStream bosDestino = new BufferedOutputStream(new FileOutputStream(ficheroDestino));

            //byte[] bytesLeidos = bisOrigen.readAllBytes(); lee todo de golpe, consume mucha RAM

            ArrayList<Byte> listBytesFicheroOrigen = new ArrayList<>();
            byte[] bytesBuffer = new byte[1024];
            int bytesLeidos;

            // Aquí añadirmos los bytesBuffer (Es decir, en Bloques) al arrayList listBytesFicheroOrigen

            while ((bytesLeidos = bisOrigen.read(bytesBuffer)) != -1){
                for (int i = 0; i < bytesLeidos; i++) {
                    listBytesFicheroOrigen.add(bytesBuffer[i]);
                }
            }
            bisOrigen.close();

            // Aquí se la pegamos al ficheroDestino (No sé como pegar los bloques en el archivo binario)

            for(int i = 0; i < listBytesFicheroOrigen.size(); i++){
                bosDestino.write(listBytesFicheroOrigen.get(i));
            }
            bosDestino.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {}
    }

    //Menus
    private static void menuCopiarFichero() {
        System.out.print("""
                Tipo de fichero a copiar
                1. Fichero de texto
                2. Fichero binario
                0. Cancelar
                Escoja una opción: """);
    }

    private static final Scanner sc = new Scanner(System.in);
    public static void mainMenu(){
        System.out.print("""
                FICHEROS
                1. Leer fichero de texto
                2. Copiar fichero
                3. Listar archivos de Directorio
                0. Exit
                Escoja una opción: """);
    }

    //Comprobación Fichero
    private static void leerFichero(String rutaAbsoluta){
        try{
            File ruta = new File(rutaAbsoluta);
            FileReader fr = new FileReader(ruta);
            leerFicheroTexto(fr);

        } catch (FileNotFoundException e) {
            System.out.println("La ruta " + rutaAbsoluta + " no es un fichero...");
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
    //Lectura Fichero De Texto
    private static void leerFicheroTexto(FileReader fr){
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> textLine = new ArrayList<>();

        String line;
        System.out.println("------------------------------------");
        try{
            while((line = br.readLine()) != null){
                 textLine.add(line);
            }
            for (int j = 0; j < textLine.size(); j++){
                System.out.println(textLine.get(j));
            }
            System.out.println("------------------------------------");
            br.close();
            fr.close();
        } catch (IOException e) {}
    }
}
