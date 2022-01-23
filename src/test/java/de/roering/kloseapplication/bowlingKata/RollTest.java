package de.roering.kloseapplication.bowlingKata;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RollTest {
    // todo is this rly needed? Its testing a getter...
    @Test
    void testScoreShouldReturnCorrectScore(){
        final int rand = new Random(10).nextInt() + 1;
        assertEquals(new Roll(rand).getHitPins(), rand);
    }
}
