package com.sda.zdjavapol107.statki;

import com.sda.zdjavapol107.statki.model.PointShipsGame;
import com.sda.zdjavapol107.statki.model.ShipShipsGame;
import com.sda.zdjavapol107.statki.model.UserShipsGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShipsMain {

    private static Scanner scanner = new Scanner(System.in);
    private static String userName;
    private static boolean mainLoop = true;
    private static String choice = "";
    private static String choiceUser = "";

    private static boolean isShipPositionOk = false;
    private static String choiceShipSize = "";
    protected static int fourSizeShip = 1;
    protected static int threeSizeShip = 2;
    protected static int twoSizeShip = 3;
    protected static int oneSizeShip = 4;

    public static int shipDirection;
    private static boolean endOfPlacesTheShips = false;

    private static PointShipsGame firstPointShip;
    private static boolean isTop, isDown, isLeft, isRight;
    private static int userPointY;
    private static int userPointX;
    private static boolean haveShip = true;
    private static boolean endLoopCreatingShip;

    public static List<PointShipsGame> busyPointsOnBoard = new ArrayList<>();
    public static void start() {

        UserInterface.printStartingMenuLabel();

        do {
            UserInterface.printStartingMenu();
            choice = scanner.next();
            switch (choice) {
                case "1": {
                    initialization();
                    beginOfTheGame();
                    break;
                }
                case "2": {
                    //TODO wyswietlanie list gier z gazy danych
                    //TODO jezeli lista gier z bazy danych będzie różna od 0 możliwość wyboru gry przez uzytkownika
                    UserInterface.printSingleLine("Wczytywanie");
                    beginOfTheGame();
                    break;
                }
                case "3": {
                    mainLoop = false;
                    break;
                }
                default: {
                    UserInterface.printSingleLine("Podano błedna wartosc");
                    break;
                }
            }
        } while (mainLoop == true);
        UserInterface.printSingleLine("Koniec gry");
    }

    private static void initialization() {
        UserInterface.haveYouPlayed();
        choiceUser = scanner.next();
        if (choiceUser.equals("y")) {
            //TODO wyswietlanie listy uzytkownikow z bazy danych
            //TODO jezeli lista uzytkownikow z bazy danych będzie różna od 0 możliwość wyboru gry przez uzytkownika
        } else {
            UserInterface.creatingNewUser();
            creatingNewUser();
            UserInterface.placingTheShips();
            do {
                do {
                    UserInterface.lastShipsToPlace();
                    choiceShipSize = scanner.next();
                    if (choiceShipSize.equals("1")) {
                        if (fourSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            UserInterface.dontHaveAnyMoreShipsOfThatSize();
                        }
                    } else if (choiceShipSize.equals("2")) {
                        if (threeSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            UserInterface.dontHaveAnyMoreShipsOfThatSize();
                        }
                    } else if (choiceShipSize.equals("3")) {
                        if (twoSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            UserInterface.dontHaveAnyMoreShipsOfThatSize();
                        }
                    } else if (choiceShipSize.equals("4")) {
                        if (oneSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            UserInterface.dontHaveAnyMoreShipsOfThatSize();
                        }
                    }
                    if (haveShip == true) {
                        switch (choiceShipSize) {
                            case "1": {
                                placesTheSingleShip(4);
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            case "2": {
                                placesTheSingleShip(3);
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            case "3": {
                                placesTheSingleShip(2);
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            case "4": {
                                placesTheSingleShip(1);
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            default: {
                                UserInterface.printSingleLine("Podano bledna wartosc");
                                break;
                            }
                        }
                    }
                } while (endOfPlacesTheShips == false);
            } while (endOfPlacesTheShips == false);
            //TODO tworzenie nowego statku
        }
    }

    private static void creatingNewUser() {
        userName = scanner.next();
        UserShipsGame userShipsGame = new UserShipsGame(userName);
        //TODO tworzenie nowego rekordu typu User w bazie danych
    }

    private static void placesTheSingleShip(int sizeOfShip) {
        UserInterface.selectedStartingPointOfCreatingShip();
        userPointX = scanner.nextInt();
        UserInterface.printSingleLine("Podaj numer kolumny (1 - 10): ");
        userPointY = scanner.nextInt();
        firstPointShip = new PointShipsGame(userPointX, userPointY);
        do {
            UserInterface.newShipDirection();
            shipDirection = scanner.nextInt();
            switch (shipDirection) {
                case 1: {
                    isTop = true;
                    isRight = false;
                    isDown = false;
                    isLeft = false;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, shipDirection, firstPointShip);
                    break;
                }
                case 2: {
                    isTop = false;
                    isRight = true;
                    isDown = false;
                    isLeft = false;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, shipDirection, firstPointShip);
                    break;
                }
                case 3: {
                    isTop = false;
                    isRight = false;
                    isDown = true;
                    isLeft = false;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, shipDirection, firstPointShip);
                    break;
                }
                case 4: {
                    isTop = false;
                    isRight = false;
                    isDown = false;
                    isLeft = true;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, shipDirection, firstPointShip);
                    break;
                }
                default: {
                    UserInterface.printSingleLine("Podano bledna wartosc");
                    endLoopCreatingShip = false;
                }
            }
        }while (!endLoopCreatingShip);
    }

    public static boolean canShipBePlaces(int shipSize /*1, 2, 3, 4*/, int shipDirection /* Gora, Prawo, Dol, Lewo */, PointShipsGame point){
        //TODO sprawdzanie czy statek moze byc umiejscowiony w tym miejscu
        isShipPositionOk = true;
        switch(shipDirection){
            case 1:
            {
                if((point.getY()-(shipSize-1))>0) // int
                {
                    for (int i = 0; i < busyPointsOnBoard.size(); i++) {
                        for (int j = 0; j < shipSize; j++) {
                            point.setY(point.getY()-j);
                            if(point.equals(busyPointsOnBoard.get(i)))
                            {
                                isShipPositionOk = false;
                                System.out.println("W tym miejscu nie może stać kolejny statek");
                                break;
                            }else{
                                isShipPositionOk = true;
                            }
                        }
                        if(isShipPositionOk){
                            switch(shipSize){
                                case 1:
                                {
                                    oneSizeShip--;
                                    break;
                                }
                                case 2:
                                {
                                    twoSizeShip--;
                                    break;
                                }
                                case 3:                                    {
                                    threeSizeShip--;
                                    break;
                                }
                                case 4:
                                {
                                    fourSizeShip--;
                                    break;
                                }
                            }
                            ShipShipsGame shipShipsGame = new ShipShipsGame(shipSize,false,isTop,isRight,isDown,isLeft,point);
                        }
                    }
                }else{
                    System.out.println("Postawienie statku niemozliwe");
                }
            }
            case 2:
            {

            }
            case 3:
            {

            }
            case 4:
            {

            }
            if(isShipPositionOk){
                System.out.println("Statek zostal postawiony");
            }else{
                System.out.println("Statek nie moze zostac umieszczony w tym miejscu");
            }
        }
        return(isShipPositionOk);
    }
    private static void beginOfTheGame() {
        //TODO stworzenie rozgrywki
    }
}
