package com.liceolapaz.net.hcd;

public class Departament {
    private int num_dpto;
    private String nombre;
    private String nombre_corto;
    private int planta;
    private String cif_director;
    private String correo_e;

    public Departament(int num_dpto,String nombre, String nombre_corto, int planta, String cif_director, String correo_e) {
        this.num_dpto = num_dpto;
        this.nombre = nombre;
        this.nombre_corto = nombre_corto;
        this.planta = planta;
        this.cif_director = cif_director;
        this.correo_e = correo_e;
    }

    public String toString(){
        return num_dpto + ";" + nombre + ";" + nombre_corto + ";" + planta + ";" + cif_director + ";" + correo_e;
    }
}
