package codekata.service;

import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static codekata.service.NumberConverter.BUZZ;
import static codekata.service.NumberConverter.FIZZ;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SimpleNumberConverterTest {
    @Mock
    private NumberConverter delegate;
    private NumberConverter fizzConverter;
    private NumberConverter buzzConverter;

    @Before
    public void setUp() {
        fizzConverter = new SimpleNumberConverter(delegate, 3, FIZZ);
        buzzConverter = new SimpleNumberConverter(delegate, 5, BUZZ);
    }

    @Test
    public void canConvertToFizz() {
        IntStream.rangeClosed(1, 30).forEach(value -> {
            String convert = fizzConverter.convert(value * 3);
            assertThat(convert, is(FIZZ));
        });
    }

    @Test
    public void canConvertToBuzz() {
        IntStream.rangeClosed(1, 20).forEach(value -> {
            String convert = buzzConverter.convert(value * 5);
            assertThat(convert, is(BUZZ));
        });
    }

    @Test
    public void fizzCanDelegate() {
        IntStream.rangeClosed(1, 100).forEach(value -> {
            int number = value * 2;
            if (number % 3 != 0) {
                fizzConverter.convert(number);
                Mockito.verify(delegate, Mockito.times(1)).convert(number);
            }
        });
    }

    @Test
    public void buzzCanDelegate() {
        IntStream.rangeClosed(1, 100).forEach(value -> {
            int number = value * 2;
            if (number % 5 != 0) {
                buzzConverter.convert(number);
                Mockito.verify(delegate, Mockito.times(1)).convert(number);
            }
        });
    }
}