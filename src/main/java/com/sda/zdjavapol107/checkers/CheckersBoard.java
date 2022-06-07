package com.sda.zdjavapol107.checkers;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CheckersBoard {
    private Pawn[][] checkersBoard;
    private Map<Integer, Pawn> pawnMap;
    private CheckersPlayer playerOne;
    private CheckersPlayer playerTwo;
    private CheckersTournament checkersTournament;
    private CheckersTurn turn;


    public CheckersBoard(CheckersPlayer playerOne, CheckersPlayer playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        checkersBoard = generateNewBoard();
        checkersTournament = new CheckersTournament();
        printBoard();
    }

    private void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%c %s\n", (char) 65 + i, Arrays.deepToString(checkersBoard[i]).replaceAll("null", "_"));
        }
        System.out.println("   1  2  3  4  5  6  7  8");
    }

    private Pawn[][] generateNewBoard() {
        pawnMap = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            if (i < 12) {
                pawnMap.put(i, new Pawn(playerOne.getColor(), false, true));
            } else {
                pawnMap.put(i, new Pawn(playerTwo.getColor(), false, true));
            }
        }
        Pawn[][] result = new Pawn[8][8];
        int keyValue = 23;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != 3 && i != 4) {
                    if (i % 2 == 0 && j % 2 == 0) {
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
