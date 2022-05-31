package com.sda.zdjavapol107.statki.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class EntityDao<T> {
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    public int save(T input) {
        Session session = sessionFactory.openSession();
        int save = 0;
        if (input != null) {
            save = (int) session.save(input);
        } else {
            System.out.println("Obiekt nie może być pusty!");
        }
        session.close();
        return save;
    }

    public Optional<T> getById(Long id) {
        Session session = sessionFactory.openSession();
        T entity = session.find(clazz, id);
        session.close();
        return Optional.ofNullable(entity);
    }

    public void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        getById(id).ifPresent(entity -> session.delete(entity));
        transaction.commit();
        session.close();
    }

    public void remove(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.remove(entity);
        } catch (IllegalArgumentException e) {
            System.err.println("Obiek nie może być nullem!");
        }
        transaction.commit();
        session.close();
    }

    public List<T> getAllRecords(T entity) {
        Session session = sessionFactory.openSession();
        List<T> result = session.createQuery("From :parameter", clazz)
                .setParameter("parameter", entity)
                .getResultList();
        session.close();
        return result;

//        Session session2 = HibernateUtil.getHibernateSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
//        Root<Item> root = cr.from(Item.class);
//        cr.select(root);
//        Query<Item> query = session.createQuery(cr);
//        List<Item> results = query.getResultList();
//        Item.class <- swoja klasa jak w get
    }

}
