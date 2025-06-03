package com.liceolapaz.des.hcd;

public class Grada extends Asistente{
    private final static int MAX_ASISTENTES_GRADA = 25000;
    private final static double PRECIO_GRADA = 89.99;
    private static Grada[][] grada = new Grada[25][1000]; //25 filas de 1000 asientos
    private static int contador_asistentes_grada = 0;
    public Grada(String nombre, String apellidos, String dni, String email, String fecha_nacimiento) {
        super(nombre, apellidos, dni, email, fecha_nacimiento);

        contador_asistentes_grada++;
        Asistente.entrada_ID++;
    }
    protected static void reservarEntrada(String nombre, String apellidos, String dni, String email, String fecha_nacimiento,int fila,int asiento){
        if(contador_asistentes_grada < MAX_ASISTENTES_GRADA){
            if(grada[fila][asiento] == null){
                grada[fila][asiento] = new Grada(nombre,apellidos,dni,email,fecha_nacimiento);
            }
            else{
                System.out.println("LA FILA O ASIENTO ESTÁ OCUPADA/O");
            }
        }
        else{
            System.out.println("LA GRADA ESTÁ COMPLETAMENTE LLENA");
        }
    }
    public static int getContador_asistentes_grada() {
        return contador_asistentes_grada;
    }
    public static double getPrecio_grada(){
        return PRECIO_GRADA;
    }
}