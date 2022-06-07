package com.sda.zdjavapol107.checkers;

public class Checkers {
    public static void gameSetup() {
//        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
//        PlayerDao playerDao = new PlayerDao(sessionFactory);
//        GameDao gameDao = new GameDao(sessionFactory);
//        GamePeacesDao gamePeacesDao = new GamePeacesDao(sessionFactory);
//        MoveDao moveDao = new MoveDao(sessionFactory);
//        TournamentDao tournamentDao = new TournamentDao(sessionFactory);

//        Scanner scanner = new Scanner(System.in);
        String playerOneName, playerTwoName;

        System.out.println("Welcome to Checkers!\n");
//        System.out.println("Player one, please enter your name");
//        playerOneName = scanner.nextLine();
        playerOneName = "Gracz nr 1";
//        System.out.println("Player two, please enter your name");
//        playerTwoName = scanner.nextLine();
        playerTwoName = "Gracz nr 2";

        CheckersPlayer playerOne = new CheckersPlayer(playerOneName, 'w');
        CheckersPlayer playerTwo = new CheckersPlayer(playerTwoName, 'b');


        CheckersBoard checkersBoard = new CheckersBoard(playerOne, playerTwo);

        CheckersSave checkersSave = new CheckersSave();
        checkersSave.saveGame(checkersBoard);

//        Kolejność zapisu
//        1. Tournament
//        2. Player
//        3. Game
//        4. GamePeaces
//        5. Move

//        Tournament tournament = new Tournament(0, 0);
//        Player playerOne = new Player(playerOneName, tournament);
//        Player playerTwo = new Player(playerTwoName, tournament);
//        Game game = new Game(Set.of(playerOne, playerTwo), tournament);
//        Map<Integer, GamePeaces> gamePeacesMap = new HashMap<>();
//        for (int i = 0; i < 24; i++) {
//            if (i < 12) {
//                gamePeacesMap.put(i, new GamePeaces(playerOne, 'w', false, true, game));
//            } else {
//                gamePeacesMap.put(i, new GamePeaces(playerTwo, 'b', false, true, game));
//            }
//        }
//
//        tournamentDao.save(tournament);
//        playerDao.save(playerOne);
//        playerDao.save(playerTwo);
//        gameDao.save(game);
//        for (int i = 0; i < 24; i++) {
//            gamePeacesDao.save(gamePeacesMap.get(i));
//        }
//        moveDao.save(new Move(playerOne, gamePeacesMap.get(0), 0, 0, game));
//        moveDao.save(new Move(playerOne, gamePeacesMap.get(1), 0, 0, game));


    }


}
