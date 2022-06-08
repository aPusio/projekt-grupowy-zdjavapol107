package com.sda.zdjavapol107.statki.dao;

import com.sda.zdjavapol107.statki.model.ShipShipsGame;
import org.hibernate.SessionFactory;

public class ShipShipsDao extends EntityDao<ShipShipsGame> {
    public ShipShipsDao(SessionFactory sessionFactory) {
        super(sessionFactory, ShipShipsGame.class);
    }
}
