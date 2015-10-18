package com.adam.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FizzBuzzSolverTest {
    private FizzBuzzSolver solver;

    @Before
    public void setUp() throws Exception {
        solver = new FizzBuzzSolver();

    }

    @Test(expected = IllegalArgumentException.class)
    public void firstDividerMustBeGreaterThanLowerBound() throws Exception {
        solver.solve(-1, 1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void firstDividerMustBeLowerThanLowerBound() throws Exception {
        solver.solve(21, 1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondDividerMustBeGreaterThanLowerBound() throws Exception {
        solver.solve(1, -1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondDividerMustBeLowerThanLowerBound() throws Exception {
        solver.solve(1, 21, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rangeDividerMustBeGreaterThanLowerBound() throws Exception {
        solver.solve(1, 1, 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rangeDividerMustBeLowerThanLowerBound() throws Exception {
        solver.solve(1, 1, 101);
    }


    @Test
    public void itWorks() throws Exception {
        assertEquals("1 2 F 4 B F 7 8 F B", solver.solve(3, 5, 10));

    }
}
