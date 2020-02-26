package codekata.service;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static codekata.service.NumberConverter.FIZZ;
import static codekata.service.NumberConverter.FIZZ_BUZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CompoundNumberConverterTest {
    @Mock
    private NumberConverter delegate;
    private NumberConverter fizzBuzzConverter;

    @Before
    public void setUp() {
        fizzBuzzConverter = new CompoundNumberConverter(delegate, Arrays.asList(5, 3), FIZZ_BUZZ);
    }

    @Test
    public void canConvertToFizzBuzz() {
        IntStream.rangeClosed(1, 20).boxed().map(num -> num * 5).forEach(num -> {
            String convert = fizzBuzzConverter.convert(num * 3);
            assertThat(convert, is(FIZZ_BUZZ));
        });
    }
}