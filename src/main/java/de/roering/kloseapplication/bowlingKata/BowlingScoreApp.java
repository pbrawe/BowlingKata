package de.roering.kloseapplication.bowlingKata;

import de.roering.kloseapplication.bowlingKata.exceptions.InvalidRollValueException;
import de.roering.kloseapplication.bowlingKata.exceptions.UnjustifiedRollException;

import java.util.*;

public class BowlingScoreApp {
    private final int FRAME_COUNT = 10;
    private final Frame[] frames = new Frame[FRAME_COUNT];
    public BowlingScoreApp(String[] input) throws InvalidRollValueException, UnjustifiedRollException {
        this.parseFrames(input);
    }

    private void parseFrames(String[] frameStrings) throws InvalidRollValueException, UnjustifiedRollException {
        List <char[]> rollsList = Arrays.stream(frameStrings).map(String::toCharArray).toList();
        for (int i = 0; i < rollsList.size(); i++){
            if (i > FRAME_COUNT) throw new UnjustifiedRollException("more than %d rolls are not allowed.");
            Frame frame = parseFrame(rollsList.get(i), i +1 == rollsList.size());
            frames[i] = frame;
        }
    }

    private Frame parseFrame(char[] rolls, boolean isFinalFrame) throws InvalidRollValueException, UnjustifiedRollException {
        Frame frame;
        if (!isFinalFrame) frame = new RegularFrame();
        else frame = new FinalFrame();

        for(char roll : rolls){
            final ArrayList<Roll> frameRolls = frame.getRolls();
            final int lastValue = frameRolls.isEmpty() ? 0 : frameRolls.get(frameRolls.size() -1).getHitPins();
            final int rollValue = Roll.parseRollValueFromChar(roll, lastValue);
            frame.addRoll(rollValue);
        }
        return frame;
    }

    public int getScore() {
        int sum =  0;
        for (int i = 0; i < this.frames.length; i++){
            final List<Frame> nextFrames = Arrays.stream(Arrays.copyOfRange(this.frames, i + 1, this.frames.length)).toList();
            sum += frames[i].calculateTotalScore(nextFrames);
        }
        return sum;
    }
}
