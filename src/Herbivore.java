// Класс травоядного
public abstract class Herbivore extends Animal {

    public abstract void collectPlants();

    public Herbivore() {
        System.out.println("---Травоядное создано---");
    }

    @Override
    public void eat() {
        System.out.println("Травоядное ест траву");
    }
}