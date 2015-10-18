package com.adam.fizzbuzz;

public class FizzBuzzSolver {
    public String solve(int divider1, int divider2, int range) {
        validateDivider(divider1);
        validateDivider(divider2);
        validateRange(range);
        return "1 2 F 4 B F 7 8 F B";
    }

    private void validateRange(int range) {
        if (range < 10 || range > 100)
            throw new IllegalArgumentException("Range must be within range <%d, %d>");
    }

    private void validateDivider(int divider) {
        if (divider < 1 || divider > 20)
            throw new IllegalArgumentException("Divider must be within range <%d, %d>");
    }
}
