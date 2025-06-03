package com.liceolapaz.des.hcd;

import java.util.Scanner;

public class Vehiculo {


    private String tipo_motor;
    private String matricula;
    private String dni;
    private String fecha_hora; // dd/mm/yy
    private boolean disponibilidad;

    public Vehiculo(String tipo_motor, String matricula, String dni, String fecha_hora) {
        this.tipo_motor = tipo_motor;
        this.matricula = matricula;
        this.dni = dni;
        this.fecha_hora = fecha_hora;

        disponibilidad = false;
    }

    public static Vehiculo alquilarVehiculo(String tipo_vehiculo, String tipo_motor){
        return new Coche(tipo_motor,"2345","2213456","3435353");
    }
}
