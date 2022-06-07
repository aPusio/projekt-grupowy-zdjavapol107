package com.sda.zdjavapol107.szubienica;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.szubienica.bazaDanych.DatabaseSloganInsert;
import com.sda.zdjavapol107.szubienica.repository.dao.HangmanGameDao;
import com.sda.zdjavapol107.szubienica.repository.dao.HangmanUserDao;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanGame;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanUser;
import com.sda.zdjavapol107.szubienica.service.GameService;
import com.sda.zdjavapol107.szubienica.service.GameStart;
import com.sda.zdjavapol107.szubienica.service.SessionFactoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) {

        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        HangmanUserDao hangmanUserDao = new HangmanUserDao(sessionFactory);

        DatabaseSloganInsert.run();


        Scanner scanner = new Scanner(System.in);

        String szubienica = "      _________\n" +
                "     |/        |\n" +
                "     |         |\n" +
                "     |         |\n" +
                "     |\n" +
                "     |       (x_x)\n" +
                "     |        /|\\\n" +
                "     |         |\n" +
                " ____|____    / \\" +
                "__SZUBIENICA__\n";

        String next;
        boolean exit = false;


        while (!exit) {
            System.out.println(szubienica);

            System.out.println();
            System.out.println("1. NOWA GRA");
            System.out.println("2. WCZYTAJ GRE");
            System.out.println("3. RANKING GRACZY");
            System.out.println("4. WYJDZ Z GRY");

            next = scanner.next();

            switch (next) {
                case "1": {
                    System.out.println("Enter Your Nickname...");
                    String name = scanner.next();

                    HangmanUser user = new HangmanUser(name);
                    hangmanUserDao.save(user);

                    GameStart gameStart = new GameStart();
                    gameStart.start();

                    HangmanGameDao hangmanGameDao = new HangmanGameDao(SessionFactoryService.getSessionFactory());
                    hangmanGameDao.save(new HangmanGame(user,false));

                    break;
                }
                case "2": {
                    System.out.println("wczytaj gre");
                    break;
                }
                case "3": {
                    System.out.println("ranking graczy");
                    break;
                }
                case "4": {
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("Wybierz ponownie.");
                    break;
                }
            }
        }


    }
}
