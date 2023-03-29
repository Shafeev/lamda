package ru.mcs.streamapi.nodes;

public class Empty<T> implements Node<T> {
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Node<T> tail() {
        throw  new UnsupportedOperationException();
    }
}
