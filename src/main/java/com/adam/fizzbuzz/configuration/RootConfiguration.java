package com.adam.fizzbuzz.configuration;

import com.adam.fizzbuzz.FizzBuzzService;
import com.adam.fizzbuzz.FizzBuzzServiceImpl;
import com.adam.fizzbuzz.FizzBuzzSolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.adam.fizzbuzz"})
public class RootConfiguration {

    @Bean
    public FizzBuzzSolver fizzBuzzSolver() {
        return new FizzBuzzSolver();
    }

}
