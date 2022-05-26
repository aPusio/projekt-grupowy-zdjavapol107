package com.sda.zdjavapol107.kolkokrzyzyk;

public class Main {

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        int movesCount = 0;
        char activePlayerSymbol = 'X';

        boolean isWon = false;
        while (movesCount < 9 && !isWon) {
            //TODO metoda na wydrukowanie planszy
            //TODO metoda na przeprowadzenie ruchu - może zwracać boolean
            // ponieważ jednocześnie trzeba sprawdzić czy ruch jest poprawny
            boolean isMoveWasCorrect = true;
            if (isMoveWasCorrect) {
                movesCount++;
                isWon = checkWinner(board, activePlayerSymbol);
                // wszystkie pojedyncze metody na sprawdzenie wygranej)
                activePlayerSymbol = activePlayerSymbol == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Twój ruch jest niepoprawny! Spróbuj ponownie.");
            }
        }
        //TODO metoda na wydrukowanie planszy
        System.out.println("Koniec gry");


    }

    public static boolean checkWinner(char[][] board, char activePlayerSymbol) {
        return checkWinInFirstDiagonal(board, activePlayerSymbol) ||
                checkWinInSecondDiagonal(board, activePlayerSymbol);
                //TODO metoda na sprawdzenie wygranej w kolumnach
                //TODO metoda na sprawdzenie wygranej w wierszach
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
}
