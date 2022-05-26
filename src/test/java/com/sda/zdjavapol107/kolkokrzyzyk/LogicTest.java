package com.sda.zdjavapol107.kolkokrzyzyk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @Test
    void shouldReturnTrueIfWinIsInRows() {
        // given
        char activePlayerSymbol = 'X';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[0][1] = activePlayerSymbol;
        board[0][2] = activePlayerSymbol;
        // when
        boolean result = Logic.checkWinInRows(board, activePlayerSymbol);
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
        boolean result = Logic.checkWinInRows(board, activePlayerSymbol);
        // then
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueIfWinIsInColumns() {
        // given
        char activePlayerSymbol = 'Y';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[1][0] = activePlayerSymbol;
        board[2][0] = activePlayerSymbol;
        // when
        boolean result = Logic.checkWinInColumns(board, activePlayerSymbol);
        // then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseIfWinIsNotInColumns() {
        // given
        char activePlayerSymbol = 'Y';
        char[][] board = new char[3][3];
        board[0][0] = activePlayerSymbol;
        board[0][1] = activePlayerSymbol;
        board[2][2] = activePlayerSymbol;
        // when
        boolean result = Logic.checkWinInColumns(board, activePlayerSymbol);
        // then
        assertFalse(result);
    }
}