import annotations.Inject;

public class Car {
    private String name;
    private int year;

    @Inject(name = "TurboDiesel")
    private Engine engine;

    public Car(String name, int year, Engine engine) {
        this.name = name;
        this.year = year;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", engine=" + engine +
                '}';
    }
}
