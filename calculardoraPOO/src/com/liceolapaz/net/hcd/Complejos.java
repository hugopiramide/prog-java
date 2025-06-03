package com.liceolapaz.net.hcd;

import java.sql.SQLOutput;

public class Complejos implements Numero{

    private int valor1;
    private int valor2;

    public Complejos(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    @Override
    public Numero suma(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Numero) {
            Complejos op = (Complejos) operando;
            int op1 = this.valor1 + op.valor1;
            int op2 = op.valor2 + op.valor2;
            resultado = new Complejos(op1,op2);
        }else{
            System.out.println("Solamente se pueden sumar números complejos");
        }
        return resultado;
    }

    @Override
    public Numero resta(Numero operando) {
        return null;
    }

    @Override
    public Numero producto(Numero operando) {
        return null;
    }

    @Override
    public Numero division(Numero operando) {
        return null;
    }

    @Override
    public String mostrar() {
        return valor1 +" + "+ valor2+"i";
    }
}
