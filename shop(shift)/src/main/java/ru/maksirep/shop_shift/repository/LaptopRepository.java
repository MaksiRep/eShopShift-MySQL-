package ru.maksirep.shop_shift.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.maksirep.shop_shift.factory.HibernateSessionFactory;
import ru.maksirep.shop_shift.model.Laptop;

import java.util.List;

@Repository
public class LaptopRepository implements TechnicsRepository<Laptop> {

    @Override
    public void addPoint(Laptop laptop) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(laptop);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void updatePoint(Laptop laptop, int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        laptop.setSerialID(id);
        session.update(laptop);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public List<Laptop> readPointsByDesc() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List q = session.createQuery("From " + Laptop.class.getSimpleName()).list();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return q;
    }

    @Override
    public Laptop readPoint(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Laptop result = session.get(Laptop.class, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }
}
