package com.sda.zdjavapol107.statki.dao;

import com.sda.zdjavapol107.statki.model.BoardShipsGame;
import org.hibernate.SessionFactory;

public class BoardShipsDao extends EntityDao<BoardShipsGame> {

    public BoardShipsDao(SessionFactory sessionFactory) {
        super(sessionFactory, BoardShipsGame.class);
    }
}
