package com.liceolapaz.des.hcd;

public class Pista extends Asistente{
    private final static int MAX_ASISTENTE_PISTA = 900;
    private final static double PRECIO_PISTA = 189.99;
    private static Pista[] pista = new Pista[MAX_ASISTENTE_PISTA];
    private static int contador_asistentes_pista = 0;
    public Pista(String nombre, String apellidos, String dni, String email, String fecha_nacimiento) {
        super(nombre, apellidos, dni, email, fecha_nacimiento);

        contador_asistentes_pista++;
        Asistente.entrada_ID++;
    }
    public static int getContador_asistentes_pista() {
        return contador_asistentes_pista;
    }

    protected static void reservarEntrada(String nombre, String apellidos, String dni, String email, String fecha_nacimiento){
        if(contador_asistentes_pista < MAX_ASISTENTE_PISTA){
            pista[contador_asistentes_pista] = new Pista(nombre,apellidos,dni,email,fecha_nacimiento);
        }
        else{
            System.out.println("LA PISTA ESTÁ COMPLETAMENTE LLENA");
        }
    }
    public static double getPRECIO_PISTA() {
        return PRECIO_PISTA;
    }
}