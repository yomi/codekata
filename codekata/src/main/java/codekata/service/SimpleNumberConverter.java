package codekata.service;

import java.util.Objects;

public class SimpleNumberConverter implements NumberConverter {
    private final NumberConverter delegate;
    private final int divisor;
    private final String output;
    private final String hasText;

    public SimpleNumberConverter(NumberConverter delegate, int divisor, String output) {
        this(delegate, divisor, null, output);
    }

    public SimpleNumberConverter(NumberConverter delegate, int divisor, String hasText, String output) {
        Objects.requireNonNull(delegate, "Delegate transformer must be provided");
        Objects.requireNonNull(output, "output transformer must be provided");
        Objects.requireNonNull(output, "output transformer must be provided");
        if (divisor < 1) {
            throw new IllegalArgumentException(String.format("divisor, %d must be greater than 0", divisor));
        }
        this.output = output;
        this.delegate = delegate;
        this.divisor = divisor;
        this.hasText = hasText;
    }


    @Override
    public String convert(Integer number) {
        Objects.requireNonNull(number, "Number must be provided");
        return test(number) ? output : delegate.convert(number);
    }

    private boolean test(Integer number) {
        if (hasText != null) {
            return (number % divisor == 0) || String.valueOf(number).contains(hasText);
        }
        return number % divisor == 0;
    }
}
