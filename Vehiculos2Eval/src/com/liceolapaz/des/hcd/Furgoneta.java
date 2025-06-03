package com.liceolapaz.des.hcd;

public class Furgoneta extends Vehiculo{

    private int gasolina = 20;

    public Furgoneta(String tipo_motor, String matricula, String dni, String fecha_hora) {
        super(tipo_motor, matricula, dni, fecha_hora);
    }

    public int getGasolina() {
        return gasolina;
    }
}
