package org.example;

public class ExceptionThrower {

    public void throwException(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Negative values are not allowed!");
        }
    }
}