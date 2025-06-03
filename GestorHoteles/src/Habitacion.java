import java.util.Scanner;

public class Habitacion {

    private static final int MAX_RESERVA_HABITACION_ESTANDAR = 600;
    private static final int MAX_RESERVA_HABITACION_PREMIUM = 400;

    private static HabitacionEstandar[] habitacionesEstandar = new HabitacionEstandar[MAX_RESERVA_HABITACION_ESTANDAR];
    private static HabitacionEstandar[] habitacionesPremium = new HabitacionEstandar[MAX_RESERVA_HABITACION_PREMIUM];

    private final static Scanner sc = new Scanner(System.in);
    private int numero;
    private int capacidad;
    private double precioPorNoche;
    private boolean disponible;
    private static int contador_habitaciones_estandar = 0;
    private static int contador_habitaciones_premium = 0;

    public Habitacion(int numero, int capacidad, double precioPorNoche) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
    }

    public static void reservarHabitacionEstandar(){
        if (contador_habitaciones_estandar > MAX_RESERVA_HABITACION_ESTANDAR){
            System.out.print("Número maximo de Huespedes alcanzado");
            return;
        }
        System.out.print("Quieres desayuno completo?\n" +
                "1. Si\n" +
                "2. No\n" +
                "Escoja una opción: ");
        if (sc.nextInt() == 1){
            boolean desayunoCompleto = true;
        }
        Reserva reserva = solicitarDatosUsuario();
        habitacionesEstandar[contador_habitaciones_estandar] = new Reserva(reserva.getNombre(),2,2.3,true);
    }

    private static Reserva solicitarDatosUsuario(){
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.println("Apellidos");
        String apellidos = sc.next();
        System.out.println("DNI: ");
        String dni = sc.next();
        System.out.println("Email: ");
        String email = sc.next();

        return new Reserva(nombre,apellidos,dni,email);
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
