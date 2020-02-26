package codekata.service;

public interface NumberConverter {
    String FIZZ = "Fizz";
    String BUZZ = "Buzz";
    String FIZZ_BUZZ = "FizzBuzz";

    /**
     * Transforms a number to Fizz, Buzz, FizzBuzz or String value of the number
     * @param number
     * @return
     */
    String convert(Integer number);
}
