package com.sda.zdjavapol107.szubienica.bazaDanych;

import lombok.SneakyThrows;

import java.io.File;
import java.util.*;

public class ZapisSlowDoBazyDanych2 {

    @SneakyThrows
    public static void main(String[] args) {


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

        while (true) {
            System.out.println("1. Podaj litere :");
            System.out.println("2. Podaj haslo  :");
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
                        break;
                    }
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
