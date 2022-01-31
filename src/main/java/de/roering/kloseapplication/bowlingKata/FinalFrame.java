package de.roering.kloseapplication.bowlingKata;

import de.roering.kloseapplication.bowlingKata.exceptions.UnjustifiedRollException;

public class FinalFrame extends Frame{

    @Override
    protected int getMaxRollCount() {
        return this.calculateSimpleScore() >= Frame.STRIKE_SPARE_PINS ? 3 : 2;
    }
}
