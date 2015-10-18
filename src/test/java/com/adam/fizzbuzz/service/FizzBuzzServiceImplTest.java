package com.adam.fizzbuzz.service;

import com.adam.fizzbuzz.configuration.RootConfiguration;
import com.adam.fizzbuzz.service.FizzBuzzServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

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
        assertEquals("1 2 F 4 B F 7 8 F B\nError: incorrect data format. Expecting three space separated integers in a line: divider1 divider2 range", service.solveFizzBuzz("3 5 10\n2 7"));
    }

    @Test
    public void displaysErrorWhenTooManyValuesArePassed() throws Exception {
        assertEquals("Error: incorrect data format. Expecting three space separated integers in a line: divider1 divider2 range", service.solveFizzBuzz("3 5 10 11"));
    }

    @Test
    public void displaysErrorWhenNotNumbersArePassed() throws Exception {
        assertEquals("Error: incorrect data format. Expecting three space separated integers in a line: divider1 divider2 range", service.solveFizzBuzz("a 1 2"));
        assertEquals("Error: incorrect data format. Expecting three space separated integers in a line: divider1 divider2 range", service.solveFizzBuzz("1 b 2"));
        assertEquals("Error: incorrect data format. Expecting three space separated integers in a line: divider1 divider2 range", service.solveFizzBuzz("1 2 c"));
    }

    @Test
    public void displaysErrorWhenValuesOutOfRangeArePassed() throws Exception {
        assertEquals("Error: values out of range. Divider must be within range <1, 20>", service.solveFizzBuzz("-1 1 2"));
        assertEquals("Error: values out of range. Range must be within range <10, 100>", service.solveFizzBuzz("1 1 0"));
    }
}