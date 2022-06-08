package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PlayerDao extends EntityDao<Player> {

    public PlayerDao(SessionFactory sessionFactory) {
        super(sessionFactory, Player.class);
    }

    public List<Player> getPlayersByGameId (Long tournamentId) {
        Session session = sessionFactory.openSession();
        Query<Player> query = session.createQuery("FROM Player p WHERE p.tournament.id = :idParameter", Player.class);
        Query<Player> idParameter = query.setParameter("idParameter", tournamentId);
        List<Player> playerList = idParameter.getResultList();
        session.close();
        return playerList;
    }
}
