public class Jefe extends Empleado{
    private int codigoDepartamento;

    public Jefe(double salario, int edad, String apellido2, String apellido1, String nombre, String dni, int codigoDepartamento) {
        super(salario, edad, apellido2, apellido1, nombre, dni);
        this.codigoDepartamento = codigoDepartamento;
    }
}
