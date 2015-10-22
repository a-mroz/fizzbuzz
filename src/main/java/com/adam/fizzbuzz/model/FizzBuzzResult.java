package com.adam.fizzbuzz.model;

public class FizzBuzzResult {
    private final String input;
    private final String output;
    private final boolean errorResult;


    public static FizzBuzzResult correct(String input, String output) {
        return new FizzBuzzResult(input, output, false);
    }


    public static FizzBuzzResult incorrect(String input, String output) {
        return new FizzBuzzResult(input, output, true);
    }

    private FizzBuzzResult(String input, String output, boolean errorResult) {
        this.input = input;
        this.output = output;
        this.errorResult = errorResult;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public boolean isErrorResult() {
        return errorResult;
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

        if (errorResult != that.errorResult) return false;
        if (input != null ? !input.equals(that.input) : that.input != null) return false;
        return !(output != null ? !output.equals(that.output) : that.output != null);

    }

    @Override
    public int hashCode() {
        int result = input != null ? input.hashCode() : 0;
        result = 31 * result + (output != null ? output.hashCode() : 0);
        result = 31 * result + (errorResult ? 1 : 0);
        return result;
    }
}
