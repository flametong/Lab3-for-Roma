import java.io.Serializable;
import java.util.Objects;

// Класс слона
public class Elephant extends Herbivore implements Speakable, Serializable {

    private final String name;
    private final int age;
    private final String gender;
    // Пример статичного поля
    public static boolean isTamed = false;

    public Elephant(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elephant)) return false;
        Elephant elephant = (Elephant) o;
        return age == elephant.age &&
                name.equals(elephant.name) &&
                gender.equals(elephant.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public void collectPlants() {
        if (!isTamed) System.out.println(name + " собирает растения в дикой природе");
        else System.out.println(name + " собирает растения в зоопарке");
    }

    @Override
    public void makeNoise() {
        System.out.println(name + " издаёт звуки слона");
    }
}