package com.sda.zdjavapol107.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GrammarCheckTest {
//    ANNOTACJE !
//    @Mock
//    private Censore censore;
//
//    @InjectMocks
//    private GrammarCheck grammarCheck;

//STATYCZNA METODA !!!
    private Censore censore = Mockito.mock(Censore.class);
    private GrammarCheck grammarCheck = new GrammarCheck(censore);

//    private Censore censore = new Censore();
//    private GrammarCheck grammarCheck = new GrammarCheck(censore);


    @Test
    public void sentenceWithoutDotShouldBeCorrectedByAddingDot(){
        // GIVEN
        String text = "Moje zdanie";

        // WHEN
        when(censore.censore(eq("Moje zdanie."))).thenReturn("Moje zdanie.");
        String result = grammarCheck.correct(text);

        // THEN
        assertEquals("Moje zdanie.", result);
    }

    @Test
    public void sentenceWithoutDotShouldBeCorrectedByAddingDot2(){
        // GIVEN
        String text = "kurde zdanie";

        // WHEN
        when(censore.censore(eq("kurde zdanie."))).thenReturn("kurde zdanie.");
        String result = grammarCheck.correct(text);

        // THEN
        assertEquals("kurde zdanie.", result);
    }
}