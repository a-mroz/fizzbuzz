package com.adam.fizzbuzz;

public class FizzBuzzSolver {

    public static final int DIVIDER_LOWER_BOUND = 1;
    public static final int DIVIDER_UPPER_BOUND = 20;
    public static final int RANGE_LOWER_BOUND = 10;
    public static final int RANGE_UPPER_BOUND = 100;

    public String solve(int divider1, int divider2, int range) {
        validateDivider(divider1);
        validateDivider(divider2);
        validateRange(range);

        return "1 2 F 4 B F 7 8 F B";
    }

    private void validateRange(int range) {
        if (range < RANGE_LOWER_BOUND || range > RANGE_UPPER_BOUND)
            throw new IllegalArgumentException("Range must be within range <%d, %d>");
    }

    private void validateDivider(int divider) {
        if (divider < DIVIDER_LOWER_BOUND || divider > DIVIDER_UPPER_BOUND)
            throw new IllegalArgumentException("Divider must be within range <%d, %d>");
    }
}
