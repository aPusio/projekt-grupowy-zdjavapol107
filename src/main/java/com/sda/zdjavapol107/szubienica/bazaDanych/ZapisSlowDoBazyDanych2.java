package com.sda.zdjavapol107.szubienica.bazaDanych;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.szubienica.repository.dao.HangmanSloganDao;
import com.sda.zdjavapol107.szubienica.repository.model.HangmanSlogan;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.File;
import java.util.*;

public class ZapisSlowDoBazyDanych2 {

    @SneakyThrows
    public static void main(String[] args) {

        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();


        HangmanSloganDao hangmanSloganDao = new HangmanSloganDao(sessionFactory);


        Scanner scanner = new Scanner(new File("C:/bazaDanych.txt"));
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        List<String> words = new ArrayList<>();



        while (scanner.hasNext()) {
            words.add(scanner.nextLine().toUpperCase(Locale.ROOT));
        }

        String name = words.get(random.nextInt(words.size()));
        System.out.println(name);

        List<Character> playerGuesses = new ArrayList<>();

        for (int i = 0; i <= words.size()-1; i++) {
            hangmanSloganDao.save(new HangmanSlogan(words.get(i)));
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Podaj litere :");
            System.out.println("2. Podaj haslo  :");
            System.out.println("3. Wyjdz z gry  :");
            String type = keyboard.nextLine();

            switch (type) {

                case "1" : {
                    getPlayerGuess(keyboard,name,playerGuesses);
                    if (printWordState(name,playerGuesses)) {
                        System.out.println("Brawo !");
                        break;
                    };
                    break;

                }

                case "2" : {
                    System.out.println("podaj haslo");
                    String next = keyboard.nextLine();
                    if (next.toUpperCase(Locale.ROOT).equals(name)) {
                        System.out.println("Brawo, odgadles cale haslo");
                        exit =true;
                        break;
                    }
                }

                case "3" : {
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

    private static void getPlayerGuess(Scanner keyboard, String name, List<Character> playerGuesses) {
        System.out.println();
        System.out.println("Podaj literę:");
        String letterGuess = keyboard.nextLine().toUpperCase(Locale.ROOT);
        playerGuesses.add(letterGuess.charAt(0));
    }


    private static boolean printWordState(String name, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < name.length(); i++) {

            if (playerGuesses.contains(name.charAt(i))) {
                System.out.print(name.charAt(i));
                correctCount++;
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
        return (name.length() == correctCount);
    }
}
