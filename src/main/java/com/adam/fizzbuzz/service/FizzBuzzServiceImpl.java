package com.adam.fizzbuzz.service;

import com.adam.fizzbuzz.domain.FizzBuzzSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private final FizzBuzzSolver solver;

    @Autowired
    public FizzBuzzServiceImpl(FizzBuzzSolver solver) {
        this.solver = solver;
    }

    public String solveFizzBuzz(String input) {
        Scanner scanner = new Scanner(input);
        StringBuilder sb = new StringBuilder();

        while(scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] split = line.split("\\s+");

            int divisor1 = Integer.parseInt(split[0]);
            int divisor2 = Integer.parseInt(split[1]);
            int range = Integer.parseInt(split[2]);

            sb.append(solver.solve(divisor1, divisor2, range));
            sb.append("\n");
        }

        return sb.toString().trim();
    }
}
