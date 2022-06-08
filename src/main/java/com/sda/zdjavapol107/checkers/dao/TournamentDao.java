package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Tournament;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TournamentDao extends EntityDao<Tournament> {
    public TournamentDao(SessionFactory sessionFactory) {
        super(sessionFactory, Tournament.class);
    }

    public Tournament getLastTournament() {
        Session session = sessionFactory.openSession();
        Query<Tournament> query = session.createQuery("From Tournament Order by ID DESC Limit 1", Tournament.class);
        Tournament tournament = query.getSingleResult();
        session.close();
        return tournament;
    }
}



