package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegularFrameTest {

    @Test
    void testStrikeAndTwoThrowsShouldThrowUnjustifiedThrowException(){
        Exception e = assertThrows(UnjustifiedThrowException.class, () -> {
            RegularFrame f = new RegularFrame();
            f.addRoll(10);
            f.addRoll(10);
        });
    }
}
