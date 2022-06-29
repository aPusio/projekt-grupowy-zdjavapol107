package com.sda.zdjavapol107.checkers;


import lombok.Getter;

@Getter
public class PawnMove {
    private PawnCoordinates oldPosition;
    private final PawnCoordinates newPosition;
    private final long turn;

    public PawnMove(PawnCoordinates newPosition, long turn) {
        this.newPosition = newPosition;
        this.turn = turn;
    }
}
