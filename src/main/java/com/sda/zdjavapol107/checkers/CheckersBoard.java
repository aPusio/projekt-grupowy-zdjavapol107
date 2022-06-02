package com.sda.zdjavapol107.checkers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckersBoard {
    private Pawn[][] checkersBoard;
    private Map<Integer ,Pawn> pawnMap;
    private String playerOne;
    private String playerTwo;


    public CheckersBoard(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        checkersBoard = generateNewBoard();
        printBoard(checkersBoard);
    }

    private void printBoard(Pawn[][] checkersBoard) {
        for (Pawn[] pawns : this.checkersBoard) {
            System.out.println(Arrays.deepToString(pawns).replaceAll("null", "_"));
            System.out.printf("%c %s", );
        }

        for (int i = 0; i < 8; i++) {
            System.out.printf("%c %s", Character.forDigit());
        }
    }

    private Pawn[][] generateNewBoard(){
        pawnMap = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            if (i<12) {
                pawnMap.put(i, new Pawn('w', false, true));
            } else {
                pawnMap.put(i, new Pawn('b', false, true));
            }
        }
        Pawn[][] result = new Pawn[8][8];
        int keyValue = 23;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != 3 && i != 4) {
                    if (i % 2 == 0 && j % 2 == 0){
                        result[i][j] = pawnMap.get(keyValue);
                        keyValue--;
                    } else if (i % 2 != 0 && j % 2 != 0) {
                        result[i][j] = pawnMap.get(keyValue);
                        keyValue--;
                    }
                }
            }            
        }
        return result;
    }

}
