package org.example.repository;


import org.example.entity.CustomerEntity;
import org.example.entity.PhoneEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneRepository {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePhone(PhoneEntity phoneEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(phoneEntity);
            tx.commit();
        }
    }

    public PhoneEntity findPhoneById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(PhoneEntity.class, id);
        }
    }

    public List<PhoneEntity> findAllPhones(){
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM PhoneEntity ", PhoneEntity.class).list();
        }
    }

    public void deletePhone(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            PhoneEntity entity = session.get(PhoneEntity.class, id);

            if(entity != null) {
                session.remove(entity);
            }
            tx.commit();
        }
    }
}