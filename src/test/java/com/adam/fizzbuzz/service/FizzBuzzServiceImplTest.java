package com.adam.fizzbuzz.service;

import com.adam.fizzbuzz.domain.FizzBuzzSolver;
import com.adam.fizzbuzz.domain.exceptions.RangeArgumentOutOfBoundsException;
import com.adam.fizzbuzz.model.FizzBuzzResult;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.adam.fizzbuzz.service.FizzBuzzServiceImpl.ERROR_FORMAT_MSG;
import static com.adam.fizzbuzz.service.FizzBuzzServiceImpl.ERROR_RANGE_OUT_OF_BOUNDS_MSG;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzServiceImplTest {

    @Mock
    private FizzBuzzSolver solver;

    private FizzBuzzServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = new FizzBuzzServiceImpl(solver);
    }

    @Test
    public void whenEmpty_returnsEmpty() throws Exception {
        List<FizzBuzzResult> results = service.solveFizzBuzz("");

        assertTrue(results.isEmpty());
    }

    @Test
    public void whenNotEnoughData_displaysError() throws Exception {
        String notEnoughData = "1 2 ";
        FizzBuzzResult result = service.solveFizzBuzz(notEnoughData).get(0);

        checkResultWithFormatError(result, notEnoughData);
    }

    @Test
    public void whenTooMuchData_displaysError() throws Exception {
        String tooMuchData = "1 2 3 4";
        FizzBuzzResult result = service.solveFizzBuzz(tooMuchData).get(0);

        checkResultWithFormatError(result, tooMuchData);
    }

    @Test
    public void whenNotIntegers_displaysError() throws Exception {
        String notIntDiv1 = "a 2 10";
        String notIntDiv2 = "1 b 10";
        String notIntRange = "1 2 c";

        List<FizzBuzzResult> results = service.solveFizzBuzz(String.format("%s\n%s\n%s", notIntDiv1, notIntDiv2, notIntRange));

        checkResultWithFormatError(results.get(0), notIntDiv1);
        checkResultWithFormatError(results.get(1), notIntDiv2);
        checkResultWithFormatError(results.get(2), notIntRange);
    }


    @Test
    public void whenIllegalArguments_displaysError() throws Exception {
        String outOfRangeInput = "1 2 3";
        when(solver.solve(1, 2, 3)).thenThrow(new RangeArgumentOutOfBoundsException(10, 100));

        FizzBuzzResult result = service.solveFizzBuzz(outOfRangeInput).get(0);
        String output = result.getOutput();

        assertTrue(output.startsWith(ERROR_RANGE_OUT_OF_BOUNDS_MSG));
    }

    @Test
    public void whenCorrectArgument_containsResult() throws Exception {
        String correctInput = "2 5 10";
        String correctOutput = "correct output";
        when(solver.solve(2, 5, 10)).thenReturn(FizzBuzzResult.correct(correctInput, correctOutput));

        FizzBuzzResult result = service.solveFizzBuzz(correctInput).get(0);

        checkResult(result, correctInput, correctOutput);
    }

    private void checkResultWithFormatError(FizzBuzzResult result, String expectedInput) {
        checkResult(result, expectedInput, ERROR_FORMAT_MSG);
    }

    private void checkResult(FizzBuzzResult result, String expectedInput, String expectedOutput) {
        assertTrue(result.getInput().equals(expectedInput));
        assertTrue(result.getOutput().equals(expectedOutput));
    }
}
