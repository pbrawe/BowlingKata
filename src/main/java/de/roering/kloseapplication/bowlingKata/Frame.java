package de.roering.kloseapplication.bowlingKata;

import java.util.ArrayList;

public abstract class Frame {
    public final static int STRIKE_PINS = 10;
    private final ArrayList<Roll> rolls;
    public Frame() {
        this.rolls = new ArrayList<>();
    }

    protected ArrayList<Roll> getRolls(){
        return this.rolls;
    }

    public int calculateSimpleScore() {
        return this.getRolls().stream().mapToInt(Roll::getHitPins).sum();
    }
    // todo change return type to Frame for immutability?
    public abstract void addRoll(int hitPins) throws UnjustifiedRollException;
}
