package com.sda.zdjavapol107.kolkokrzyzyk;

import java.util.Scanner;

public class GameLogic {


    public static void start() {
        char[][] board = new char[3][3];
        int movesCount = 0;
        char activePlayerSymbol = 'X';

        boolean isWon = false;
        while (movesCount < 9 && !isWon) {
            printBoard(board);
            boolean isMoveWasCorrect = false;
            try {
                 isMoveWasCorrect = performMove(board, activePlayerSymbol);
            }catch (ArrayIndexOutOfBoundsException exception){
                System.out.println("Podaj właściwą liczbę");
            }

            if (isMoveWasCorrect) {
                movesCount++;
                isWon = checkWinner(board, activePlayerSymbol);
                activePlayerSymbol = activePlayerSymbol == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Twój ruch jest niepoprawny! Spróbuj ponownie.");
            }
        }
        printBoard(board);
        System.out.println("Koniec gry");
    }

    public static boolean checkWinner(char[][] board, char activePlayerSymbol) {
        return checkWinInFirstDiagonal(board, activePlayerSymbol) ||
                checkWinInSecondDiagonal(board, activePlayerSymbol) ||
                checkWinInColumns(board, activePlayerSymbol) ||
                checkWinInRows(board, activePlayerSymbol);
    }

    public static boolean checkWinInFirstDiagonal(char[][] board, char activePlayerSymbol) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][i] != activePlayerSymbol) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWinInSecondDiagonal(char[][] board, char activePlayerSymbol) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][dim - i - 1] != activePlayerSymbol) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWinInColumns(char[][] board, char activePlayerSymbol) {
        int dim = board.length;
        for (int col = 0; col < dim; col++) {
            boolean win = true;
            for (int row = 0; row < dim; row++) {
                if (board[row][col] != activePlayerSymbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWinInRows(char[][] board, char activePlayerSymbol) {
        int dim = board.length;
        for (int col = 0; col < dim; col++) {
            boolean win = true;
            for (int row = 0; row < dim; row++) {
                if (board[col][row] != activePlayerSymbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public static boolean performMove(char[][] board, char activePlayerSymbol) {
        System.out.println(activePlayerSymbol + ", podaj nr wiersza");
        int row = new Scanner(System.in).nextInt();
        System.out.println(activePlayerSymbol + ", podaj numer kolumny");
        int col = new Scanner(System.in).nextInt();

        if (board[row][col] == 0) {
            board[row][col] = activePlayerSymbol;
            return true;
        } else {
            return false;
        }
    }

    public static void printBoard(char[][] board) {
        int dim = board.length;
        System.out.print("\t");
        for (int i = 0; i < dim; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int row = 0; row < dim; row++) {
            System.out.print(row + ":\t");
            for (int column = 0; column < dim; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
