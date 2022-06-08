package com.sda.zdjavapol107.szubienica.service;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.szubienica.repository.dao.HangmanGameDao;
import com.sda.zdjavapol107.szubienica.repository.dao.HangmanSloganDao;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanGame;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanSlogan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

public class GameService {

    private HibernateFactory hibernateFactory = new HibernateFactory();
    private HangmanSloganDao hangmanSloganDao = new HangmanSloganDao(hibernateFactory.getSessionFactory());

    public HibernateFactory getHibernateFactory() {
        return hibernateFactory;
    }

    public GameService() {
    }

    public HangmanSloganDao getHangmanSloganDao() {
        return hangmanSloganDao;
    }

    public HangmanSlogan rollRandomSlogan() {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Random random = new Random();
        HangmanSlogan randomSlogan = session.find(HangmanSlogan.class, random.nextInt(100));
        transaction.commit();

        session.close();
        return randomSlogan;
    }

    public boolean getPlayerGuess(Scanner keyboard, String slogan, List<Character> playerGuesses) {
        System.out.println();
        System.out.println("Podaj literę:");
        String letterGuess = keyboard.nextLine().toUpperCase(Locale.ROOT);
        playerGuesses.add(letterGuess.charAt(0));

        return slogan.contains(letterGuess);
    }

    public boolean printWordState(String slogan, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < slogan.length(); i++) {

            if (playerGuesses.contains(slogan.charAt(i))) {
                System.out.print(slogan.charAt(i));
                correctCount++;
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
        System.out.println();
        return (slogan.length() == correctCount);
    }
}

