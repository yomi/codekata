package codekata.driver;

import codekata.service.CompoundNumberConverter;
import codekata.service.DefaultConverter;
import codekata.service.NumberConverter;
import codekata.service.SimpleNumberConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static codekata.service.NumberConverter.BUZZ;
import static codekata.service.NumberConverter.FIZZ;
import static codekata.service.NumberConverter.FIZZ_BUZZ;


public class FizzBuzzDriver {
    private final NumberConverter numberConverter;

    public FizzBuzzDriver() {
        numberConverter = new CompoundNumberConverter(new SimpleNumberConverter(new SimpleNumberConverter(new DefaultConverter(), 3, FIZZ), 5, BUZZ), Arrays.asList(5, 3), FIZZ_BUZZ);
    }

    public FizzBuzzDriver(NumberConverter numberConverter) {
        this.numberConverter = numberConverter;
    }

    public List<String> run() {
        return run(IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList()));
    }

    public List<String> run(List<Integer> numbers) {
        return numbers.stream().map(num -> numberConverter.convert(num)).collect(Collectors.toList());
    }
}
