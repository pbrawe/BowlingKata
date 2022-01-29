package de.roering.kloseapplication.bowlingKata;

public class Frame {
    private final static int STRIKE_PINS = 10;
    private Roll roll1, roll2;
    public Frame(Roll roll1, Roll roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    private int getSecondRollHitPins(){
        return roll1.getHitPins() == STRIKE_PINS ? 0 : roll2.getHitPins();
    }
    public int calculateSimpleScore() {
        return roll1.getHitPins() + getSecondRollHitPins();
    }
}
