package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.checkers.dao.PlayerDao;
import com.sda.zdjavapol107.checkers.model.Player;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Checkers {
    public void startGame(){
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        PlayerDao playerDao = new PlayerDao(sessionFactory);

        Scanner scanner = new Scanner(System.in);
        String playerOneName, playerTwoName;


        System.out.println("Welcome to Checkers!\n");
        System.out.println("Player one, please enter your name");
        playerOneName = scanner.nextLine();
        System.out.println("Player two, please enter your name");
        playerTwoName = scanner.nextLine();

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);
        playerDao.save(playerOne);
        playerDao.save(playerTwo);







    }



}
