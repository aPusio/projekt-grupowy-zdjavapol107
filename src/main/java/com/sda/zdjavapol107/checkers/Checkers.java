package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.checkers.dao.*;
import com.sda.zdjavapol107.checkers.model.Player;
import org.hibernate.SessionFactory;

public class Checkers {
    public static void startGame() {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        PlayerDao playerDao = new PlayerDao(sessionFactory);
        GameDao gameDao = new GameDao(sessionFactory);
        GamePeacesDao gamePeacesDao = new GamePeacesDao(sessionFactory);
        MoveDao moveDao = new MoveDao(sessionFactory);
        TournamentDao tournamentDao = new TournamentDao(sessionFactory);

//        Scanner scanner = new Scanner(System.in);
        String playerOneName, playerTwoName;

        System.out.println("Welcome to Checkers!\n");
        System.out.println("Player one, please enter your name");
//        playerOneName = scanner.nextLine();
        playerOneName = "Gracz nr 1";
        System.out.println("Player two, please enter your name");
//        playerTwoName = scanner.nextLine();
        playerTwoName = "Gracz nr 2";

//        Kolejność zapisu
//        1. Player
//        2. Game
//        3. Tournament
//        4. GamePeaces
//        5. Move

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);

//        Tournament tournament = new Tournament()

//        Game game = new Game(Set.of(playerOne, playerTwo), ));












        playerDao.save(playerOne);
        playerDao.save(playerTwo);



    }


}
