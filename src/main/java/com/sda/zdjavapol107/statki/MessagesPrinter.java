package com.sda.zdjavapol107.statki;

public class MessagesPrinter {

    public void printStartingMenuLabel(){
        System.out.println("------------------------------------------- \n" +
                "----------------MENU - STATKI-------------- \n" +
                "------------------------------------------- \n\n");
    }

    public void printStartingMenu(){
        System.out.println("Wybierz od 1 - 3 by rozpoczac gre \n" +
                "1 - Nowa Gra \n" +
                "2 - Wczytaj gre \n" +
                "3 - Zakoncz \n");
    }

    public void printSingleLine(String text){
        System.out.println(text);
    }

    public void haveYouPlayed(){
        System.out.println("Czy juz grales w gre statki na naszym portalu? \n" +
                "y - Tak, n - Nie");
    }

    public void creatingNewUser(){
        System.out.println("----------------------------\n" +
                "Tworzenie nowego uzytkownika\n" +
                "----------------------------\n" +
                "Podaj swoj nick w grze: \n\n");
    }

    public void placingTheShips(){
        System.out.println("W grze statki kazdy z graczy ma 10 statkow do rozstawienia na swojej planszy \n" +
                "Podaj rodzaj statku od 1 do 4 ktory chcesz umiescic na swojej planszy \n");
    }

    public void lastShipsToPlace(int fourSizeShip, int threeSizeShip, int twoSizeShip, int oneSizeShip){
        System.out.println("Statki do rozstawienia: \n" +
                "Wybierz rodzaj statku wybierajac przyporzadkowana im wartosc: \n" +
                "(1) Jedno-masztowce - pozostala ilosc: " + oneSizeShip + "\n" +
                "(2) Dwu-masztowce - pozostala ilosc: " + twoSizeShip + "\n" +
                "(3) Trzy-masztowce - pozostala ilosc: " + threeSizeShip + "\n" +
                "(4) Cztero-masztowce - pozostala ilosc: " + fourSizeShip + "\n");
    }

    public void dontHaveAnyMoreShipsOfThatSize(){
        System.out.println("-------------------------------------------------- \n" +
                "Nie posidasz juz statkow tej wielkosci do rozstawienia \n" +
                "-------------------------------------------------- \n");
    }

    public void chooseShipDirection(){
        System.out.println("W ktora strone ma zostac skierowany statek? \n" +
                "1 - W gore \n" +
                "2 - W prawo \n" +
                "3 - W dol \n" +
                "4 - W lewo \n");
    }
    public void selectedStartingPointOfCreatingShip(){
        System.out.println("W jakim punkcie chcesz umiescic statek? \n" +
                "Podaj wartosc wiersza (1 - 10): ");
    }

    public void errorInputValue() {
        System.out.println("Wprowadzono bledna wartosc + \n");
    }
}
