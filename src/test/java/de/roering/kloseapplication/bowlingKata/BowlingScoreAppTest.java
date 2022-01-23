package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingScoreAppTest {
    @Test
    void testNoHitsShouldReturnScoreZero(){
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{"0", "0",
                        "0", "0",
                        "0", "0",
                        "0", "0",
                        "0", "0",
                        "0", "0",
                        "0", "0",
                        "0", "0",
                        "0", "0",
                        "0", "0"});
        assertEquals(0, app.getScore());
    }
}
