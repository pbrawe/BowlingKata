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

    @Test
    void testTwelveStrikesShouldReturnScoreThreeHundred() throws InvalidRollValue, UnjustifiedRollException {
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "XXX"});
        assertEquals(300, app.getScore());
    }

    @Test
    void testNineTimesNineAndMissWithFinalSparePlusNineShouldReturnScoreHundred() throws InvalidRollValue, UnjustifiedRollException {
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
                        "9/9"});
        assertEquals(100, app.getScore());
    }

    // This is the rarest score in bowling:)
    // (claimed by a guy on quora)
    @Test
    void testElevenStrikesWithAFinalToShouldReturnScoreTwoHundredNinetyTwo() throws InvalidRollValue, UnjustifiedRollException {
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "X",
                        "XX2"});
        assertEquals(292, app.getScore());
    }

    @Test
    void testRecurringMissesAndSparesShouldReturnScoreHundred() throws InvalidRollValue, UnjustifiedRollException {
        BowlingScoreApp app = new BowlingScoreApp(
                new String[]{
                        "0/",
                        "0/",
                        "0/",
                        "0/",
                        "0/",
                        "0/",
                        "0/",
                        "0/",
                        "0/",
                        "0/0"});
        assertEquals(100, app.getScore());
    }
}
