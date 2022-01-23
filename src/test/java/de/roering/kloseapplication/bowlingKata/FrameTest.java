package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {
    @Test
    void testNoHitsShouldReturnScoreZero(){
        Frame f = new Frame(new Roll(0), new Roll(0));
        assertEquals(0, f.calculateSimpleScore());
    }

    @Test
    void testTwoTimesFiveHitsShouldReturnScoreTen(){
        Frame f = new Frame(new Roll(5), new Roll(6));
        assertEquals(10, f.calculateSimpleScore());
    }
}
