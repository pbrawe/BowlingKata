package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {
    public int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Test
    void testNoHitsShouldReturnScoreZero(){
        Frame f = new Frame(new Roll(0), new Roll(0));
        assertEquals(0, f.calculateSimpleScore());
    }

    @Test
    void testTwoTimesFiveHitsShouldReturnSimpleScoreTen(){
        Frame f = new Frame(new Roll(5), new Roll(5));
        assertEquals(10, f.calculateSimpleScore());
    }
}
