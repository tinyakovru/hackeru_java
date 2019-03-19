package reflec.car;

public class Car {

    private String name;
    private int speed;
    private Engine engine;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", engine=" + engine +
                '}';
    }

    public Car(String name, int speed, Engine engine) {
        this.name = name;
        this.speed = speed;
        this.engine = engine;
    }

    private Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
