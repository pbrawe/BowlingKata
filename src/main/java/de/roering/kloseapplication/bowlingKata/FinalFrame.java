package de.roering.kloseapplication.bowlingKata;

import de.roering.kloseapplication.bowlingKata.exceptions.UnjustifiedRollException;

public class FinalFrame extends Frame{
    public FinalFrame(){
        super();
    }

    @Override
    public void addRoll(int hitPins) throws UnjustifiedRollException {
        if (this.getRolls().size() >= this.getMaxRollCount()){
            throw new UnjustifiedRollException();
        }
        else {
            this.getRolls().add(new Roll(hitPins));
        }
    }

    @Override
    protected int getMaxRollCount() {
        return this.calculateSimpleScore() >= Frame.STRIKE_SPARE_PINS ? 3 : 2;
    }
}
