package de.roering.kloseapplication.bowlingKata;

public class RegularFrame extends Frame{

    @Override
    public void addRoll(int hitPins) throws UnjustifiedThrowException {
        if (!this.getRolls().isEmpty() && this.getRolls().get(0).getHitPins() == Frame.STRIKE_PINS){
            throw new UnjustifiedThrowException();
        }
        else {
            this.getRolls().add(new Roll(hitPins));
        }
    }
}
