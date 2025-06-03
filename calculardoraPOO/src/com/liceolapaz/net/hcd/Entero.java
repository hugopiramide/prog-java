package com.liceolapaz.net.hcd;

public class Entero implements Numero{

    private int valor;
    public Entero(int valor) {
        this.valor = valor;
    }

    @Override
    public Numero suma(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Entero){
            Entero op = (Entero) operando;
            int nuevoValor = this.valor + op.valor;
            resultado = new Entero(nuevoValor);
        }
        else{
            System.out.println("Solamente se pueden sumar numeros enteros");
        }
        return resultado;
    }

    @Override
    public Numero resta(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Entero){
            Entero op = (Entero) operando;
            int nuevoValor = this.valor - op.valor;
            resultado = new Entero(nuevoValor);
        }
        else{
            System.out.println("Solamente se pueden restar numeros enteros");
        }
        return resultado;
    }

    @Override
    public Numero producto(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Entero){
            Entero op = (Entero) operando;
            int nuevoValor = this.valor % op.valor;
            resultado = new Entero(nuevoValor);
        }
        else{
            System.out.println("Solamente se pueden utilizar numeros enteros");
        }
        return resultado;
    }

    @Override
    public Numero division(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Entero){
            Entero op = (Entero) operando;
            if (op.valor == 0){
                System.out.println("Solamente se pueden dividir números enteros");
            }
            int nuevoValor = this.valor / op.valor;
            resultado = new Entero(nuevoValor);
        }
        else{
            System.out.println("Solamente se pueden dividir numeros enteros");
        }
        return resultado;
    }

    @Override
    public String mostrar() {
        return "" + this.valor;
    }
}
