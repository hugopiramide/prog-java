package com.liceolapaz.net.hcd;

public class Empleado {
    private String dni;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String fecha_nacimiento;
    private double salario;
    private int n_departamento;
    private String dni_jefe;

    public Empleado(String dni, String nombre, String primer_apellido, String segundo_apellido, String fecha_nacimiento, double salario, int n_departamento, String dni_jefe) {
        this.dni = dni;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
        this.n_departamento = n_departamento;
        this.dni_jefe = dni_jefe;
    }

    @Override
    public String toString() {
        return
                "===============\n" +
                "DNI:"+ dni +"\n" +
                "Nombre: "+ nombre +"\n" +
                "Primer Apellido: "+ primer_apellido +"\n" +
                "Segundo Apellido: "+ segundo_apellido +"\n" +
                "Fecha de Nacimiento: "+ fecha_nacimiento +"\n" +
                "Salario: "+ salario + "\n" +
                "Número de Departamento: " + n_departamento +"\n" +
                "DNI Jefe: "+ dni_jefe +"\n" +
                "===============\n";
    }
}
