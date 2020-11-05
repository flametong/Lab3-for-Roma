// Класс хищника
public abstract class Predator extends Animal {

    public abstract void hunt();

    public Predator() {
        System.out.println("---Хищник создан---");
    }

    @Override
    public void eat() {
        System.out.println("Хищник ест мясо");
    }
}