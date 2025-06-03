package com.liceolapaz.net.hcd;

public class Racional implements Numero{
    private int numerador;
    private int denominador;

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }
    @Override
    public Numero suma(Numero operando){
        Numero resultado = null;
        if (operando instanceof Racional){
            Racional op = (Racional) operando;
            int num = this.numerador*op.denominador+this.denominador*op.numerador;
            int den = this.denominador*op.denominador;
            resultado = new Racional(num,den);
        }
        else{
            System.out.println("Solamente se pueden restar números enteros");
        }
        return resultado;
    }

    @Override
    public Numero resta(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Racional){
            Racional op = (Racional) operando;
            int num = this.numerador*op.denominador-this.denominador*op.numerador;
            int den = this.denominador*op.denominador;
            resultado = new Racional(num,den);
        }
        else{
            System.out.println("Solamente se pueden restar números enteros");
        }
        return resultado;
    }

    @Override
    public Numero producto(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Racional){
            Racional op = (Racional) operando;
            int num = this.numerador*op.numerador;
            int den = this.denominador*op.denominador;
            resultado = new Racional(num,den);
        }
        else{
            System.out.println("Solamente se pueden restar números enteros");
        }
        return resultado;
    }

    @Override
    public Numero division(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Racional){
            Racional op = (Racional) operando;
            int num = this.numerador*op.denominador;
            int den = this.denominador*op.numerador;
            resultado = new Racional(num,den);
        }
        else{
            System.out.println("Solamente se pueden restar números enteros");
        }
        return resultado;
    }

    @Override
    public String mostrar() {
        return "El valor del numerador es --> " + numerador +
                "\n El valor del denominador es --> " + denominador +"\n" ;
    }
}
