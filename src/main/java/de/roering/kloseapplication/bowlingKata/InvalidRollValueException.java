package de.roering.kloseapplication.bowlingKata;

public class InvalidRollValueException extends Exception {
    public InvalidRollValueException(char value){
        super(String.format("invalid Roll Value of '%s'", value));
    }
}
