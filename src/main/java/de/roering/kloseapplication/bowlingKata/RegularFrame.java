package de.roering.kloseapplication.bowlingKata;

public class RegularFrame extends Frame{

    @Override
    public void addRoll(int hitPins) throws UnjustifiedRollException {
        if (!this.getRolls().isEmpty() && this.getRolls().get(0).getHitPins() == Frame.STRIKE_PINS){
            throw new UnjustifiedRollException();
        }
        else {
            this.getRolls().add(new Roll(hitPins));
        }
    }
}
