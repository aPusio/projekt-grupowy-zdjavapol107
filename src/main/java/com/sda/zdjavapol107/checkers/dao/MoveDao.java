package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Move;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MoveDao extends EntityDao<Move> {
    public MoveDao(SessionFactory sessionFactory) {
        super(sessionFactory, Move.class);
    }

    public List<Move> getMovesByGameId (Long gameId) {
        Session session = sessionFactory.openSession();
        Query<Move> query = session.createQuery("FROM Move m WHERE m.game.id = :idParameter", Move.class);
        Query<Move> idParameter = query.setParameter("idParameter", gameId);
        List<Move> moveList = idParameter.getResultList();
        session.close();
        return moveList;
    }
}
