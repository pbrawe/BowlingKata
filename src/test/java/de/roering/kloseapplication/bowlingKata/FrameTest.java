package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FrameTest {
    public int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Test
    void testNoHitsShouldReturnSimpleScoreZero() throws UnjustifiedThrowException {
        Frame f = new Frame(new Roll(0), new Roll(0));
        assertEquals(0, f.calculateSimpleScore());
    }

    @Test
    void testTwoTimesFiveHitsShouldReturnSimpleScoreTen() throws UnjustifiedThrowException {
        Frame f = new Frame(new Roll(5), new Roll(5));
        assertEquals(10, f.calculateSimpleScore());
    }

    @Test
    void testRandomSpareShouldReturnSimpleScoreTen() throws UnjustifiedThrowException {
        int rand = getRandomNumberInRange(1, 10);
        // prevent strikes, as rand is used for the first roll
        while(rand == 10){
            rand = new Random(10).nextInt() + 1;
        }
        Frame f = new Frame(new Roll(rand), new Roll(10 - rand));
        assertEquals(10, f.calculateSimpleScore());
    }

    @Test
    void testStrikeAndTwoThrowsShouldThrowUnjustifiedThrowException(){
        Exception e = assertThrows(UnjustifiedThrowException.class, () -> {
            Frame f = new Frame(new Roll(10), new Roll(10));
        });
    }

    @Test
    void testStrikeShouldReturnSimpleScoreTen(){
        final int RAND = getRandomNumberInRange(1, 10);
        Frame f = new Frame(new Roll(10));
        assertEquals(10, f.calculateSimpleScore());
    }
}
