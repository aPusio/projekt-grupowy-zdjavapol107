package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.checkers.model.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        Game game = createGameEntity(playerOne, playerTwo, tournament);
        Map<Integer, GamePeaces> gamePeacesMap = createGamePeacesMap(checkersBoard, game, playerOne, playerTwo);
        Set<Move> setOfMoves = createSetOfMoves(checkersBoard.getPawnMap(), playerOne, playerTwo, game);



    }

    private Tournament convertTournamentToEntity(CheckersTournament checkersTournament) {
        return new Tournament(checkersTournament.getPlayerOneScore(), checkersTournament.getPlayerTwoScore());
    }

    private Player convertPlayerToEntity(CheckersPlayer checkersPlayer) {
        return new Player(checkersPlayer.getPlayerName());
    }

    private Game createGameEntity(Player playerOne, Player playerTwo, Tournament tournament) {
        Game game = new Game(Set.of(playerOne, playerTwo), tournament);
        game.setSaveDateAndTime(LocalDateTime.now());
        return game;
    }

    private Map<Integer, GamePeaces> createGamePeacesMap (CheckersBoard checkersBoard, Game game, Player playerOne, Player playerTwo) {
        Map<Integer, GamePeaces> gamePeacesMap = new HashMap<>();
        Map<Integer, Pawn> pawnMap = checkersBoard.getPawnMap();
        for (int i = 0; i < 24; i++) {
            if (pawnMap.get(i).getColor() == 'w') {
                gamePeacesMap.put(i, new GamePeaces(playerOne, pawnMap.get(i).getColor(), pawnMap.get(i).isDame(), pawnMap.get(i).isInGame(), pawnMap.get(i).getCurrentPosition().getXAxis(), pawnMap.get(i).getCurrentPosition().getYAxis(), game));
            } else if (pawnMap.get(i).getColor() == 'b') {
                gamePeacesMap.put(i, new GamePeaces(playerTwo, pawnMap.get(i).getColor(), pawnMap.get(i).isDame(), pawnMap.get(i).isInGame(), pawnMap.get(i).getCurrentPosition().getXAxis(), pawnMap.get(i).getCurrentPosition().getYAxis(), game));
            }
        }
        return gamePeacesMap;
    }

    private Set<Move> createSetOfMoves (Map<Integer, Pawn> pawnMap, Player playerOne, Player PlayerTwo, Game game) {
        Set<Move> moveSet = new HashSet<>();
        for (int i = 0; i < 24; i++) {
//            for (int j = 0; j < ; j++) {
//
//            }

        }
        return null;
    }
}
