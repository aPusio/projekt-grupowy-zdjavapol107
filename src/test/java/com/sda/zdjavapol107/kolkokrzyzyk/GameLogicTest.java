package com.sda.zdjavapol107.kolkokrzyzyk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @Test
    void shouldReturnTrueIfWinIsInRows() {
        // given
        char activePlayerSymbol = 'X';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[0][1] = activePlayerSymbol;
        board[0][2] = activePlayerSymbol;
        // when
        boolean result = GameLogic.checkWinInRows(board, activePlayerSymbol);
        // then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfWinIsNotInRows() {
        // given
        char activePlayerSymbol = 'X';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[0][1] = activePlayerSymbol;
        board[2][2] = activePlayerSymbol;
        // when
        boolean result = GameLogic.checkWinInRows(board, activePlayerSymbol);
        // then
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfWinIsInColumns() {
        // given
        char activePlayerSymbol = 'O';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[1][0] = activePlayerSymbol;
        board[2][0] = activePlayerSymbol;
        // when
        boolean result = GameLogic.checkWinInColumns(board, activePlayerSymbol);
        // then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfWinIsNotInColumns() {
        // given
        char activePlayerSymbol = 'O';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[0][1] = activePlayerSymbol;
        board[2][2] = activePlayerSymbol;
        // when
        boolean result = GameLogic.checkWinInColumns(board, activePlayerSymbol);
        // then
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfWinIsInFirstDiagonal() {
        //given
        char activePlayerSymbol = 'X';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[1][1] = activePlayerSymbol;
        board[2][2] = activePlayerSymbol;
        //when
        boolean result = GameLogic.checkWinInFirstDiagonal(board, activePlayerSymbol);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfWinIsNotInFirstDiagonal() {
        //given
        char activePlayerSymbol = 'X';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[1][1] = activePlayerSymbol;
        board[2][2] = activePlayerSymbol;
        //when
        boolean result = GameLogic.checkWinInFirstDiagonal(board, activePlayerSymbol);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfWinIsInSecondDiagonal() {
        //given
        char activePlayerSymbol = 'O';
        char[][] board = new char[3][3];
        board[2][0] = activePlayerSymbol;
        board[1][1] = activePlayerSymbol;
        board[0][2] = activePlayerSymbol;
        //when
        boolean result = GameLogic.checkWinInSecondDiagonal(board, activePlayerSymbol);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfWinIsNotInSecondDiagonal() {
        //given
        char activePlayerSymbol = 'O';
        char[][] board = new char[3][3];
        board[2][0] = activePlayerSymbol;
        board[1][1] = activePlayerSymbol;
        board[0][2] = activePlayerSymbol;
        //when
        boolean result = GameLogic.checkWinInSecondDiagonal(board, activePlayerSymbol);
        //then
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfPlayerOneWin() {
        //given
        char playerOneSymbol = 'X';
        char playerTwoSymbol = 'O';
        char[][] board = new char[3][3];
        board[2][0] = playerOneSymbol;
        board[1][0] = playerTwoSymbol;
        board[1][1] = playerOneSymbol;
        board[0][1] = playerTwoSymbol;
        board[0][2] = playerOneSymbol;
        //when
        boolean result = GameLogic.checkWinner(board, playerOneSymbol);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfPlayerOneNoWin() {
        //given
        char playerOneSymbol = 'X';
        char playerTwoSymbol = 'O';
        char [][] board = new char[3][3];
        board[2][0] = playerOneSymbol;
        board[1][0] = playerTwoSymbol;
        board[1][1] = playerOneSymbol;
        board[0][1] = playerTwoSymbol;
        //when
        boolean result = GameLogic.checkWinner(board, playerOneSymbol);
        //then
        assertFalse(result);
    }
}