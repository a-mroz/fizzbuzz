package com.adam.fizzbuzz.configuration;

import com.adam.fizzbuzz.domain.FizzBuzzSolverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.adam.fizzbuzz"})
public class RootConfiguration {

    @Bean
    public FizzBuzzSolverImpl fizzBuzzSolver() {
        return new FizzBuzzSolverImpl();
    }

}
