import annotations.Inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Arrays;

public class AppInject {

    public static void main(String[] args) {
        Car car = null;

        Class clazz = Car.class;
        try {
            Constructor constructor = clazz.getConstructor(String.class, int.class, Engine.class);

            Field[] fields = clazz.getDeclaredFields();
            String engName = "";
            for (Field f : fields) {
                if (f.isAnnotationPresent(Inject.class)) {
                    engName = f.getAnnotation(Inject.class).name();
                    break;
                }
            }
            Engine eng = null;
            eng = Engine.class.getConstructor(String.class).newInstance(engName);
            car = (Car)constructor.newInstance("Volvo",2019,eng);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(car.toString());
    }
}
