package codekata.service;

import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DefaultConverterTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private DefaultConverter transformer;
    @Before
    public void setUp() {
        transformer = new DefaultConverter();
    }

    @Test
    public void transform() {
        IntStream.rangeClosed(1, 100).forEach(value -> {
            String transformed = transformer.convert(value);
            assertThat(transformed, notNullValue());
            assertThat(transformed, is(String.valueOf(value)));
        });
    }

    @Test
    public void transform_null() {
        exception.expect(NullPointerException.class);
        exception.expectMessage(containsString("Number must be provided"));
        transformer.convert(null);
    }
}