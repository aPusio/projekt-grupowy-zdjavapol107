package com.sda.zdjavapol107.checkers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CheckersTournament {
    private Integer playerOneScore;
    private Integer playerTwoScore;

    public CheckersTournament() {
        playerOneScore = 0;
        playerTwoScore = 0;
    }
}
