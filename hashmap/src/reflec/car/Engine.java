package reflec.car;

import annotations.About;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

public class Engine {

    private final static Logger LOGGER = Logger.getLogger(Engine.class.getSimpleName());

    public static void main(String[] args) {
        Class<?> clazz = Engine.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method m:methods) {
            if(m.isAnnotationPresent(About.class)){
                About about = m.getAnnotation(About.class);
                LOGGER.info(m.getName()+" "+about.info());
                //System.out.println(m.getName()+" "+about.info());
            }
        }


        Arrays.asList(methods).stream()
                .filter(method -> method.isAnnotationPresent(About.class))
                .forEach(method -> {
                    About about = method.getAnnotation(About.class);
                    //System.out.println(method.getName()+" "+about.info());

                    try {
                        Constructor constructor =
                                clazz.getDeclaredConstructor(String.class, float.class);
                        Engine engine =
                                (Engine) constructor.newInstance("Engine",1.5f);
                        System.out.println(method.invoke(engine));
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                });


    }

    private String VIN;
    private float volume;

    public Engine(String VIN, float volume) {
        this.VIN = VIN;
        this.volume = volume;
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

    public void startEngine(String turnOn, int max, float... args){}

    private boolean setFuel(String fuel){
        return true;
    }
}
