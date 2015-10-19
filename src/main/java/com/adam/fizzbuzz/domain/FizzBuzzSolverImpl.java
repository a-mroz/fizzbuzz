package com.adam.fizzbuzz.domain;

import com.adam.fizzbuzz.model.FizzBuzzResult;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzSolverImpl implements FizzBuzzSolver {

    public static final int DIVIDER_LOWER_BOUND = 1;
    public static final int DIVIDER_UPPER_BOUND = 20;
    public static final int RANGE_LOWER_BOUND = 10;
    public static final int RANGE_UPPER_BOUND = 100;
    public static final String FIRST_DIVISOR_STR = "F";
    public static final String SECOND_DIVISOR_STR = "B";
    public static final String BOTH_DIVISORS_STR = FIRST_DIVISOR_STR + SECOND_DIVISOR_STR;

    @Override
    public FizzBuzzResult solve(int divider1, int divider2, int range) {
        validateDivider(divider1);
        validateDivider(divider2);
        validateRange(range);

        return new FizzBuzzResult(String.format("%d %d %d", divider1, divider2, range), solveFizzBuzz(divider1, divider2, range));
    }


    private void validateRange(int range) {
        if (range < RANGE_LOWER_BOUND || range > RANGE_UPPER_BOUND)
            throw new IllegalArgumentException(String.format("Range must be within range <%d, %d>", RANGE_LOWER_BOUND, RANGE_UPPER_BOUND));
    }

    private void validateDivider(int divider) {
        if (divider < DIVIDER_LOWER_BOUND || divider > DIVIDER_UPPER_BOUND)
            throw new IllegalArgumentException(String.format("Divider must be within range <%d, %d>", DIVIDER_LOWER_BOUND, DIVIDER_UPPER_BOUND));
    }

    private String solveFizzBuzz(final int divider1, final int divider2, int range) {
        return IntStream.rangeClosed(1, range).mapToObj(i -> solveSingle(i, divider1, divider2)).collect(Collectors.joining(" "));
    }

    private String solveSingle(int current, int divider1, int divider2) {
        if (current % divider1 == 0 && current % divider2 == 0) {
            return BOTH_DIVISORS_STR;
        } else if (current % divider1 == 0) {
            return FIRST_DIVISOR_STR;
        } else if (current % divider2 == 0) {
            return SECOND_DIVISOR_STR;
        }

        return String.valueOf(current);
    }


}
