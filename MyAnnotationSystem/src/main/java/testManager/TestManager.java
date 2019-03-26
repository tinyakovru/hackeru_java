package testManager;

import annotations.AfterSuit;
import annotations.BeforSuit;
import annotations.Test;
import tests.Calculator;
import tests.CalculatorTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestManager {
    private static Class clazz;
    static AbstractTest testIns;

    public static void main(String[] args) {

        // здесь вбивается ссылка на класс, который тестируем,
        // лучше организовать ввод из консоли или из параметров при запуске программы
        clazz = CalculatorTest.class;

        createTestInstance();
        testIns.start(Calculator.class);

        invokeAnnotationMethod(BeforSuit.class);

        invokeTestMethodts();

        invokeAnnotationMethod(AfterSuit.class);

    }

    private static void createTestInstance() {
        try {
            testIns = (AbstractTest)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void invokeAnnotationMethod(Class annotationClass) {
        Method[] mtd = clazz.getDeclaredMethods();
        int count = 0;
        Method meth = null;
        for (Method m : mtd) {
            if(m.isAnnotationPresent(annotationClass)){
                meth = m;
                count++;
            }
        }
        if(count==0){
            return;
        }else if(count>1){
            throw new RuntimeException("There are should be once "+annotationClass.getSimpleName()+" method");
        }else{
            try {
                meth.setAccessible(true);
                meth.invoke(testIns);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static void invokeTestMethodts() {
        Method[] mths = clazz.getDeclaredMethods();
        ArrayList<PriorMethod> methods = new ArrayList<>();
        for (Method m : mths){
            if(m.isAnnotationPresent(Test.class)){
                Test testAnn = m.getAnnotation(Test.class);
                int prior = testAnn.prior();
                methods.add(new PriorMethod(m,prior));
            }
        }
        methods.sort(PriorMethod::compareTo);
        methods.stream().forEach(pm -> {
            try {
                pm.getMethod().setAccessible(true);
                pm.getMethod().invoke(testIns);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}

class PriorMethod implements Comparable{
    private Method method;
    private int prior;

    public PriorMethod(Method m, int prior) {
        this.method = m;
        this.prior = prior;
    }

    public Method getMethod() {
        return method;
    }

    public int getPrior() {
        return prior;
    }

    @Override
    public int compareTo(Object o) {
        PriorMethod pm = (PriorMethod)o;

        if(prior>pm.getPrior())return 1;
        if(prior<pm.getPrior())return -1;

        return 0;
    }
}


