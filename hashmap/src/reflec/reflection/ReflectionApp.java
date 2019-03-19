package reflec.reflection;

import car.Car;
import car.Engine;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionApp {

    private final static String RED_LINE="    ";

    public static void main(String[] args) {

        Class<?> clazz = Car.class;
        Car car = (Car) createInstance(clazz);

        changeField(car, clazz);
        invokeMethod(car, clazz);
        //printClassName(clazz);
    }

    private static void printClassName(Class<?> clazz){
        String name = clazz.getSimpleName();

        int mod = clazz.getModifiers();

        String modifier = Modifier.toString(mod);

        System.out.println(modifier+" class "+name+"{");
            Field[] fields = clazz.getDeclaredFields();
            printFields(fields);
            Constructor[] constructors = clazz.getDeclaredConstructors();
            printConstructors(constructors);
            Method[] methods = clazz.getDeclaredMethods();
            printMethods(methods);
        System.out.println("}");
    }

    private static void printFields(Field[] fields){
        Arrays.asList(fields).stream().forEach(field -> {
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().getSimpleName();
            String name = field.getName();
            System.out.println(RED_LINE+modifier+" "+type+" "+name);
        });
    }

    private static void printConstructors(Constructor[] constructors){

        Arrays.asList(constructors).stream().forEach(constructor -> {
            String modifier = Modifier.toString(constructor.getModifiers());
            String name = constructor.getName();

            System.out.print(RED_LINE+" "+modifier+ " "+name+"(");
             Parameter[] parameters = constructor.getParameters();
                if (parameters.length > 0) printParameters(parameters);
            System.out.println(");");
        });
    }

    private static void printParameters(Parameter[] parameters){
        final class Counter{
            int count;

            public Counter(int count){
                this.count = count;
            }

            public void setCount(){
                count++;
            }

            public int getCount(){
                return this.count;
            }
        }
        Counter counter = new Counter(0);
        Arrays.asList(parameters).stream().forEach(parameter -> {
            counter.setCount();
            String type = parameter.getType().getSimpleName();
            String name = parameter.getName();
            String delimiter =  (parameters.length>counter.getCount()) ?", " :"";
            System.out.print(type+" "+" "+name+delimiter);
        });
    }

    private static void printMethods(Method[] methods){
        Arrays.asList(methods).stream().forEach(method -> {
            String modifier = Modifier.toString(method.getModifiers());
            String name = method.getName();

            System.out.print(RED_LINE+" "+modifier+ " "+name+"(");
            Parameter[] parameters = method.getParameters();
            if (parameters.length > 0) printParameters(parameters);
            System.out.println(");");
        });
    }

    private static Object createInstance(Class<?> clazz){
        try {
            Constructor constructor =
                    clazz.getDeclaredConstructor(String.class, int.class, Engine.class);
            Car car = (Car) constructor.newInstance("Ford", 4, new Engine());
            return car;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("хз");
    }

    private static void changeField(Car car, Class<?> clazz) {
        try {
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(car,"toyota");
            System.out.println(car);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void invokeMethod(Car car, Class<?> clazz){

        try {
            Method setMethod = clazz.getDeclaredMethod("setName", String.class);
            Method getMethod = clazz.getDeclaredMethod("getName");

            setMethod.invoke(car, "opel");
            System.out.println(getMethod.invoke(car));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
