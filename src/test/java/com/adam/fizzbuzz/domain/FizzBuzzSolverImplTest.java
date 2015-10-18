package com.adam.fizzbuzz.domain;

import org.junit.Before;
import org.junit.Test;

import static com.adam.fizzbuzz.domain.FizzBuzzSolverImpl.*;
import static org.junit.Assert.assertEquals;

public class FizzBuzzSolverImplTest {
    private FizzBuzzSolverImpl solver;

    @Before
    public void setUp() throws Exception {
        solver = new FizzBuzzSolverImpl();
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
        assertEquals("1 F 3 F 5 F B F 9 F 11 F 13 FB 15", solver.solve(2, 7, 15));

        assertEquals("1 2 3 4 5 6 7 8 9 10 11", solver.solve(20, 20, 11));
        assertEquals("FB FB FB FB FB FB FB FB FB FB", solver.solve(1, 1, 10));
        assertEquals("F FB F FB F FB F FB F FB F", solver.solve(1, 2, 11));
        assertEquals("1 2 3 4 5 6 7 8 9 10 F", solver.solve(11, 20, 11));
        assertEquals("1 2 3 4 5 6 7 8 9 10 B", solver.solve(20, 11, 11));
        assertEquals("1 2 3 4 5 6 7 8 9 10 FB", solver.solve(11, 11, 11));
        assertEquals("1 2 3 4 5 6 7 8 9 10 F 12 B", solver.solve(11, 13, 13));
    }
}
