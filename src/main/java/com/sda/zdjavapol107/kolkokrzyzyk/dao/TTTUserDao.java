package com.sda.zdjavapol107.kolkokrzyzyk.dao;

import com.sda.zdjavapol107.kolkokrzyzyk.model.TTTUser;
import org.hibernate.SessionFactory;

public class TTTUserDao extends TTTEntityDao<TTTUser> {

    public TTTUserDao(SessionFactory sessionFactory) {
        super(sessionFactory, TTTUser.class);
    }
}
