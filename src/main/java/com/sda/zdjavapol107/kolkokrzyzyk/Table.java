package com.sda.zdjavapol107.kolkokrzyzyk;

import java.util.Arrays;
import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        System.out.println("Please state the dimensions of the table");
        int dimensions = new Scanner(System.in).nextInt();
        char[][] board = new char[dimensions][dimensions];
        System.out.println("Dimensions selected are " + dimensions + " by " + dimensions);
        displayBoard(board);
    }

    static void displayBoard(char[][] board) {
        int dimensions = board.length;
        System.out.print("\t");
        for (int i = 0; i < dimensions; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int row = 0; row < dimensions; row++){
            System.out.print(row + ":\t");
            for (int column = 0; column < dimensions; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
