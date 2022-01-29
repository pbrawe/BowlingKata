package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingScoreAppTest {
    @Test
    void testNoHitsShouldReturnScoreZero() throws InvalidRollValue, UnjustifiedRollException {
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{
                        "00",
                        "00",
                        "00",
                        "00",
                        "00",
                        "00",
                        "00",
                        "00",
                        "00",
                        "00"});
        assertEquals(0, app.getScore());
    }

    @Test
    void testTenTimesNineAndMissShouldReturnScoreNinety() throws InvalidRollValue, UnjustifiedRollException {
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{
                        "9-",
                        "9-",
                        "9-",
                        "9-",
                        "9-",
                        "9-",
                        "9-",
                        "9-",
                        "9-",
                        "9-"});
        assertEquals(90, app.getScore());
    }

    @Test
    void testTenTimesFiveAndSpareWithFinalAdditionalFiveShouldReturnScoreHundredFifty() throws InvalidRollValue, UnjustifiedRollException {
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{
                        "5/",
                        "5/",
                        "5/",
                        "5/",
                        "5/",
                        "5/",
                        "5/",
                        "5/",
                        "5/",
                        "5/5"});
        assertEquals(150, app.getScore());
    }
}
