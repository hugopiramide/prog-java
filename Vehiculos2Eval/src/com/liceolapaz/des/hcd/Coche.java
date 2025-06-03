package com.liceolapaz.des.hcd;

public class Coche extends Vehiculo{

    private int gasolina = 50;
    private int diesel = 30;
    private int electrico = 5;
    private int hibrido = 15;

    public Coche(String tipo_motor, String matricula, String dni, String fecha_hora) {
        super(tipo_motor, matricula, dni, fecha_hora);
    }

    public String comprobarCoches(){
        return "Diesel : " + diesel + "\n"+
                "Gasolina : "+ gasolina + "\n"+
                "Electrico : "+ electrico + "\n"+
                "Híbrido : "+ hibrido + "\n"+
                "Escoja el tipo de motor : ";
    }

    public int getGasolina() {
        return gasolina;
    }

    public int getDiesel() {
        return diesel;
    }

    public int getElectrico() {
        return electrico;
    }

    public int getHibrido() {
        return hibrido;
    }
}
