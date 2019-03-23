package testManager;

import org.omg.CORBA.Object;

public class AbstractTest {

    protected static Class clazz;

    public static void start(Class<?> clazz){
        AbstractTest.clazz = clazz;
    }

}
