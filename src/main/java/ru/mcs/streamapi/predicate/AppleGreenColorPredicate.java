package ru.mcs.streamapi.predicate;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return false;
    }
}
