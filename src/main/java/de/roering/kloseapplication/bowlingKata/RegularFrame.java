package de.roering.kloseapplication.bowlingKata;

import de.roering.kloseapplication.bowlingKata.exceptions.UnjustifiedRollException;

public class RegularFrame extends Frame{

    @Override
    protected int getMaxRollCount() {
        if (!this.getRolls().isEmpty() && this.getRolls().get(0).getHitPins() == Frame.STRIKE_SPARE_PINS)
            return 1;
        else return 2;
    }
}
