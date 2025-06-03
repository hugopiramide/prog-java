public class Reserva {
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private int id_reserva;
    private Habitacion habitacion;

    public Reserva(String nombre, String apellidos, String dni, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }
}
