public class Empleado {
    protected String dni;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected int edad;
    protected double salario;

    public Empleado(double salario, int edad, String apellido2, String apellido1, String nombre, String dni) {
        this.salario = salario;
        this.edad = edad;
        this.apellido2 = apellido2;
        this.apellido1 = apellido1;
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double calcularSalarioNeto(){
        return getSalario();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
