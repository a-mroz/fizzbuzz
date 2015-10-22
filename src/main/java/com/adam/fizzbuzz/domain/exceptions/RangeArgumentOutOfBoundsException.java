package com.adam.fizzbuzz.domain.exceptions;

public class RangeArgumentOutOfBoundsException extends ArgumentOutOfBoundsException {

    public RangeArgumentOutOfBoundsException(int lowerBound, int upperBound) {
        super(lowerBound, upperBound);
    }

}
