package codekata.builder;

import codekata.service.CompoundNumberConverter;
import codekata.service.DefaultConverter;
import codekata.service.NumberConverter;
import codekata.service.SimpleNumberConverter;
import java.util.List;

import static codekata.service.NumberConverter.BUZZ;
import static codekata.service.NumberConverter.FIZZ;
import static codekata.service.NumberConverter.FIZZ_BUZZ;

public class NumberConverterBuilder {
    private NumberConverter current;

    public NumberConverterBuilder() {
        this.current = new DefaultConverter();
    }

    public NumberConverterBuilder fizzConverter(int divisor) {
        current = new SimpleNumberConverter(current, divisor, FIZZ);
        return this;
    }

    public NumberConverterBuilder buzzConverter(int divisor) {
        current = new SimpleNumberConverter(current, divisor, BUZZ);
        return this;
    }

    public NumberConverterBuilder fizzBuzzConverter(List<Integer> divisors) {
        current = new CompoundNumberConverter(current, divisors, FIZZ_BUZZ);
        return this;
    }

    public NumberConverter build() {
        return current;
    }
}
