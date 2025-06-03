import java.util.Scanner;

public class Gestor {

    private final static Scanner sc = new Scanner(System.in);
    private static Reserva[] reservas = new Reserva[1000];

    public static void main(String[] args) {
        while (true){
            menu();
            int opcionMenu = sc.nextInt();
            switch (opcionMenu){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    reservarHabitacion();
                    break;
                case 2:
                    System.out.println("hola mundo");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.print("ERROR, El menú no tiene esa opción, vuelva a escoger");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.print("HOTEL HUGO\n" +
                "1. Reservar Habitación\n" +
                "2. Buscar tu Habitación\n" +
                "3. Habitaciones Disponibles\n" +
                "4. Habitaciones NoDisponibles\n" +
                "Escoja una opción: ");
    }

    private static void reservarHabitacion(){
        System.out.print("RESERVA DE HABITACIÓN\n" +
                "1. HabitacionEstandar\n" +
                "2. HabitacionPremium\n" +
                "Escoja una opción: ");
        int opcionMenu = sc.nextInt();
        switch (opcionMenu){
            case 1:
                Habitacion.reservarHabitacionEstandar();
                break;
            case 2:
                break;
            default:
                System.out.println("Opcion introducida no valida");
                break;
        }
    }
}
