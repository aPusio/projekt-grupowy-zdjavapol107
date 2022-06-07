package com.sda.zdjavapol107.statki.dao;

import com.sda.zdjavapol107.statki.model.GameHistoryShips;
import org.hibernate.SessionFactory;

public class GameHistoryShipsDao extends EntityDao<GameHistoryShips> {
    public GameHistoryShipsDao(SessionFactory sessionFactory) {
        super(sessionFactory, GameHistoryShips.class);
    }
}
