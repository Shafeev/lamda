package ru.mcs.streamapi.pifagor;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pifagor {

    public static void main(String[] args) {
        Stream<int[]> pythagorianTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a->IntStream.rangeClosed(1, 100)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                        .mapToObj(b -> new int[] {a, b, (int)Math.sqrt(a*a + b*b)}));

        pythagorianTriples.limit(5).forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));


    }
}
