package com.adam.fizzbuzz.service;

import com.adam.fizzbuzz.configuration.RootConfiguration;
import com.adam.fizzbuzz.model.FizzBuzzResult;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfiguration.class)
public class FizzBuzzServiceImplIntegrationTest {

    @Autowired
    private FizzBuzzServiceImpl service;

    @Test
    public void canSolveSingleLine() throws Exception {
        List<FizzBuzzResult> results = service.solveFizzBuzz("3 5 10");
        assertEquals("1 2 F 4 B F 7 8 F B", results.get(0).getOutput());
    }

    @Test
    public void canSolveMultipleLines() throws Exception {
        List<FizzBuzzResult> results = service.solveFizzBuzz("3 5 10 \n2 7 15");

        assertEquals(2, results.size());

        assertEquals("3 5 10", results.get(0).getInput());
        assertEquals("1 2 F 4 B F 7 8 F B", results.get(0).getOutput());

        assertEquals("2 7 15", results.get(1).getInput());
        assertEquals("1 F 3 F 5 F B F 9 F 11 F 13 FB 15", results.get(1).getOutput());
    }

    @Test
    public void canWorkWithNotOneSpaceSeparatedValues() throws Exception {
        List<FizzBuzzResult> results = service.solveFizzBuzz("3   5 \t 10 \n2   7  \t   15");
        assertEquals("1 2 F 4 B F 7 8 F B", results.get(0).getOutput());
        assertEquals("1 F 3 F 5 F B F 9 F 11 F 13 FB 15", results.get(1).getOutput());
    }

    @Test
    public void displaysErrorWhenNotEnoughValuesArePassed() throws Exception {
        List<FizzBuzzResult> results = service.solveFizzBuzz("3 5 10\n2 7");
        assertEquals("1 2 F 4 B F 7 8 F B", results.get(0).getOutput());
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, results.get(1).getOutput());
    }

    @Test
    public void displaysErrorWhenTooManyValuesArePassed() throws Exception {
        List<FizzBuzzResult> results = service.solveFizzBuzz("3 5 10 11");
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, results.get(0).getOutput());
    }

    @Test
    public void displaysErrorWhenNotNumbersArePassed() throws Exception {
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("a 1 2").get(0).getOutput());
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("1 b 2").get(0).getOutput());
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("1 2 c").get(0).getOutput());
    }

    @Test
    public void displaysErrorWhenValuesOutOfRangeArePassed() throws Exception {
        assertTrue(service.solveFizzBuzz("-1 1 2").get(0).getOutput().startsWith(FizzBuzzServiceImpl.ERROR_DIVIDER_OUT_OF_BOUNDS_MSG));
        assertTrue(service.solveFizzBuzz("1 1 0").get(0).getOutput().startsWith(FizzBuzzServiceImpl.ERROR_RANGE_OUT_OF_BOUNDS_MSG));
    }
}
