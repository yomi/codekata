package codekata.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CompoundNumberConverter implements NumberConverter {
    private final NumberConverter delegate;
    private final List<Integer> divisors = new ArrayList<>();
    private final List<String> listOfText = new ArrayList<>();
    private final String output;

    public CompoundNumberConverter(NumberConverter delegate, List<Integer> divisors, String output) {
        this(delegate, divisors, Collections.emptyList(), output);
    }

    public CompoundNumberConverter(NumberConverter delegate, List<Integer> divisors, List<String> listOfText, String output) {
        Objects.requireNonNull(delegate, "Delegate transformer must be provided");
        Objects.requireNonNull(divisors, "divisors must be provided");
        Objects.requireNonNull(output, "output must be provided");
        Objects.requireNonNull(listOfText, "listOfText must be provided");
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
        return test(number) ? output : delegate.convert(number);
    }

    private boolean test(Integer number) {
        boolean canDivideBy = divisors.stream().allMatch(divisor -> number % divisor == 0);
        if (listOfText.isEmpty()) {
            return canDivideBy;
        }
        return canDivideBy || listOfText.stream().allMatch(text -> String.valueOf(number).contains(text));
    }


}
