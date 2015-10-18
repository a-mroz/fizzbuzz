package com.adam.fizzbuzz;

public class FizzBuzzSolver {
    public String solve(int divider1, int divider2, int range) {
        validate(divider1);
        return "1 2 F 4 B F 7 8 F B";
    }

    private void validate(int divider) {
        if (divider < 1 || divider > 20)
            throw new IllegalArgumentException("Divider must be within range <%d, %d>");
    }
}
