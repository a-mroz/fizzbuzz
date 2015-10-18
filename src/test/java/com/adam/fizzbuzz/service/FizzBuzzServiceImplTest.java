package com.adam.fizzbuzz.service;

import com.adam.fizzbuzz.configuration.RootConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfiguration.class)
public class FizzBuzzServiceImplTest {

    @Autowired
    private FizzBuzzServiceImpl service;

    @Test
    public void canSolveSingleLine() throws Exception {
        assertEquals("1 2 F 4 B F 7 8 F B", service.solveFizzBuzz("3 5 10"));
    }

    @Test
    public void canSolveMultipleLines() throws Exception {
        assertEquals("1 2 F 4 B F 7 8 F B\n1 F 3 F 5 F B F 9 F 11 F 13 FB 15", service.solveFizzBuzz("3 5 10 \n2 7 15"));
    }

    @Test
    public void canWorkWithNotOneSpaceSeparatedValues() throws Exception {
        assertEquals("1 2 F 4 B F 7 8 F B\n1 F 3 F 5 F B F 9 F 11 F 13 FB 15", service.solveFizzBuzz("3   5 \t 10 \n2   7  \t   15"));
    }

    @Test
    public void displaysErrorWhenNotEnoughValuesArePassed() throws Exception {
        assertEquals("1 2 F 4 B F 7 8 F B\n" + FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("3 5 10\n2 7"));
    }

    @Test
    public void displaysErrorWhenTooManyValuesArePassed() throws Exception {
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("3 5 10 11"));
    }

    @Test
    public void displaysErrorWhenNotNumbersArePassed() throws Exception {
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("a 1 2"));
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("1 b 2"));
        assertEquals(FizzBuzzServiceImpl.ERROR_FORMAT_MSG, service.solveFizzBuzz("1 2 c"));
    }

    @Test
    public void displaysErrorWhenValuesOutOfRangeArePassed() throws Exception {
        assertTrue(service.solveFizzBuzz("-1 1 2").startsWith(FizzBuzzServiceImpl.ERROR_OUT_OF_RANGE_MSG));
        assertTrue(service.solveFizzBuzz("1 1 0").startsWith(FizzBuzzServiceImpl.ERROR_OUT_OF_RANGE_MSG));
    }
}