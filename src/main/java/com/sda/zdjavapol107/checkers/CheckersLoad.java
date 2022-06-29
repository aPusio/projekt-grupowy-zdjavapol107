package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.checkers.dao.*;
import com.sda.zdjavapol107.checkers.model.*;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckersLoad {

    SessionFactory sessionFactory;
    PlayerDao playerDao;
    GameDao gameDao;
    GamePeacesDao gamePeacesDao;
    MoveDao moveDao;
    TournamentDao tournamentDao;

    CheckersLoad(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        playerDao = new PlayerDao(sessionFactory);
        gameDao = new GameDao(sessionFactory);
        gamePeacesDao  = new GamePeacesDao(sessionFactory);
        moveDao  = new MoveDao(sessionFactory);
        tournamentDao = new TournamentDao(sessionFactory);
    }

    public CheckersBoard loadLastGame() {
        Tournament tournament = tournamentDao.getLastTournament();
        List<Game> gameList = gameDao.getGamesByTournamentId(tournament.getId());
        Game game = loadLatestGame(gameList);
//        List<Player> playerList = playerDao.getPlayersByGameId(tournament.getId());
        List<GamePeaces> gamePeacesList = gamePeacesDao.getGamePeacesByGameId(game.getId());
        List<Move> moveList = moveDao.getMovesByGameId(game.getId());

        CheckersTournament checkersTournament = new CheckersTournament(tournament.getPlayerOneScore(), tournament.getPlayerTwoScore());
//        List<CheckersPlayer> checkersPlayerList = convertPlayersToChPlayers(playerList);

        return null;
    }

    private Game loadLatestGame(List<Game> gameList) {
        LocalDateTime saveDateTime = LocalDateTime.MIN;
        Game game = null;
        for (Game g : gameList) {
        if (g.getSaveDateAndTime().isAfter(saveDateTime)) {
                saveDateTime = g.getSaveDateAndTime();
                game = g;
            }
        }
        return game;
    }

    private List<CheckersPlayer> convertPlayersToChPlayers (List<Player> players) {
        List<CheckersPlayer> checkersPlayerList = new ArrayList<>();
        checkersPlayerList.add(new CheckersPlayer(players.get(0).getName(), players.get(0).getColor()));
        checkersPlayerList.add(new CheckersPlayer(players.get(1).getName(), players.get(1).getColor()));
        return checkersPlayerList;
    }
}
