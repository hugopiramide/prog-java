package com.liceolapaz.des.hcd;

public class Reserva {
    private String tipo_motor;
    private String matricula;
    private String dni;
    private String fecha_hora; // dd/mm/yy
    private boolean disponibilidad;

    public Reserva(String tipo_motor, String matricula, String dni, String fecha_hora) {
        this.tipo_motor = tipo_motor;
        this.matricula = matricula;
        this.dni = dni;
        this.fecha_hora = fecha_hora;

        disponibilidad = false;
    }
}
