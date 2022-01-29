package de.roering.kloseapplication.bowlingKata;

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
        return this.calculateSimpleScore() >= 10 ? 3 : 2;
    }
}
