package com.adam.fizzbuzz.domain.exceptions;


public class DividerArgumentOutOfBoundsException extends ArgumentOutOfBoundsException {

    public DividerArgumentOutOfBoundsException(int lowerBound, int upperBound) {
        super(lowerBound, upperBound);
    }

}
