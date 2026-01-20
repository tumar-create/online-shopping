package org.example.repository;


import org.example.entity.ClothEntity;
import org.example.entity.PhoneEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClothRepository {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveCloth(ClothEntity clothEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(clothEntity);
            tx.commit();
        }
    }

    public ClothEntity findClothById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ClothEntity.class, id);
        }
    }

    public List<ClothEntity> findAllClothes(){
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM ClothEntity ", ClothEntity.class).list();
        }
    }

    public void deleteCloth(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            ClothEntity entity = session.get(ClothEntity.class, id);

            if(entity != null) {
                session.remove(entity);
            }
            tx.commit();
        }
    }
}