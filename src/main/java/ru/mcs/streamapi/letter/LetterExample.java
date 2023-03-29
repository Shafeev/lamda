package ru.mcs.streamapi.letter;

import java.util.function.Function;

public class LetterExample {

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::addFooter);

    }
}
