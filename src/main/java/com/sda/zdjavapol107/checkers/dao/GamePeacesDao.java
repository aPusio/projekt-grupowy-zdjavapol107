package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.GamePeaces;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GamePeacesDao extends EntityDao<GamePeaces> {
    public GamePeacesDao(SessionFactory sessionFactory) {
        super(sessionFactory, GamePeaces.class);
    }

    public List<GamePeaces> getGamePeacesByGameId(Long gameId) {
        Session session = sessionFactory.openSession();
        Query<GamePeaces> query = session.createQuery("FROM GamePeaces gp WHERE gp.game.id = :idParameter", GamePeaces.class);
        Query<GamePeaces> idParameter = query.setParameter("idParameter", gameId);
        List<GamePeaces> gamePeacesList = idParameter.getResultList();
        session.close();
        return gamePeacesList;
    }


}
