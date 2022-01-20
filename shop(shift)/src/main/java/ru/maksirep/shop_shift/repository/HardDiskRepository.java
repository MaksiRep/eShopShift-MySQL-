package ru.maksirep.shop_shift.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.maksirep.shop_shift.factory.HibernateSessionFactory;
import ru.maksirep.shop_shift.model.HardDisk;


import java.util.List;

@Repository
public class HardDiskRepository implements TechnicsRepository<HardDisk> {

    @Override
    public void addPoint(HardDisk hardDisk) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(hardDisk);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void updatePoint(HardDisk hardDisk, int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        hardDisk.setSerialID(id);
        session.update(hardDisk);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public List<HardDisk> readPointsByDesc() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List q = session.createQuery("From " + HardDisk.class.getSimpleName()).list();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return q;
    }

    @Override
    public HardDisk readPoint(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        HardDisk result = session.get(HardDisk.class, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }
}
