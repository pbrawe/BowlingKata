package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {
    public int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Test
    void testNoHitsShouldReturnSimpleScoreZero(){
        Frame f = new Frame(new Roll(0), new Roll(0));
        assertEquals(0, f.calculateSimpleScore());
    }

    @Test
    void testTwoTimesFiveHitsShouldReturnSimpleScoreTen(){
        Frame f = new Frame(new Roll(5), new Roll(5));
        assertEquals(10, f.calculateSimpleScore());
    }

    @Test
    void testRandomSpareShouldReturnSimpleScoreTen(){
        int rand = getRandomNumberInRange(1, 10);
        // prevent strikes, as rand is used for the first roll
        while(rand == 10){
            rand = new Random(10).nextInt() + 1;
        }
        Frame f = new Frame(new Roll(rand), new Roll(10 - rand));
        assertEquals(10, f.calculateSimpleScore());
    }
    
    @Test
    void testStrikeShouldReturnSimpleScoreTen(){
        final int RAND = getRandomNumberInRange(1, 10);
        Frame f = new Frame(new Roll(10), new Roll(RAND));
        assertEquals(10, f.calculateSimpleScore());
    }
}
