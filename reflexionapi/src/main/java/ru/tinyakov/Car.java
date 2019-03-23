package ru.tinyakov;


public class Car {
    private String name;
    private int speed;
    private Engine engine;

    public Car(){}

    public Car(String name, int speed, Engine engine) {
        this.name = name;
        this.speed = speed;
        this.engine = engine;
    }

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public Car(String name) {
        this.name = name;
    }

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
