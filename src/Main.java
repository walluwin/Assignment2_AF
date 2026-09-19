public class Main {
    public static void main(String[] args){
        DrinkFactory cocaColaFactory = new CocaColaFactory();
        Drink cocaCola = cocaColaFactory.createDrink();
        Bottle cocaColaBottle = cocaColaFactory.createBottle();

        cocaCola.prepare();
        cocaColaBottle.packageDrink();

        System.out.println("-----------------------------------------------");

        DrinkFactory maxiTeaFactory = new MaxiTeaFactory();
        Drink maxiTea = maxiTeaFactory.createDrink();
        Bottle maxiTeaBottle = maxiTeaFactory.createBottle();

        maxiTea.prepare();
        maxiTeaBottle.packageDrink();
    }
}