package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

// tests abstract class Frame but uses concrete implementation RegularFrame in order to do so
public class FrameTest {
    public int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Test
    void testNoHitsShouldReturnSimpleScoreZero() throws UnjustifiedRollException {
        RegularFrame f = new RegularFrame();
        f.addRoll(0);
        f.addRoll(0);
        assertEquals(0, f.calculateSimpleScore());
    }

    @Test
    void testTwoTimesFiveHitsShouldReturnSimpleScoreTen() throws UnjustifiedRollException {
        RegularFrame f = new RegularFrame();
        f.addRoll(5);
        f.addRoll(5);
        assertEquals(10, f.calculateSimpleScore());
    }

    @Test
    void testRandomSpareShouldReturnSimpleScoreTen() throws UnjustifiedRollException {
        int rand = getRandomNumberInRange(1, 10);
        // prevent strikes, as rand is used for the first roll
        while(rand == 10){
            rand = new Random(10).nextInt() + 1;
        }
        RegularFrame f = new RegularFrame();
        f.addRoll(rand);
        f.addRoll(10 - rand);
        assertEquals(10, f.calculateSimpleScore());
    }

    @Test
    void testStrikeShouldReturnSimpleScoreTen() throws UnjustifiedRollException {
        final int RAND = getRandomNumberInRange(1, 10);
        RegularFrame f = new RegularFrame();
        f.addRoll(10);
        assertEquals(10, f.calculateSimpleScore());
    }
}
