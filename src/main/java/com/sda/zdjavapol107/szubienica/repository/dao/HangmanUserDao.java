package com.sda.zdjavapol107.szubienica.repository.dao;

import com.sda.zdjavapol107.szubienica.repository.model.HangmanUser;
import org.hibernate.SessionFactory;

public class HangmanUserDao extends HangmanEntityDao<HangmanUser> {
    public HangmanUserDao(SessionFactory sessionFactory) {
        super(sessionFactory, HangmanUser.class);
    }
}
