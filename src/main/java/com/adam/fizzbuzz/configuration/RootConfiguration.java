package com.adam.fizzbuzz.configuration;

import com.adam.fizzbuzz.domain.FizzBuzzSolverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.adam.fizzbuzz"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfiguration {

    @Bean
    public FizzBuzzSolverImpl fizzBuzzSolver() {
        return new FizzBuzzSolverImpl();
    }

}
