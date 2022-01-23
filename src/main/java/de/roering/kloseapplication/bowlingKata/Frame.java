package de.roering.kloseapplication.bowlingKata;

public class Frame {
    private Roll roll1, roll2;
    public Frame(Roll roll1, Roll roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    public int calculateSimpleScore() {
        return roll1.getHitPins() + roll2.getHitPins();
    }
}
