package com.liceolapaz.des.hcd;

public class Backstage extends Asistente{
    private final static int MAX_ASISTENTES_BACKSTAGE = 100;
    private final static double PRECIO_BACKSTAGE = 300;
    private static Backstage[] backstage = new Backstage[MAX_ASISTENTES_BACKSTAGE];
    private static int contador_baskstage = 0;

    public Backstage(String nombre, String apellidos, String dni, String email, String fecha_nacimiento) {
        super(nombre, apellidos, dni, email, fecha_nacimiento);

        contador_baskstage++;
        Asistente.entrada_ID++;
    }
    public static int getContador_baskstage() {
        return contador_baskstage;
    }



    protected static void reservarEntrada(String nombre, String apellidos, String dni, String email, String fecha_nacimiento){
        if(contador_baskstage < MAX_ASISTENTES_BACKSTAGE){
            backstage[contador_baskstage] = new Backstage(nombre,apellidos,dni,email,fecha_nacimiento);
        }
        else{
            System.out.println("EL BACKSTAGE ESTÁ COMPLETAMENTE LLENO");
        }
    }

    public static double getPrecioBackstage(){
        return PRECIO_BACKSTAGE;
    }
}