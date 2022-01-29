package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;

import java.nio.file.FileAlreadyExistsException;

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
        Exception e = assertThrows(UnjustifiedRollException.class, () -> {
            FinalFrame f = new FinalFrame();
            f.addRoll(0);
            f.addRoll(0);
            f.addRoll(0);
        });
    }
}
