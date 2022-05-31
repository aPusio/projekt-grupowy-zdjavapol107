package com.sda.zdjavapol107.szubienica.repository.dao;

import com.sda.zdjavapol107.szubienica.repository.model.HangmanSlogan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HangmanSloganDao extends HangmanEntityDao<HangmanSlogan> {


    public HangmanSloganDao(SessionFactory sessionFactory) {
        super(sessionFactory, HangmanSlogan.class);
    }


    public List getAllSlogans() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<HangmanSlogan> result = session.createQuery("FROM HangmanSlogan", HangmanSlogan.class).getResultList();
        transaction.commit();
        session.close();

        return result;
    }
}


