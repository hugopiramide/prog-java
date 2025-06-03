package com.liceolapaz.net.hcd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fecha_nacimiento;
    private double salario;
    private int departamento;
    private String dniJefe;

    public Empleado() {
    }
    public Empleado(String dni, String nombre, String apellido1, String apellido2, Date fecha_nacimiento, double salario, int departamento, String dniJefe) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
        this.departamento = departamento;
        this.dniJefe = dniJefe;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
        String fecha = sdf.format(fecha_nacimiento); // Importante

        return "DNI:"+this.dni+"\n"+
                "Nombre:"+this.nombre+"\n"+
                "Primer Apellido:"+this.apellido1+"\n"+
                "Segundo Apellido:"+this.apellido2+"\n"+
                "Fecha de nacimiento:"+fecha+"\n"+
                "Salario :"+this.salario+"\n"+
                "Número de departamento:"+this.departamento+"\n"+
                "DNI Jefe:"+this.dniJefe+"\n";
    }
}
