package com.liceolapaz.des.hcd;

public class Moto extends Vehiculo{

    private int gasolina = 35;
    private int electrico = 15;

    public Moto(String tipo_motor, String matricula, String dni, String fecha_hora) {
        super(tipo_motor, matricula, dni, fecha_hora);
    }

    public int getGasolina() {
        return gasolina;
    }

    public int getElectrico() {
        return electrico;
    }
}
