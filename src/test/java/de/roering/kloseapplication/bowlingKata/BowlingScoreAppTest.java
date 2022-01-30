package de.roering.kloseapplication.bowlingKata;

import de.roering.kloseapplication.bowlingKata.exceptions.InvalidRollValueException;
import de.roering.kloseapplication.bowlingKata.exceptions.UnjustifiedRollException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlingScoreAppTest {
    @Test
    void testNoHitsShouldReturnScoreZero() throws InvalidRollValueException, UnjustifiedRollException {
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
    void testTenTimesNineAndMissShouldReturnScoreNinety() throws InvalidRollValueException, UnjustifiedRollException {
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
    void testTenTimesFiveAndSpareWithFinalAdditionalFiveShouldReturnScoreHundredFifty() throws InvalidRollValueException, UnjustifiedRollException {
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
    void testTwelveStrikesShouldReturnScoreThreeHundred() throws InvalidRollValueException, UnjustifiedRollException {
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
    void testNineTimesNineAndMissWithFinalSparePlusNineShouldReturnScoreHundred() throws InvalidRollValueException, UnjustifiedRollException {
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
    void testElevenStrikesWithAFinalToShouldReturnScoreTwoHundredNinetyTwo() throws InvalidRollValueException, UnjustifiedRollException {
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
    void testRecurringMissesAndSparesShouldReturnScoreHundred() throws InvalidRollValueException, UnjustifiedRollException {
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

    @Test
    void testInvalidRollValueCharShouldThrowInvalidRollValue() throws InvalidRollValueException, UnjustifiedRollException {
        Exception e = assertThrows(InvalidRollValueException.class, () -> {
            BowlingScoreApp app = new BowlingScoreApp(
                    new String[]{
                            "0/",
                            "0/",
                            "0/",
                            "0/",
                            "0%",
                            "0/",
                            "0/",
                            "0/",
                            "0/",
                            "0/0"});
        });
        assertEquals(e.getMessage(), "invalid Roll Value of '%'");
    }
}
