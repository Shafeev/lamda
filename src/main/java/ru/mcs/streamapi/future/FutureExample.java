package ru.mcs.streamapi.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Integer x = 10;
//        Future<Integer> y = f(x);
//        Future<Integer> z = g(x);
//        System.out.println(y.get() + z.get());

        int x = 1337;
//        Result result = new Result();
//        f(x, (int y) -> {
//
//        })
    }

    private static void f(int x, Object o) {

    }

    private static class Result {
        Integer left;
        Integer right;
    }

    private static Integer f(Integer x) {
        return x*x;
    }

    private static Integer g(Integer x) {
        return x+x;
    }
}
