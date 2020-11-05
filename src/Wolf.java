import java.util.Objects;

// Класс волка
public class Wolf extends Predator implements Speakable {

    private final String name;
    private final int age;
    private final String gender;
    private String coatColor;

    public Wolf(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Пример перегрузки конструктора
    public Wolf(String name, int age, String gender, String coatColor) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.coatColor = coatColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wolf)) return false;
        Wolf wolf = (Wolf) o;

        if (coatColor == null) {
            return age == wolf.age &&
                    name.equals(wolf.name) &&
                    gender.equals(wolf.gender);
        }

        return age == wolf.age &&
                name.equals(wolf.name) &&
                gender.equals(wolf.gender) &&
                coatColor.equals(wolf.coatColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, coatColor);
    }

    @Override
    public String toString() {
        if (coatColor == null) {
            return "Wolf{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }

        return "Wolf{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", coatColor='" + coatColor + '\'' +
                '}';
    }

    @Override
    public void hunt() {
        System.out.println(name + " выходит на охоту");
    }

    @Override
    public void makeNoise() {
        System.out.println(name + " издаёт звуки волка");
    }
}