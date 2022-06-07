package com.sda.zdjavapol107.statki.ship;

import com.sda.zdjavapol107.statki.MessagesPrinter;
import com.sda.zdjavapol107.statki.model.PointShipsGame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ShipService {
    private ShipDirection shipDirectionEnum;
    private boolean isShipPositionOk = false;
    private int choiceShipSize = 1;
    protected int fourSizeShip = 1;
    protected int threeSizeShip = 2;
    protected int twoSizeShip = 3;
    protected int oneSizeShip = 4;
    public int shipDirection;
    private boolean endOfPlacesTheShips = false;
    private PointShipsGame firstPointShip;
    private int userPointY;
    private int userPointX;
    private boolean endLoopCreatingShip;
    public List<PointShipsGame> busyPointsOnBoard = new ArrayList<>();
    private MessagesPrinter messagesPrinter = new MessagesPrinter();
    private Scanner scanner = new Scanner(System.in);

    // Pokauzje infomracje ile statkow zostalo do postawienia przez uzytkownika
    public void creatingShip() {
        boolean haveShip = true;
        do {
            do {
                messagesPrinter.lastShipsToPlace(fourSizeShip, threeSizeShip, twoSizeShip, oneSizeShip);
                try {
                    choiceShipSize = scanner.nextInt();
                    if (choiceShipSize > 0 && choiceShipSize < 5 && checkAvilabilityShips()) {
                        placesTheSingleShip(choiceShipSize);
                        if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                            endOfPlacesTheShips = true;
                        }
                    }
                } catch (InputMismatchException e) {
                    messagesPrinter.errorInputValue();
                }
            } while (endOfPlacesTheShips == false);
        } while (endOfPlacesTheShips == false);
    }

    private boolean checkAvilabilityShips() {
        boolean haveShip = true;
        if (choiceShipSize == 1) {
            if (fourSizeShip != 0) {
                haveShip = true;
            } else {
                haveShip = false;
                messagesPrinter.dontHaveAnyMoreShipsOfThatSize();
            }
        } else if (choiceShipSize == 2) {
            if (threeSizeShip != 0) {
                haveShip = true;
            } else {
                haveShip = false;
                messagesPrinter.dontHaveAnyMoreShipsOfThatSize();
            }
        } else if (choiceShipSize == 3) {
            if (twoSizeShip != 0) {
                haveShip = true;
            } else {
                haveShip = false;
                messagesPrinter.dontHaveAnyMoreShipsOfThatSize();
            }
        } else if (choiceShipSize == 4) {
            if (oneSizeShip != 0) {
                haveShip = true;
            } else {
                haveShip = false;
                messagesPrinter.dontHaveAnyMoreShipsOfThatSize();
            }
        }
        return haveShip;
    }

    private void placesTheSingleShip(int sizeOfShip) {
        messagesPrinter.selectedStartingPointOfCreatingShip();
        userPointX = scanner.nextInt();
        messagesPrinter.printSingleLine("Podaj numer kolumny (1 - 10): ");
        userPointY = scanner.nextInt();
        firstPointShip = new PointShipsGame(userPointX, userPointY);
        do {
            messagesPrinter.chooseShipDirection();
            shipDirection = scanner.nextInt();
            switch (shipDirection) {
                case 1: {
                    shipDirectionEnum = ShipDirection.isTop;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, firstPointShip);
                    break;
                }
                case 2: {
                    shipDirectionEnum = ShipDirection.isRight;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, firstPointShip);
                    break;
                }
                case 3: {
                    shipDirectionEnum = ShipDirection.isDown;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, firstPointShip);
                    break;
                }
                case 4: {
                    shipDirectionEnum = ShipDirection.isLeft;
                    endLoopCreatingShip = canShipBePlaces(sizeOfShip, firstPointShip);
                    break;
                }
                default: {
                    messagesPrinter.printSingleLine("Podano bledna wartosc");
                    endLoopCreatingShip = false;
                }
            }
        } while (!endLoopCreatingShip);
    }

    private boolean canShipBePlaces(int shipSize /*1, 2, 3, 4*/, PointShipsGame point) {
        isShipPositionOk = true;
        System.out.println(shipDirectionEnum);
        switch (shipDirection) {
            case 1: {
                if ((point.getY() - (shipSize - 1)) > 0) // int
                {
                    for (int i = 0; i < busyPointsOnBoard.size(); i++) {
                        for (int j = 0; j < shipSize; j++) {
                            point.setY(point.getY() - j);
                            if (point.equals(busyPointsOnBoard.get(i))) {
                                isShipPositionOk = false;
                                messagesPrinter.printSingleLine("W tym miejscu nie może stać kolejny statek");
                                break;
                            } else {
                                isShipPositionOk = true;
                            }
                        }
                        if (isShipPositionOk) {
                            switch (shipSize) {
                                case 1: {
                                    oneSizeShip--;
                                    break;
                                }
                                case 2: {
                                    twoSizeShip--;
                                    break;
                                }
                                case 3: {
                                    threeSizeShip--;
                                    break;
                                }
                                case 4: {
                                    fourSizeShip--;
                                    break;
                                }
                            }
//                           TODO ShipShipsGame shipShipsGame = new ShipShipsGame(shipSize,false,isTop,isRight,isDown,isLeft,point);
                        }
                    }
                } else {
                    messagesPrinter.printSingleLine("Postawienie statku niemozliwe");
                }
            }
            case 2: {

            }
            case 3: {

            }
            case 4: {

            }
            if (isShipPositionOk) {
                messagesPrinter.printSingleLine("Statek zostal postawiony");
            } else {
                messagesPrinter.printSingleLine("Statek nie moze zostac umieszczony w tym miejscu");
            }
        }
        return (isShipPositionOk);
    }

}
