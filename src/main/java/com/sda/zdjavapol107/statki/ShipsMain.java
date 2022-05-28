package com.sda.zdjavapol107.statki;

import com.sda.zdjavapol107.statki.model.UserShipsGame;

import java.util.Scanner;

public class ShipsMain {

        private static Scanner scanner = new Scanner(System.in);
        private static String userName;
        private static boolean mainLoop = true;
        private static String choice = "";
        private static String choiceUser = "";
        private static String choiceShipSize = "";
        private static int fourSizeShip = 1;
        private static int threeSizeShip = 2;
        private static int twoSizeShip = 3;
        private static int oneSizeShip = 4;
        private static boolean endOfPlacesTheShips = false;

        private static boolean haveShip = true;

    public static void start() {
        System.out.println("-------------------------------------------");
        System.out.println("----------------MENU - STATKI--------------");
        System.out.println("-------------------------------------------");
        System.out.println();

        do {
            System.out.println("Wybierz od 1 - 3 by rozpoczac gre");
            System.out.println("1 - Nowa Gra");
            System.out.println("2 - Wczytaj gre");
            System.out.println("3 - Zakoncz");
            choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    initialization();
                    beginOfTheGame();
                    break;
                }
                case "2": {
                    //TODO wyswietlanie list gier z gazy danych
                    //TODO jezeli lista gier z bazy danych będzie różna od 0 możliwość wyboru gry przez uzytkownika
                    System.out.println("Wczytywanie");
                    beginOfTheGame();
                    break;
                }
                case "3": {
                    mainLoop = false;
                    break;
                }
                default: {
                    System.out.println("Podano błedna wartosc");
                    break;
                }
            }
        } while (mainLoop == true);
        System.out.println("Koniec gry");
    }

    private static void initialization() {
        System.out.println("Czy juz grales w gre statki na naszym portalu?");
        System.out.println("y - Tak, n - Nie");
        choiceUser = scanner.nextLine();
        if (choiceUser.equals("Y")) {
            //TODO wyswietlanie listy uzytkownikow z bazy danych
            //TODO jezeli lista uzytkownikow z bazy danych będzie różna od 0 możliwość wyboru gry przez uzytkownika
        } else {
            System.out.println("----------------------------");
            System.out.println("Tworzenie nowego uzytkownika");
            System.out.println("----------------------------");
            System.out.println("Podaj swoj nick w grze: ");
            userName = scanner.nextLine();
            UserShipsGame userShipsGame = new UserShipsGame(userName);
            //TODO tworzenie nowego rekordu typu User w bazie danych
            System.out.println("W grze statki kazdy z graczy ma 10 statkow do rozstawienia na swojej planszy");
            System.out.println("Podaj rodzaj statku od 1 do 4 ktory chcesz umiescic na swojej planszy");
            do {
                do {
                    System.out.println("Pozostalo statkow do rozstawienia:");
                    System.out.println("Cztero-masztowce: " + fourSizeShip);
                    System.out.println("Troj-masztowce: " + threeSizeShip);
                    System.out.println("Dwu-masztowce: " + twoSizeShip);
                    System.out.println("Jedno-masztowce: " + oneSizeShip);
                    choiceShipSize = scanner.nextLine();
                    if (choiceShipSize.equals("1")) {
                        if (fourSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            System.out.println("--------------------------------------------------");
                            System.out.println("Nie posidasz juz cztero-masztowcow do rozstawienia");
                            System.out.println("--------------------------------------------------");
                        }
                    } else if (choiceShipSize.equals("2")) {
                        if (threeSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            System.out.println("--------------------------------------------------");
                            System.out.println("Nie posidasz juz troj-masztowcow do rozstawienia");
                            System.out.println("--------------------------------------------------");
                        }
                    } else if (choiceShipSize.equals("3")) {
                        if (twoSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            System.out.println("--------------------------------------------------");
                            System.out.println("Nie posidasz juz dwu-masztowcow do rozstawienia");
                            System.out.println("--------------------------------------------------");
                        }
                    } else if (choiceShipSize.equals("4")) {
                        if (oneSizeShip != 0) {
                            haveShip = true;
                        } else {
                            haveShip = false;
                            System.out.println("--------------------------------------------------");
                            System.out.println("Nie posidasz juz jedno-masztowcow do rozstawienia");
                            System.out.println("--------------------------------------------------");
                        }
                    }
                    if (haveShip == true) {
                        switch (choiceShipSize) {
                            case "1": {
                                PlacesTheSingleShip(4);
                                fourSizeShip--;
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            case "2": {
                                PlacesTheSingleShip(3);
                                threeSizeShip--;
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            case "3": {
                                PlacesTheSingleShip(2);
                                twoSizeShip--;
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            case "4": {
                                PlacesTheSingleShip(1);
                                oneSizeShip--;
                                if (fourSizeShip == 0 && threeSizeShip == 0 && twoSizeShip == 0 && oneSizeShip == 0) {
                                    endOfPlacesTheShips = true;
                                }
                                break;
                            }
                            default: {
                                System.out.println("Podano bledna wartosc");
                                break;
                            }
                        }
                    }
                } while (endOfPlacesTheShips == false);
            } while (endOfPlacesTheShips == false);
        }
    }

    private static void PlacesTheSingleShip(int sizeOfShip) {
        //TODO tworzenie obiektu ShipShipsGame
    }

    private static void beginOfTheGame(){
        //TODO stworzenie rozgrywki
    }
}
