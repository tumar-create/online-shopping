package org.example.repository;

import org.example.model.Customer;
import org.example.model.Item;
import org.example.model.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StoreRepository {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }


    public void saveItem(Item item) {
        try(Session session = sessionFactory.openSession()){
            Transaction t = session.beginTransaction();
            session.persist(item);
            t.commit();
        }
    }

    public void saveCustomer(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(customer);
            tx.commit();
        }
    }

    public void saveOrder(Order order) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(order);
            tx.commit();
        }
    }

    public List<Item> getAllItems() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Item", Item.class).list();
        }
    }

    public Item findItemById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Item.class, id);
        }
    }

    public void deleteItem(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.remove(item);
            }
            tx.commit();
        }
    }


}