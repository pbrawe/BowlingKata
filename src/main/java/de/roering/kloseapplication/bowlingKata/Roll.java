package de.roering.kloseapplication.bowlingKata;

public class Roll {
    private int hitPins;
    public Roll(int hitPins) {
        this.hitPins = hitPins;
    }

    public int getHitPins() {
        return this.hitPins;
    }

    public static int parseRollValueFromChar(char value, int previousValue) throws InvalidRollValueException {
        int digitValue = Character.getNumericValue(value);
        if (digitValue >= 0 && digitValue <= 9) return digitValue;
        else if (value == '-') return 0;
        else if (value == 'X') return Frame.STRIKE_SPARE_PINS;
        else if (value == '/') return Frame.STRIKE_SPARE_PINS - previousValue;
        else throw new InvalidRollValueException(value);
    }
}
