package ru.tinyakov;

import ru.tinyakov.annotations.About;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

public class Engine {

    private final static Logger LOGGER = Logger.getLogger(Engine.class.getSimpleName());

    private String VIN;
    private float volume;

    public static void main(String[] args){
        Class<?> clazz = Engine.class;
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.asList(methods).stream()
                .filter(method -> method.isAnnotationPresent(About.class))
                .forEach(method -> {
                    About about = method.getAnnotation(About.class);
                    System.out.println(method.getName()+"  "+about.info());

                    LOGGER.info(method.getName()+ "  "+about.info());
                });
    }

    public Engine(String VIN) {
        this.VIN = VIN;
    }

    public Engine(){}

    @About
    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @About(info = "this is volume")
    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void startEngine(String turnOn, int max, float... args){

    }

    private boolean setFuel(String fuel){
        return true;
    }
}
