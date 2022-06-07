package com.sda.zdjavapol107.checkers;


import lombok.Getter;

@Getter
public class PawnMove {
    private PawnCoordinates oldPosition;
    private PawnCoordinates newPosition;
    private CheckersTurn turn;

    public PawnMove(PawnCoordinates newPosition, CheckersTurn turn) {
        this.newPosition = newPosition;
        this.turn = turn;
    }
}
