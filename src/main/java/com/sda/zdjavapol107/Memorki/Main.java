package com.sda.zdjavapol107.Memorki;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[][] board = new String[4][4];
    public static String[][] elements = new String[4][4];
    public static Scanner sc = new Scanner(System.in);

    public static void boardPrinter() {
        for (int i = 0; i < 4; i++) {
            System.out.println("|");
            for (int j = 0; j < 4; j++) {
                System.out.println("|");
            }
            System.out.println();

        }
    }

    public static void shuffling() {
        Random shuffleCards = new Random();
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("A S");
        cards.add("JKR");
        cards.add("QUE");
        cards.add("KNG");
        cards.add("JCK");
        cards.add("EIG");
        cards.add("NNE");
        cards.add("TEN");
        cards.add("A S");
        cards.add("JKR");
        cards.add("QUE");
        cards.add("KNG");
        cards.add("JCK");
        cards.add("EIG");
        cards.add("NNE");
        cards.add("TEN");

        int index;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                index = shuffleCards.nextInt(cards.size());
                elements[i][j] = cards.get(index);
                cards.remove(index);

            }
        }


    }

    public static void checkInput(String[][] elements) {
        while (true) {
            if (!gameOver()) {
                System.out.println("Row: (1-4)");
                int row1 = sc.nextInt();
                System.out.println("Column: (1-4)");
                int column1 = sc.nextInt();

                if (!board[row1 - 1][column1 - 1].equals(" _ ")) {
                    System.out.println("You entered it already!");
                    System.out.println();

                    boardPrinter();
                    continue;
                } else {
                    board[row1 - 1][column1 - 1] = " " + elements[row1 - 1][column1 - 1] + " ";
                    boardPrinter();
                }
                System.out.println("Row: (1-4)");
                int row2 = sc.nextInt();
                System.out.println("Column: (1-4)");
                int column2 = sc.nextInt();

                if (!board[row2 - 1][column2 - 1].equals(" _ ")) {
                    System.out.println("You entered it already!");
                    board[row1 - 1][column1 - 1] = " _ ";
                    System.out.println();

                    boardPrinter();
                    continue;
                } else {
                    board[row2 - 1][column2 - 1] = " " + elements[row2 - 1][column2 - 1] + " ";
                    if (board[row1 - 1][column1 - 1].equals(board[row2 - 1][column2 - 1])) {
                        System.out.println("It's a match!");
                    } else {
                        boardPrinter();
                        System.out.println("False");
                        board[row1 - 1][column1 - 1] = " ";
                        board[row2 - 1][column2 - 1] = " ";
                        boardPrinter();
                    }

                }

            } else {
                System.out.println("Game Over");
                break;
            }
        }
    }

    public static boolean gameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(" _ ")) {
                    return false;
                }

            }

        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Press N for new game or Q to quit");
            String nq = sc.nextLine();
            if (nq.equals("q")) {
                System.out.println("Exitting");
                break;
            } else if (nq.equals("n")) {

                shuffling();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        board[i][j] = " _ ";
                    }
                }

                boardPrinter();
                checkInput(elements);
                break;

            } else {
                System.out.println("Invalid Character");
                continue;
            }


        }
    }

}
