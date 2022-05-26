package com.sda.zdjavapol107.kolkokrzyzyk;

import java.util.Scanner;

import static com.sda.zdjavapol107.kolkokrzyzyk.Table.displayBoard;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please state the dimensions of the table");
        int dimensions = new Scanner(System.in).nextInt();
        char[][] board = new char[dimensions][dimensions];
        char activePlayer = 'X';
        int movesCounter = 0;
        System.out.println("Dimensions selected are " + dimensions + " by " + dimensions);
        //displayBoard(board);

        while (movesCounter < dimensions * dimensions) {
                displayBoard(board);
                boolean moveWasCorrect = performMove(board, activePlayer);
                if (moveWasCorrect) {
                    movesCounter++;
                    activePlayer = activePlayer == 'X' ? 'O' : 'X';
                } else {
                    System.out.println("Invalid move, please try again!");
                }
            }
        }

        private static boolean performMove(char[][] board, char activePlayer) {
            System.out.println(activePlayer + ", enter the row number");
            int row = new Scanner(System.in).nextInt();
            System.out.println(activePlayer + ", enter the column number");
            int col = new Scanner(System.in).nextInt();

            if (board[row][col] == 0) {
                board[row][col] = activePlayer;
                return true;
            } else {
                return false;
            }

        }

    }




