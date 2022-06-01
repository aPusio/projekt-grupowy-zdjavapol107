package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.GamePeaces;
import org.hibernate.SessionFactory;

public class GamePeacesDao extends EntityDao<GamePeaces> {
    public GamePeacesDao(SessionFactory sessionFactory) {
        super(sessionFactory, GamePeaces.class);
    }
}
