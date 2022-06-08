package com.sda.zdjavapol107.kolkokrzyzyk.dao;

import com.sda.zdjavapol107.kolkokrzyzyk.model.TTTGame;
import org.hibernate.SessionFactory;

public class TTTGameDao extends TTTEntityDao<TTTGame> {

    public TTTGameDao(SessionFactory sessionFactory) {
        super(sessionFactory, TTTGame.class);
    }
}
