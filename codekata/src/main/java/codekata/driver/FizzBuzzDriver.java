package codekata.driver;

import codekata.builder.NumberConverterBuilder;
import codekata.service.NumberConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FizzBuzzDriver {
    private final NumberConverter numberConverter;

    public FizzBuzzDriver() {
        numberConverter = new NumberConverterBuilder().fizzConverter(3).buzzConverter(5).fizzBuzzConverter(Arrays.asList(5, 3)).build();
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
