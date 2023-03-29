package ru.mcs.streamapi.predicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AppleExample {

    enum Color {RED, GREEN}

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        for (int index = 0; index < 1000000; index++) {
            Apple apple = new Apple(index, (index % 2 == 0 ? Color.GREEN.name() : Color.RED.name()));
            inventory.add(apple);
        }


//        Long start = System.currentTimeMillis();
//        Collections.sort(inventory, new Comparator<ru.mcs.streamapi.predicate.Apple>() {
//            @Override
//            public int compare(ru.mcs.streamapi.predicate.Apple a1, ru.mcs.streamapi.predicate.Apple a2) {
//                return a1.getWeight().compareTo(a2.getWeight());
//            }
//        });
//        Long end = System.currentTimeMillis();
//        System.out.println("Прошло времени, мс: " + (end - start));

        inventory.sort(Comparator.comparing(Apple::getWeight));


//        List<ru.mcs.streamapi.predicate.Apple> colorApple = new ArrayList<>();
//        filterApples(colorApple, (ru.mcs.streamapi.predicate.Apple a) -> GREEN.equals(a.getColor()));

        Long start = System.currentTimeMillis();
        List<Apple> weightApple = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        Long end = System.currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (end - start));

        Long start2 = System.currentTimeMillis();
        List<Apple> weightApple2 = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
        Long end2 = System.currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (end2 - start2));


        Long start3 = System.currentTimeMillis();
        List<Apple> weightApple3 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
        Long end3 = System.currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (end3 - start3));
//
////        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
//        int[] ints = new int[10];
//        List<String> stringList = new ArrayList<>();
        List<Apple> heavyApples = filterApples2(inventory, new AppleHeavyWeightPredicate());
        System.out.println(heavyApples.size());
        List<Apple> heavyApples2 = filterApples2(inventory, new AppleGreenColorPredicate());
        System.out.println(heavyApples2.size());

        List<Apple> result = filterApples(inventory, (Apple a) -> Color.RED.name().equals(a.getColor()));
    }


    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    static List<Apple> filterApples2(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
