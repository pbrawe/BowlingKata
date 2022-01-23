package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RollTest {
    @Test
    void testScoreShouldReturnCorrectScore(){
        assertEquals(new Roll(3).getHitPins(), 3);
    }
}
