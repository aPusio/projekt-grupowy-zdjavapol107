package com.sda.zdjavapol107.checkers;

import java.util.Objects;
import java.util.Scanner;

public class Checkers {
    public static void gameSetup() {

        Scanner scanner = new Scanner(System.in);
        String playerOneName, playerTwoName;
        CheckersBoard checkersBoard;

        System.out.println("Welcome to Checkers!\n");
        System.out.println("Would you like to load last game? (y/n)");
        String playerChoice = scanner.nextLine();
        if (Objects.equals(playerChoice, "y")) {
            System.out.println("Loading last game");
            CheckersLoad checkersLoad = new CheckersLoad();
            checkersBoard = checkersLoad.loadLastGame();
//            TODO work in progress
        } else {
            System.out.println("Starting new game");
//        System.out.println("Player one, please enter your name");
//        playerOneName = scanner.nextLine()
            playerOneName = "Gracz nr 1";
//        System.out.println("Player two, please enter your name");
//        playerTwoName = scanner.nextLine();
            playerTwoName = "Gracz nr 2";

            CheckersPlayer playerOne = new CheckersPlayer(playerOneName, 'w');
            CheckersPlayer playerTwo = new CheckersPlayer(playerTwoName, 'b');
            checkersBoard = new CheckersBoard(playerOne, playerTwo);
            checkersBoard.printBoard();

            CheckersSave checkersSave = new CheckersSave();
            checkersSave.saveGame(checkersBoard);
        }
    }
}
