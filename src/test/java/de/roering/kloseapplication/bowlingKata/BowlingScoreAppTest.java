package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingScoreAppTest {
    @Test
    void testNoHitsShouldReturnScoreZero() throws InvalidRollValue {
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
    void testTenTimesFiveAndMissShouldReturnScoreNinety() throws InvalidRollValue {
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{
                        "5-",
                        "5-",
                        "5-",
                        "5-",
                        "5-",
                        "5-",
                        "5-",
                        "5-",
                        "5-",
                        "5-"});
        assertEquals(90, app.getScore());
    }
}
