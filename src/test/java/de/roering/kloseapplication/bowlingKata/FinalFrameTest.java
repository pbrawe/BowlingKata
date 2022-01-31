package de.roering.kloseapplication.bowlingKata;

import de.roering.kloseapplication.bowlingKata.exceptions.UnjustifiedRollException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FinalFrameTest {

    @Test
    void testStrikeAndTwoThrowsShouldNotThrowUnjustifiedRollException() throws UnjustifiedRollException {
        FinalFrame f = new FinalFrame();
        f.addRoll(10);
        f.addRoll(10);
        assert(true);
    }

    @Test
    void testThreeRollsShouldThrowUnjustifiedRollException(){
        assertThrows(UnjustifiedRollException.class, () -> {
            FinalFrame f = new FinalFrame();
            f.addRoll(0);
            f.addRoll(0);
            f.addRoll(0);
        });
    }

    @Test
    void testThreeStrikesShouldReturnSimpleScoreThirty() throws UnjustifiedRollException {
        FinalFrame f = new FinalFrame();
        f.addRoll(10);
        f.addRoll(10);
        f.addRoll(10);
        assertEquals(30, f.calculateSimpleScore());
    }
}
