package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Move;
import org.hibernate.SessionFactory;

public class MoveDao extends EntityDao<Move> {
    public MoveDao(SessionFactory sessionFactory) {
        super(sessionFactory, Move.class);
    }
}
