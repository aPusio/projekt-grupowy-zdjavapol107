package com.sda.zdjavapol107.szubienica.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void shouldPrintWordWithTypedLetters() {
        //given
        GameService gameService = new GameService();
        //when
        Boolean result = gameService.printWordState("kura", List.of('k', 'u', 'r', 'a'));
        //then
        assertEquals(true, result);
    }
}