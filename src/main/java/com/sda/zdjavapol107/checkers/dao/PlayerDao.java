package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Player;
import org.hibernate.SessionFactory;

public class PlayerDao extends EntityDao<Player> {

    public PlayerDao(SessionFactory sessionFactory) {
        super(sessionFactory, Player.class);
    }
}
