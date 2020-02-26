package codekata.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CompoundNumberConverter implements NumberConverter {
    private final NumberConverter delegate;
    private final Set<Integer> divisors = new HashSet<>();
    private final String output;

    public CompoundNumberConverter(NumberConverter delegate, List<Integer> divisors, String output) {
        Objects.requireNonNull(delegate, "Delegate transformer must be provided");
        Objects.requireNonNull(divisors, "divisors must be provided");
        Objects.requireNonNull(output, "output transformer must be provided");
        if (divisors.isEmpty()) {
            throw new IllegalArgumentException(String.format("divisors cannot be empty"));
        }
        for (Integer divisor : divisors) {
            if (divisor < 1) {
                throw new IllegalArgumentException(String.format("divisor, %d must be greater than 0", divisor));
            }
            this.divisors.add(divisor);
        }
        this.delegate = delegate;
        this.output = output;
    }

    @Override
    public String convert(final Integer number) {
        return divisors.stream().allMatch(divisor -> number % divisor == 0) ? output : delegate.convert(number);
    }
}
