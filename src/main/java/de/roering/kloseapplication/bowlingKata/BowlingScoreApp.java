package de.roering.kloseapplication.bowlingKata;

import java.util.*;

public class BowlingScoreApp {
    private final Frame[] frames = new Frame[10];
    public BowlingScoreApp(String[] input) throws InvalidRollValue, UnjustifiedRollException {
        this.parseFrames(input);
    }

    private void parseFrames(String[] frameStrings) throws InvalidRollValue, UnjustifiedRollException {
        List <char[]> rollsList = Arrays.stream(frameStrings).map(String::toCharArray).toList();
        for (int i = 0; i < rollsList.size(); i++){
            Frame frame = parseFrame(rollsList.get(i), i +1 == rollsList.size());
            frames[i] = frame;
        }
    }

    private Frame parseFrame(char[] rolls, boolean isFinalFrame) throws InvalidRollValue, UnjustifiedRollException {
        Frame frame;
        if (isFinalFrame) frame = new RegularFrame();
        else frame = new FinalFrame();

        for(char roll : rolls){
            final ArrayList<Roll> frameRolls = frame.getRolls();
            final int lastValue = frameRolls.isEmpty() ? 0 : frameRolls.get(frameRolls.size() -1).getHitPins();
            final int rollValue = parseRollValue(roll, lastValue);
            frame.addRoll(rollValue);
        }
        return frame;
    }

    private int parseRollValue(char value, int lastValue) throws InvalidRollValue{
        int digitValue = Character.getNumericValue(value);
        if (digitValue >= 0 && digitValue <= 9) return digitValue;
        else if (value == '-') return 0;
        else if (value == 'X') return Frame.STRIKE_SPARE_PINS;
        else if (value == '/') return Frame.STRIKE_SPARE_PINS - lastValue;
        else throw new InvalidRollValue(value);
    }

    public int getScore() {
        return Arrays.stream(frames).map(Frame::calculateSimpleScore).mapToInt(Integer::intValue).sum();
    }
}
