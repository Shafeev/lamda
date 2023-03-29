package ru.mcs.streamapi.nodes;

public class ExampleNode {

    public static void main(String[] args) {
        Node<Integer> nodes = new LinkedNode<>(5, new LinkedNode<>(10, new Empty<>()));

        System.out.println(nodes);
    }
}
