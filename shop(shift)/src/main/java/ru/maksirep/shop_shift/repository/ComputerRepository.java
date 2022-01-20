package ru.maksirep.shop_shift.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.maksirep.shop_shift.model.Computer;
import ru.maksirep.shop_shift.factory.HibernateSessionFactory;

import java.util.List;

@Repository
public class ComputerRepository implements TechnicsRepository<Computer> {

    @Override
    public void addPoint(Computer computer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(computer);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void updatePoint(Computer computer, int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        computer.setSerialID(id);
        session.update(computer);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public List<Computer> readPointsByDesc() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List q = session.createQuery("From " + Computer.class.getSimpleName()).list();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return q;
    }

    @Override
    public Computer readPoint(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Computer result = session.get(Computer.class, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }
}
