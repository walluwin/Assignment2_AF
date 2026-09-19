public class MaxiTeaFactory implements DrinkFactory {
    @Override
    public Drink createDrink() {
        return new MaxiTeaDrink();
    }
    @Override
    public Bottle createBottle() {
        return new MaxiTeaBottle();
    }
}