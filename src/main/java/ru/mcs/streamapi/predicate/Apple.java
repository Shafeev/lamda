package ru.mcs.streamapi.predicate;

public class Apple {
    private final int weight;
    private final String color;

    public Apple(int weight) {
        this.weight = weight;
        this.color =  null;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }
}
