package com.sda.zdjavapol107.statki.dao;

import com.sda.zdjavapol107.statki.model.PointShipsGame;
import org.hibernate.SessionFactory;

public class PointShipsDao extends EntityDao<PointShipsGame>{
    public PointShipsDao(SessionFactory sessionFactory) {
        super(sessionFactory, PointShipsGame.class);
    }
}
