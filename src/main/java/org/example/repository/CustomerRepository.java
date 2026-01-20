package org.example.repository;


import org.example.entity.CustomerEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveCustomer(CustomerEntity customerEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(customerEntity);
            tx.commit();
        }
    }


    public CustomerEntity findCustomerById(Integer id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(CustomerEntity.class, id);
        }
    }

    public List<CustomerEntity> findAllCustomers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM CustomerEntity ", CustomerEntity.class).list();
        }
    }

    public void deleteCustomer(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            CustomerEntity customerEntity = session.get(CustomerEntity.class, id);

            if(customerEntity != null) {
                session.remove(customerEntity);
            }
            tx.commit();
        }
    }
}