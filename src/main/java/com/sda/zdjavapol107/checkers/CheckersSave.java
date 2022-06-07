package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.checkers.dao.*;
import com.sda.zdjavapol107.checkers.model.*;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.*;

public class CheckersSave {

    public void saveGame(CheckersBoard checkersBoard) {
        Tournament tournament = convertTournamentToEntity(checkersBoard.getCheckersTournament());
        Player playerOne = convertPlayerToEntity(checkersBoard.getPlayerOne());
        Player playerTwo = convertPlayerToEntity(checkersBoard.getPlayerTwo());
        playerOne.setTournament(tournament);
        playerTwo.setTournament(tournament);
        Game game = createGameEntity(playerOne, playerTwo, tournament);
        Map<Integer, GamePeaces> gamePeacesMap = createGamePeacesMap(checkersBoard, game, playerOne, playerTwo);
        Set<Move> setOfMoves = createSetOfMoves(checkersBoard, gamePeacesMap, playerOne, playerTwo, game);

        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        PlayerDao playerDao = new PlayerDao(sessionFactory);
        GameDao gameDao = new GameDao(sessionFactory);
        GamePeacesDao gamePeacesDao = new GamePeacesDao(sessionFactory);
        MoveDao moveDao = new MoveDao(sessionFactory);
        TournamentDao tournamentDao = new TournamentDao(sessionFactory);

        tournamentDao.save(tournament);
        playerDao.save(playerOne);
        playerDao.save(playerTwo);
        gameDao.save(game);
        gamePeacesMap.values().forEach(gamePeacesDao::save);
        setOfMoves.forEach(moveDao::save);
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

    private Map<Integer, GamePeaces> createGamePeacesMap(CheckersBoard checkersBoard, Game game, Player playerOne, Player playerTwo) {
        Map<Integer, GamePeaces> gamePeacesMap = new HashMap<>();
        Map<Integer, Pawn> pawnMap = checkersBoard.getPawnMap();
        for (int i = 0; i < 24; i++) {
            if (pawnMap.get(i).getColor() == 'w') {
                gamePeacesMap.put(i, new GamePeaces(playerOne, pawnMap.get(i).getColor(), pawnMap.get(i).isDame(),
                        pawnMap.get(i).isInGame(), pawnMap.get(i).getCurrentPosition().getXAxis(),
                        pawnMap.get(i).getCurrentPosition().getYAxis(), game));
            } else if (pawnMap.get(i).getColor() == 'b') {
                gamePeacesMap.put(i, new GamePeaces(playerTwo, pawnMap.get(i).getColor(), pawnMap.get(i).isDame(),
                        pawnMap.get(i).isInGame(), pawnMap.get(i).getCurrentPosition().getXAxis(),
                        pawnMap.get(i).getCurrentPosition().getYAxis(), game));
            }
        }
        return gamePeacesMap;
    }

    private Set<Move> createSetOfMoves(CheckersBoard checkersBoard, Map<Integer, GamePeaces> gamePeacesMap, Player playerOne, Player PlayerTwo, Game game) {
        Set<Move> moveSet = new HashSet<>();
        Map<Integer, Pawn> pawnMap = checkersBoard.getPawnMap();
        for (int i = 0; i < 24; i++) {
            Queue<PawnMove> pawnMoves = pawnMap.get(i).getListOfMoves();
            if (pawnMoves.size() != 0) {
                for (int j = 0; j < pawnMap.get(i).getListOfMoves().size(); j++) {
                        moveSet.add(new Move(gamePeacesMap.get(i).getPlayer(), gamePeacesMap.get(i), pawnMoves.poll(), game));
                }
            }
        }
        return moveSet;
    }
}
