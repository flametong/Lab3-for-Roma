import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Actions actions = new Actions();

        actions.demonstrateEquality();
        actions.demonstrateElephant();
        actions.demonstratePolymorphism();
        actions.demonstrateSerialization();
    }
}

// Класс действий для демонстрации
class Actions {

    public void demonstrateEquality() {

        Wolf wolf1 = new Wolf("Victor", 5, "male");
        Wolf wolf2 = new Wolf("Victor", 5, "male");
        Wolf wolf3 = new Wolf("Artem", 10, "male", "grey");

        // Проверка на равенство двух экземпляров одного класса
        System.out.println("Equality of Victor and another Victor: " + wolf1.equals(wolf2));
        System.out.println("Equality of Artem and Victor: " + wolf3.equals(wolf2));

        System.out.println("---------------------");
    }

    public void demonstrateElephant() {

        Elephant elephant = new Elephant("Masha", 10, "female");
        elephant.makeNoise();
        elephant.eat();

        System.out.println("---------------------");

        // Демонстрация метода toString()
        System.out.println(elephant);

        System.out.println("---------------------");

        // До изменения статического поля isTamed
        elephant.collectPlants();

        Elephant.isTamed = true;

        // После изменения статического поля isTamed
        elephant.collectPlants();

        System.out.println("---------------------");
    }

    public void demonstratePolymorphism() {

        List<Animal> animals = Arrays.asList(
                new Elephant("Anna", 7, "female"),
                new Wolf("Alexey", 12, "male"));

        for (Animal animal : animals) {
            // Полиформорфный вызов метода
            animal.eat();
        }
        System.out.println("---------------------");
    }

    public void demonstrateSerialization() {

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("animal.dat"))) {

            Elephant elephant = new Elephant("Roma", 19, "male");
            oos.writeObject(elephant);
            System.out.println("---Сериализация успешно завершена---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("animal.dat"))) {

            Elephant elephant = (Elephant) ois.readObject();

            System.out.printf(
                    "Name: %s \n Age: %d \n Gender: %s \n",
                    elephant.getName(),
                    elephant.getAge(),
                    elephant.getGender());

            System.out.println("---Десериализация успешно завершена---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}