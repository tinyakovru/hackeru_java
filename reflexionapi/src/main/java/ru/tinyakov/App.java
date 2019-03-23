package ru.tinyakov;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class App {

    private final static String RED_LINE = "    ";
    public static void main(String[] args){

        Class<?> clazz = Car.class;
        printClassName(clazz);

        {
        /*String a = "a";
        Class clazz = a.getClass();

        Class aClazz = String.class;

        try {
            Class aClazz2 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        clazz.getSimpleName();

        int modif = clazz.getModifiers();
        Modifier.toString(modif);
        */
        }
    }

    private static void printFields(Field[] fields){
        Arrays.asList(fields).stream().forEach(field -> {
            String modif = Modifier.toString(field.getModifiers());
            String type = field.getType().getSimpleName();
            String name = field.getName();
            System.out.println(RED_LINE+modif+" "+type+" "+name);
        });
    }

    private static void printConstructor(Constructor[] constructors){
        Arrays.asList(constructors).stream().forEach(constr -> {
            String modif = Modifier.toString(constr.getModifiers());
            //String type = constr.getType().getSimpleName();
            String name = constr.getName();
            System.out.print(RED_LINE+modif+" "+""+name+"(");
            Parameter[] parameters = constr.getParameters();
            if(parameters.length>0)
                printParameters(constr.getParameters());
            System.out.println(")");
        });
    }

    private static void printParameters(Parameter[] parameters) {
        final class Counter{
            int count;

            public Counter(int count){
                this.count = count;
            }

            public void setCount(){
                count++;
            }

            public int getCount() {
                return count;
            }
        }

        Counter counter = new Counter(0);
        Arrays.asList(parameters).stream().forEach(par -> {
            counter.setCount();
            String type = par.getType().getSimpleName();
            String name = par.getName();
                String delimiter = (parameters.length>counter.getCount() )?", ":"";
            System.out.print(type+" "+name+delimiter);

            System.out.println(");");

        });
    }

    private static void printClassName(Class<?> clazz){
        String name = clazz.getSimpleName();

        int mod = clazz.getModifiers();

        String modif = Modifier.toString(mod);

        System.out.print(modif+ " class "+name+"{");
            Field[] fields = clazz.getDeclaredFields();
            printFields(fields);
            Constructor[] constructors = clazz.getDeclaredConstructors();
            printConstructor(constructors);
        System.out.println("}");
    }
}
