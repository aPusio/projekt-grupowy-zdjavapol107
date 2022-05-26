package com.sda.zdjavapol107.szubienica.dao;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

@AllArgsConstructor
public abstract class EntityDao <T>{

    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    public void save(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
    }
    //TODO zminić nazwe
    public Optional<T> getById(Long id){
        Session session = sessionFactory.openSession();
        //TODO bedziemy szukac po nazwie
        T entity = session.find(clazz, id);
        session.close();
        return Optional.ofNullable(entity);
    }

    public void update(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();
    }

//    public void delete(Long id){
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        getById(id).ifPresent(session::remove);
//        transaction.commit();
//        session.close();
//    }
}
