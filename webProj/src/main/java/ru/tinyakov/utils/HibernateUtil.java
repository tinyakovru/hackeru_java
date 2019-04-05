package ru.tinyakov.utils;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {


    private SessionFactory factory;
    private static HibernateUtil instance;

    private HibernateUtil() {
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().configure().build();
        try {
            factory =
                    new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        if (instance != null) {
            if (this.factory == null) {
                try {
                    throw new Exception("NO FACTORY in getSessionFactory");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.factory;
        }
        throw new RuntimeException("Session Factory is not created");
    }

}
