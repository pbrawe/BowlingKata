package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FinalFrameTest {

    @Test
    void testStrikeAndTwoThrowsShouldNotThrowUnjustifiedRollException() throws UnjustifiedRollException {
        RegularFrame f = new RegularFrame();
        f.addRoll(10);
        f.addRoll(10);
    }

    @Test
    void testThreeRollsShouldThrowUnjustifiedRollException(){
        Exception e = assertThrows(UnjustifiedRollException.class, () -> {
            RegularFrame f = new RegularFrame();
            f.addRoll(0);
            f.addRoll(0);
            f.addRoll(0);
        });
    }
}