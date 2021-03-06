package de.roering.kloseapplication.bowlingKata;

import de.roering.kloseapplication.bowlingKata.exceptions.UnjustifiedRollException;

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

    protected abstract int getMaxRollCount();

    // todo change return type to Frame for immutability?
    public void addRoll(int hitPins) throws UnjustifiedRollException {
        if (this.getRolls().size() >= this.getMaxRollCount()){
            throw new UnjustifiedRollException();
        }
        else {
            this.getRolls().add(new Roll(hitPins));
        }
    }

    public boolean isStrike(){
        return !this.getRolls().isEmpty() && this.getRolls().get(0).getHitPins() == STRIKE_SPARE_PINS;
    }

    public boolean isSpare(){
        return this.getRolls().stream().map(Roll::getHitPins).mapToInt(Integer::intValue).sum() >= 10;
    }

    // when a spare or strike is present, the rolls of the next frame(s) are necessary to calculate the current
    // frames total score
    public int calculateTotalScore(List<Frame> nextFrames){
        final boolean isStrike = this.isStrike();
        final boolean isSpare = this.isSpare();
        List<Roll> nextRolls = nextFrames.stream().flatMap(frame -> frame.getRolls().stream()).toList();
        if (isStrike){
            return this.calculateSimpleScore() + calculateSimpleScoreOfNextNRolls(nextRolls, 2);
        }
        else if (isSpare){
            return this.calculateSimpleScore() + calculateSimpleScoreOfNextNRolls(nextRolls, 1);
        }
        else return this.calculateSimpleScore();
    }

    private int calculateSimpleScoreOfNextNRolls(List<Roll> nextRolls, int n){
        int score = 0;
        for (int i = 0; i < n && i < nextRolls.size(); i++){
            score += nextRolls.get(i).getHitPins();
        }
        return score;
    }
}
