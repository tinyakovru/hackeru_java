package ru.tinyakov.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.tinyakov.entity.Car;
import ru.tinyakov.utils.HibernateUtil;

import java.util.List;

@Component
public class HBMCarRepository implements IRepository<Car> {

    @Override
    public Car get(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Car category = session.get(Car.class, id);
        session.getTransaction().commit();
        return category;
    }

    @Override
    public List<Car> get() {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        List<Car> list =  session.createQuery( "from Car" ).list();
        session.getTransaction().commit();
        return list;
    }



    @Override
    public boolean insert(Car item) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            session.save(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Car item) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            session.saveOrUpdate(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            Car item = session.get(Car.class, id);
            session.delete(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
