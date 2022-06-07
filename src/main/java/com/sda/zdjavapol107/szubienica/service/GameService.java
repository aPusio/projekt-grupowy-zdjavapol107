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

    public void setHangmanSloganDao(HangmanSloganDao hangmanSloganDao) {
        this.hangmanSloganDao = hangmanSloganDao;
    }

    public String rollRandomSlogan() {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Random random = new Random();
        HangmanSlogan randomSlogan = session.find(HangmanSlogan.class, random.nextInt(100));
        transaction.commit();

        session.close();
        return randomSlogan.getName();

    }

    private static boolean getPlayerGuess(Scanner keyboard, String slogan, List<Character> playerGuesses) {
        System.out.println();
        System.out.println("Podaj literę:");
        String letterGuess = keyboard.nextLine().toUpperCase(Locale.ROOT);
        playerGuesses.add(letterGuess.charAt(0));

        return slogan.contains(letterGuess);
    }


    private static boolean printWordState(String slogan, List<Character> playerGuesses) {
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


    public static void main(String[] args) {

        int wrongCount = 0;
        int gamePoints = 0;
        Scanner keyboard = new Scanner(System.in);
        List<Character> playerGuesses = new ArrayList<>();
        GameService gameService = new GameService();


        String slogan = gameService.rollRandomSlogan();
        System.out.println(slogan);


        boolean exit = false;

        while (!exit) {

            if (gamePoints == 3) {
                break;
            }

            if (wrongCount > 7) {
                gamePoints++;
                wrongCount = 0;
            }

            if(wrongCount == 0) {
                System.out.println("  |-----------");
                System.out.println("  | /");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            else if(wrongCount == 1) {
                System.out.println("  |-----------");
                System.out.println("  | /        |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            else if(wrongCount == 2) {
                System.out.println("  |-----------");
                System.out.println("  | /        |");
                System.out.println("  |          |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            else if(wrongCount == 3) {
                System.out.println("  |-----------");
                System.out.println("  | /        |");
                System.out.println("  |          |");
                System.out.println("  |          O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            else if(wrongCount == 4) {
                System.out.println("  |-----------");
                System.out.println("  | /        |");
                System.out.println("  |          |");
                System.out.println("  |          O");
                System.out.println("  |         -");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            else if(wrongCount == 5) {
                System.out.println("  |-----------");
                System.out.println("  | /        |");
                System.out.println("  |          |");
                System.out.println("  |          O");
                System.out.println("  |         -|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
            }
            else if (wrongCount == 6){
                System.out.println("|----------");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else if(wrongCount == 7){
                System.out.println("|----------");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        /");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            else {
                System.out.println("|----------");
                System.out.println("|         O");
                System.out.println("|        -|-");
                System.out.println("|        /|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }


            System.out.println("1. Podaj litere :");
            System.out.println("2. Podaj haslo  :");
            System.out.println("3. Wyjdz z gry  :");
            String type = keyboard.nextLine();


           List<String> sloganList = new ArrayList<>();

            switch (type) {

                case "1": {
                    if (!getPlayerGuess(keyboard, slogan, playerGuesses)) {
                        wrongCount++;
                    }
                    if (printWordState(slogan, playerGuesses)) {
                        System.out.println("Brawo !");
                        slogan = gameService.rollRandomSlogan();
                        System.out.println(slogan);
                        gamePoints++;
                        break;
                    }
                    break;

                }

                case "2": {
                    System.out.println();
                    System.out.println("podaj haslo");
                    String next = keyboard.nextLine();
                    if (next.toUpperCase(Locale.ROOT).equals(slogan)) {
                        System.out.println("Brawo, odgadles cale hasło");
                        slogan = gameService.rollRandomSlogan();
                        System.out.println(slogan);
                        gamePoints++;
                    } else {
                        wrongCount++;
                    }
                    break;
                }

                case "3": {
                    exit = true;
                    break;
                }

                default: {
                    System.out.println("Błąd, sprobuj jeszcze raz");
                    break;
                }
            }
        }


    }


}
