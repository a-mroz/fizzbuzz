package com.adam.fizzbuzz.model;

public class FizzBuzzResult {
    private final String input;
    private final String output;


    public FizzBuzzResult(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }


    @Override
    public String toString() {
        return "FizzBuzzResult{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FizzBuzzResult that = (FizzBuzzResult) o;

        if (!input.equals(that.input)) return false;
        return output.equals(that.output);

    }

    @Override
    public int hashCode() {
        int result = input.hashCode();
        result = 31 * result + output.hashCode();
        return result;
    }
}
