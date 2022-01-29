package de.roering.kloseapplication.bowlingKata;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
    public final static int STRIKE_SPARE_PINS = 10;
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

    protected abstract int getMaxRollCount();

    public boolean isStrike(){
        return this.getRolls().stream().anyMatch(roll -> roll.getHitPins() == 10);
    }

    public boolean isSpare(){
        return this.getRolls().stream().map(Roll::getHitPins).mapToInt(Integer::intValue).sum() >= 10;
    }

    // when a spare or strike is present, the rolls of the next frame(s) are necessary to calculate the current
    // frames total score
    public int calculateTotalScore(List<Frame> nextFrames){
        final boolean isStrike = this.isStrike();
        final boolean isSpare = this.isSpare();
        int score = this.calculateSimpleScore();
        List<Roll> nextRolls = nextFrames.stream().flatMap(frame -> frame.getRolls().stream()).toList();
        if (isStrike){
            return this.calculateSimpleScore() + calculateSimpleScoreOfNextNRolls(nextRolls, 2);
        }
        else if (isSpare){
            return this.calculateSimpleScore() + calculateSimpleScoreOfNextNRolls(nextRolls, 1);
        }
        else return this.calculateSimpleScore();
    }

    public int calculateSimpleScoreOfNextNRolls(List<Roll> nextRolls, int n){
        int score = 0;
        for (int i = 0; i < n && i < nextRolls.size(); i++){
            score += nextRolls.get(i).getHitPins();
        }
        return score;
    }
}
