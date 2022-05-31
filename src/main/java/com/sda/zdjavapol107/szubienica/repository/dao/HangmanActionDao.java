package com.sda.zdjavapol107.szubienica.repository.dao;

import com.sda.zdjavapol107.szubienica.repository.model.HangmanAction;
import org.hibernate.SessionFactory;

public class HangmanActionDao extends HangmanEntityDao<HangmanAction> {
    public HangmanActionDao(SessionFactory sessionFactory) {
        super(sessionFactory, HangmanAction.class);
    }
}
