package ru.mcs.streamapi.predicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return false;
    }
}
