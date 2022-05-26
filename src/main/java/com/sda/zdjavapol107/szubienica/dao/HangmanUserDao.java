package com.sda.zdjavapol107.szubienica.dao;

import com.sda.zdjavapol107.szubienica.model.HangmanUser;
import org.hibernate.SessionFactory;

public class HangmanUserDao extends HangmanEntityDao<HangmanUser> {

    public HangmanUserDao(SessionFactory sessionFactory){
        super(sessionFactory, HangmanUser.class);
    }
}
