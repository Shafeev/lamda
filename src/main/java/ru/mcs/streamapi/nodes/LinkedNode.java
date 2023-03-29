package ru.mcs.streamapi.nodes;

class LinkedNode<T> implements Node<T> {
    private final T head;
    private final Node<T> tail;

    public LinkedNode(T head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        return tail;
    }
}
