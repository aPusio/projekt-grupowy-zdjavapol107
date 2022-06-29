package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GameDao extends EntityDao<Game>{

    public GameDao(SessionFactory sessionFactory) {
        super(sessionFactory, Game.class);
    }

    public List<Game> getGamesByTournamentId(Long tournamentId) {
        Session session = sessionFactory.openSession();
        Query<Game> query = session.createQuery("FROM Game g WHERE g.tournament.id = :id", Game.class);
        Query<Game> idParameter = query.setParameter("id", tournamentId);
        List<Game> gameList = idParameter.getResultList();
        session.close();
        return gameList;
    }

}
