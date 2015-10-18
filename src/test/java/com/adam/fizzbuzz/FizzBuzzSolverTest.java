package com.adam.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static com.adam.fizzbuzz.FizzBuzzSolver.*;
import static org.junit.Assert.assertEquals;

public class FizzBuzzSolverTest {
    private FizzBuzzSolver solver;

    @Before
    public void setUp() throws Exception {
        solver = new FizzBuzzSolver();
    }

    @Test(expected = IllegalArgumentException.class)
    public void firstDividerMustBeGreaterThanLowerBound() throws Exception {
        solver.solve(DIVIDER_LOWER_BOUND - 1, DIVIDER_LOWER_BOUND, RANGE_LOWER_BOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void firstDividerMustBeLessThanUpperBound() throws Exception {
        solver.solve(DIVIDER_UPPER_BOUND + 1, DIVIDER_LOWER_BOUND, RANGE_LOWER_BOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondDividerMustBeGreaterThanLowerBound() throws Exception {
        solver.solve(DIVIDER_LOWER_BOUND, DIVIDER_LOWER_BOUND - 1, RANGE_LOWER_BOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondDividerMustBeLessThanLowerBound() throws Exception {
        solver.solve(DIVIDER_LOWER_BOUND, DIVIDER_UPPER_BOUND + 1, RANGE_LOWER_BOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rangeDividerMustBeGreaterThanLowerBound() throws Exception {
        solver.solve(DIVIDER_LOWER_BOUND, DIVIDER_LOWER_BOUND, RANGE_LOWER_BOUND - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rangeDividerMustBeLowerThanLowerBound() throws Exception {
        solver.solve(DIVIDER_LOWER_BOUND, DIVIDER_LOWER_BOUND, RANGE_UPPER_BOUND + 1);
    }


    @Test
    public void itWorks() throws Exception {
        assertEquals("1 2 F 4 B F 7 8 F B", solver.solve(3, 5, 10));
    }
}
