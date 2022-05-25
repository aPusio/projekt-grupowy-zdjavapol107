package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.PlayerEntity;
import org.hibernate.SessionFactory;

public class PlayerDao extends EntityDao<PlayerEntity> {

    public PlayerDao(SessionFactory sessionFactory) {
        super(sessionFactory, PlayerEntity.class);
    }
}
