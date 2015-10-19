package com.adam.fizzbuzz.service;

import com.adam.fizzbuzz.model.FizzBuzzResult;

import java.util.List;

public interface FizzBuzzService {

    List<FizzBuzzResult> solveFizzBuzz(String input);
}
