package com.sda.zdjavapol107.kolkokrzyzyk.dao;

import com.sda.zdjavapol107.kolkokrzyzyk.model.TTTMove;
import org.hibernate.SessionFactory;

public class TTTMoveDao extends TTTEntityDao<TTTMove>{

    public TTTMoveDao(SessionFactory sessionFactory) {
        super(sessionFactory, TTTMove.class);
    }
}
