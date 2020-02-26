package codekata.service;

import java.util.Objects;

public class DefaultConverter implements NumberConverter {

    public String convert(Integer number) {
        Objects.requireNonNull(number, "Number must be provided");
        return String.valueOf(number);
    }
}
