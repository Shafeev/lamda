package ru.mcs.streamapi.nodes;

public interface Node<T> {
    T head();
    Node<T> tail();
    default boolean isEmpty() {
        return true;
    }
}
