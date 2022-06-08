package com.sda.zdjavapol107.statki.dao;

import com.sda.zdjavapol107.statki.model.UserShipsGame;
import org.hibernate.SessionFactory;

public class UserShipsDao extends EntityDao<UserShipsGame> {
    public UserShipsDao(SessionFactory sessionFactory) {
        super(sessionFactory, UserShipsGame.class);
    }
}
