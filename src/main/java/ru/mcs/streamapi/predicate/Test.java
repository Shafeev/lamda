package ru.mcs.streamapi.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;

import static java.util.stream.Collectors.toList;


public class Test {

    public static void main(String[] args) {
//        Consumer
        forEach(Arrays.asList(1, 2, 3, 4, 5, 6), System.out::println);

        System.out.println("Example Function");
        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), String::length);
        forEach(l, System.out::println);

        System.out.println("Example filter unique values");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        List<Integer> sq = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sq2 = sq.stream().map(n -> n * n).collect(toList());
        System.out.println("");
        sq2.forEach(System.out::println);

        System.out.println("");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());
        System.out.println(pairs);
        for (int[] pair : pairs) {
            for (int i : pair) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
