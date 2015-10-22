package com.adam.fizzbuzz.service;

import com.adam.fizzbuzz.domain.FizzBuzzSolver;
import com.adam.fizzbuzz.domain.exceptions.DividerArgumentOutOfBoundsException;
import com.adam.fizzbuzz.domain.exceptions.RangeArgumentOutOfBoundsException;
import com.adam.fizzbuzz.model.FizzBuzzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {
    public static final String ERROR_FORMAT_MSG = "Error: incorrect data format. Expecting three space separated integers in a line: divider1 divider2 range";
    public static final String ERROR_OUT_OF_RANGE_MSG = "Error: values out of range. ";
    public static final int REQUIRED_NUMBERS = 3;

    private final FizzBuzzSolver solver;

    @Autowired
    public FizzBuzzServiceImpl(FizzBuzzSolver solver) {
        this.solver = solver;
    }

    @Override
    public List<FizzBuzzResult> solveFizzBuzz(String input) {
        Scanner scanner = new Scanner(input);
        List<FizzBuzzResult> results = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split("\\s+");

            if (!hasEnoughData(split)) {
                addErrorMessage(results, line);
            } else {
                try {
                    int divisor1 = Integer.parseInt(split[0]);
                    int divisor2 = Integer.parseInt(split[1]);
                    int range = Integer.parseInt(split[2]);
                    results.add(solver.solve(divisor1, divisor2, range));
                } catch (NumberFormatException e) {
                    addErrorMessage(results, line);
                } catch (DividerArgumentOutOfBoundsException | RangeArgumentOutOfBoundsException e) {
                    results.add(new FizzBuzzResult(line, ERROR_OUT_OF_RANGE_MSG + e.getMessage()));
                }
            }
        }

        return results;
    }


    private boolean hasEnoughData(String[] split) {
        return split.length == REQUIRED_NUMBERS;
    }

    private void addErrorMessage(List<FizzBuzzResult> results, String inputLine) {
        results.add(new FizzBuzzResult(inputLine, ERROR_FORMAT_MSG));
    }
}
