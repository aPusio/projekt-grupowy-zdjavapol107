package com.sda.zdjavapol107.szubienica.repository.dao;

import com.sda.zdjavapol107.szubienica.repository.model.HangmanGame;
import org.hibernate.SessionFactory;

public class HangmanGameDao extends HangmanEntityDao<HangmanGame>{

    public HangmanGameDao(SessionFactory sessionFactory) {
        super(sessionFactory, HangmanGame.class);
    }
}
