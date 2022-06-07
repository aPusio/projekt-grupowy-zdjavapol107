package com.sda.zdjavapol107.kolkokrzyzyk.dao;

import com.sda.zdjavapol107.kolkokrzyzyk.model.TTTMatch;
import org.hibernate.SessionFactory;

public class TTTMatchDao extends TTTEntityDao<TTTMatch> {

    public TTTMatchDao(SessionFactory sessionFactory) {
        super(sessionFactory, TTTMatch.class);
    }
}
