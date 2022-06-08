package com.sda.zdjavapol107.szubienica.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void shouldPrintWordWithTypedLetters() {
        //given
        GameService gameService = new GameService();
        Boolean result = gameService.printWordState("kura", List.of('k', 'u'));
        //when

        //then
        //assertEquals("KU__", );
    }
}