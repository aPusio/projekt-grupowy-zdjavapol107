package com.sda.zdjavapol107.checkers;

import lombok.Getter;

@Getter
public class CheckersTurn {
    private long turnNumber;

    public CheckersTurn() {
        this.turnNumber = 0;
    }

    public void advance () {
        turnNumber++;
    }
}
