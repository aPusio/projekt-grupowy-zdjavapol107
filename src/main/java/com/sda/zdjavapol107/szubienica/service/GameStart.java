package com.sda.zdjavapol107.szubienica.service;

import com.sda.zdjavapol107.szubienica.repository.model.HangmanSlogan;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GameStart {

    private HangmanSlogan hangmanSlogan;

    public HangmanSlogan getHangmanSlogan() {
        return hangmanSlogan;
    }

    public void start(){

        int wrongCount = 0;
        int gamePoints = 0;
        Scanner keyboard = new Scanner(System.in);
        List<Character> playerGuesses = new ArrayList<>();

        GameService gameService = new GameService();

        hangmanSlogan = gameService.rollRandomSlogan();

        String slogan = hangmanSlogan.getName();
//        System.out.println(slogan);

        boolean exit = false;

        while (!exit) {

            if (gamePoints == 1) {
                break;
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
                System.out.println("PRZEGRAŁEŚ");
                System.out.println("Prawidłowe hasło to: " + slogan);
                break;
            }

            System.out.println("1. Podaj litere :");
            System.out.println("2. Podaj haslo  :");
            System.out.println("3. Opuść rozgrywkę  :");
            String type = keyboard.nextLine();

            switch (type) {

                case "1": {
                    if (!gameService.getPlayerGuess(keyboard, slogan, playerGuesses)) {
                        wrongCount++;
                    }
                    if (gameService.printWordState(slogan, playerGuesses)) {
                        System.out.println("Brawo !");
                        slogan = gameService.rollRandomSlogan().getName();
//                        System.out.println(slogan);
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
                        slogan = gameService.rollRandomSlogan().getName();
//                        System.out.println(slogan);
                        gamePoints++;
                    } else {
                        wrongCount++;
                        System.out.println("Błędne hasło");
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

