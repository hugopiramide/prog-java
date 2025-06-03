public class HabitacionPremium extends Habitacion{

    private boolean suit;
    private boolean yacuzzi;

    public HabitacionPremium(int numero, int capacidad, double precioPorNoche,boolean suit,boolean yacuzzi) {
        super(numero, capacidad, precioPorNoche);
        this.suit = suit;
        this.yacuzzi = yacuzzi;
    }
}
