package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.checkers.model.Game;
import com.sda.zdjavapol107.checkers.model.Player;
import com.sda.zdjavapol107.checkers.model.Tournament;

public class CheckersSave {

    private CheckersBoard checkersBoard;

    public CheckersSave(CheckersBoard checkersBoard) {
        this.checkersBoard = checkersBoard;
    }

    public void saveGame() {
        Tournament tournament = convertTournamentToEntity(checkersBoard.getCheckersTournament());
        Player playerOne = convertPlayerToEntity(checkersBoard.getPlayerOne());
        Player playerTwo = convertPlayerToEntity(checkersBoard.getPlayerTwo());
        playerOne.setTournament(tournament);
        playerTwo.setTournament(tournament);


    }

    private Tournament convertTournamentToEntity(CheckersTournament checkersTournament) {
        return new Tournament(checkersTournament.getPlayerOneScore(), checkersTournament.getPlayerTwoScore());
    }

    private Player convertPlayerToEntity(CheckersPlayer checkersPlayer) {
        return new Player(checkersPlayer.getPlayerName());
    }

    private Game createGameEntity() {

        return null;
    }
}
