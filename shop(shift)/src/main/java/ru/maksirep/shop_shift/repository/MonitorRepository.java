package ru.maksirep.shop_shift.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.maksirep.shop_shift.factory.HibernateSessionFactory;
import ru.maksirep.shop_shift.model.Monitor;

import java.util.List;

@Repository
public class MonitorRepository implements TechnicsRepository<Monitor> {

    @Override
    public void addPoint(Monitor monitor) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(monitor);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void updatePoint(Monitor monitor, int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        monitor.setSerialID(id);
        session.update(monitor);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public List<Monitor> readPointsByDesc() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List q = session.createQuery("From " + Monitor.class.getSimpleName()).list();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return q;
    }

    @Override
    public Monitor readPoint(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Monitor result = session.get(Monitor.class, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }
}
