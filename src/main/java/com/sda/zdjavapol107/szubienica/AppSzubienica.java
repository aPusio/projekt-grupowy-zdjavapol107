package com.sda.zdjavapol107.szubienica;

import java.util.Scanner;

public class AppSzubienica {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String szubienica = "      _________\n" +
                "     |/        |\n" +
                "     |         |\n" +
                "     |         |\n" +
                "     |\n" +
                "     |       (x_x)\n" +
                "     |        /|\\\n" +
                "     |         |\n" +
                " ____|____    / \\" +
                "__SZUBIENICA__\n";

        String next;
        boolean exit = false;

        while (!exit) {
            System.out.println(szubienica);

            System.out.println();
            System.out.println("1. NOWA GRA");
            System.out.println("2. WCZYTAJ GRE");
            System.out.println("3. RANKING GRACZY");
            System.out.println("4. WYJDZ Z GRY");

            next = scanner.next();

            switch (next) {
                case "1" : {
                    System.out.println("nowa gra");
                    break;
                }
                case "2" : {
                    System.out.println("wczytaj gre");
                    break;
                }
                case "3" : {
                    System.out.println("ranking graczy");
                    break;
                }
                case "4" : {
                    exit = true;
                    break;
                }
                default : {
                    System.out.println("Wybierz ponownie.");
                    break;
                }
            }
        }



    }
}
