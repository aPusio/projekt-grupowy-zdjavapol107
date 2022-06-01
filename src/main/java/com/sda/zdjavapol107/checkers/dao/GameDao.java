package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Game;
import org.hibernate.SessionFactory;

public class GameDao extends EntityDao<Game>{

    public GameDao(SessionFactory sessionFactory) {
        super(sessionFactory, Game.class);
    }
}
