package com.sda.zdjavapol107.checkers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Queue;

@AllArgsConstructor
@Getter
public class Pawn {
    //    private int pawnNumber;
    private Character color;
    private boolean isDame;
    private boolean inGame;
    private PawnCoordinates currentPosition;
    private Queue<PawnMove> listOfMoves;


    public Pawn(Character color, boolean isDame, boolean inGame) {
        this.color = color;
        this.isDame = isDame;
        this.inGame = inGame;

    }

    @Override
    public String toString() {
        return color.toString();
    }
}
