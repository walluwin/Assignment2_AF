public class CocaColaFactory implements DrinkFactory {
    @Override
    public Drink createDrink() {
        return new CocaColaDrink();
    }
    @Override
    public Bottle createBottle() {
        return new CocaColaBottle();
    }
}