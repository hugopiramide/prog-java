public class HabitacionEstandar extends Habitacion{

    private boolean desayuno_completo;

    public HabitacionEstandar(int numero, int capacidad, double precioPorNoche, boolean desayuno_completo) {
        super(numero, capacidad, precioPorNoche);
        this.desayuno_completo = desayuno_completo;
    }
}