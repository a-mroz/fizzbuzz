package com.adam.fizzbuzz;

import com.adam.fizzbuzz.configuration.RootConfiguration;
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

}