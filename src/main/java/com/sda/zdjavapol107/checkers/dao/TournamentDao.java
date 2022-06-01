package com.sda.zdjavapol107.checkers.dao;

import com.sda.zdjavapol107.checkers.model.Tournament;
import org.hibernate.SessionFactory;

public class TournamentDao extends EntityDao<Tournament> {
    public TournamentDao(SessionFactory sessionFactory) {
        super(sessionFactory, Tournament.class);
    }
}
