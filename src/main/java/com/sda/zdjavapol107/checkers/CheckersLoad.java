package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.HibernateFactory;
import com.sda.zdjavapol107.checkers.dao.*;
import com.sda.zdjavapol107.checkers.model.*;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckersLoad {

    SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
    PlayerDao playerDao = new PlayerDao(sessionFactory);
    GameDao gameDao = new GameDao(sessionFactory);
    GamePeacesDao gamePeacesDao = new GamePeacesDao(sessionFactory);
    MoveDao moveDao = new MoveDao(sessionFactory);
    TournamentDao tournamentDao = new TournamentDao(sessionFactory);

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
        Long id = 0L;
        Game game = null;
        for (Game g : gameList) {
            if (g.getId() > id) {
                id = g.getId();
                game = g;
            }
        }
        return game;
    }

    private List<CheckersPlayer> convertPlayersToChPlayers (List<Player> players) {
        List<CheckersPlayer> checkersPlayerList = new ArrayList<>();
        char playerOneColor = players.get(0).getGamePeaces().stream()
                .findAny().get().getColor();
        char playerTwoColor = players.get(1).getGamePeaces().stream()
                .findAny().get().getColor();
        checkersPlayerList.add(new CheckersPlayer(players.get(0).getName(), playerOneColor));
        checkersPlayerList.add(new CheckersPlayer(players.get(1).getName(), playerTwoColor));
        return checkersPlayerList;
    }
}
