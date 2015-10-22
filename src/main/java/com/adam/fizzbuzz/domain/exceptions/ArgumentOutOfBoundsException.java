package com.adam.fizzbuzz.domain.exceptions;


public abstract class ArgumentOutOfBoundsException extends RuntimeException {

    private final int lowerBound;
    private final int upperBound;

    public ArgumentOutOfBoundsException(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }
}
