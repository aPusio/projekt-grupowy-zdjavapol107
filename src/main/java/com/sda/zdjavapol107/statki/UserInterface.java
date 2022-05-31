package com.sda.zdjavapol107.statki;

public class UserInterface {

    public static void printStartingMenuLabel(){
        System.out.println("------------------------------------------- \n" +
                "----------------MENU - STATKI-------------- \n" +
                "------------------------------------------- \n\n");
    }

    public static void printStartingMenu(){
        System.out.println("Wybierz od 1 - 3 by rozpoczac gre \n" +
                "1 - Nowa Gra \n" +
                "2 - Wczytaj gre \n" +
                "3 - Zakoncz \n");
    }

    public static void printSingleLine(String text){
        System.out.println(text);
    }

    public static void haveYouPlayed(){
        System.out.println("Czy juz grales w gre statki na naszym portalu? \n" +
                "y - Tak, n - Nie");
    }

    public static void creatingNewUser(){
        System.out.println("----------------------------\n" +
                "Tworzenie nowego uzytkownika\n" +
                "----------------------------\n" +
                "Podaj swoj nick w grze: \n\n");
    }

    public static void placingTheShips(){
        System.out.println("W grze statki kazdy z graczy ma 10 statkow do rozstawienia na swojej planszy \n" +
                "Podaj rodzaj statku od 1 do 4 ktory chcesz umiescic na swojej planszy \n");
    }

    public static void lastShipsToPlace(){
        System.out.println("Pozostalo statkow do rozstawienia: \n" +
                "Cztero-masztowce: " + ShipsMain.fourSizeShip + "\n" +
                "Troj-masztowce: " + ShipsMain.threeSizeShip+ "\n" +
                "Dwu-masztowce: " + ShipsMain.twoSizeShip + "\n" +
                "Jedno-masztowce: " + ShipsMain.oneSizeShip + "\n");
    }

    public static void dontHaveAnyMoreShipsOfThatSize(){
        System.out.println("-------------------------------------------------- \n" +
                "Nie posidasz juz statkow tej wielkosci do rozstawienia \n" +
                "-------------------------------------------------- \n");
    }

    public static void newShipDirection(){
        System.out.println("W ktora strone ma zostac skierowany statek? \n" +
                "1 - W gore \n" +
                "2 - W prawo \n" +
                "3 - W dol \n" +
                "4 - W lewo \n");
    }
    public static void selectedStartingPointOfCreatingShip(){
        System.out.println("W jakim punkcie chcesz umiescic statek? \n" +
                "Podaj wartosc wiersza (1 - 10): ");
    }
}
