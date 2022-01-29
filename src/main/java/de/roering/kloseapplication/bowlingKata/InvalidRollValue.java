package de.roering.kloseapplication.bowlingKata;

public class InvalidRollValue extends Exception {
    public InvalidRollValue(char value){
        super(String.format("invalid Roll Value of '%s'", value));
    }
}
