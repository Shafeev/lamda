package ru.mcs.streamapi.dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class DishExample {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("rise", true, 330, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("salmon", false, 450, Dish.Type.FISH),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("pork", false, 800, Dish.Type.MEAT)
        );

        List<String> threeHighCaloricDishNames = menu.stream().filter(dish -> dish.getCalories() > 350 && dish.getCalories() < 600)
                .map(Dish::getName).limit(2).collect(toList());
        System.out.println(threeHighCaloricDishNames);

        menu.sort(Comparator.comparing(Dish::getCalories));
        List<Dish> sliceMenu1 = menu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(toList());
        System.out.println(sliceMenu1);
        sliceMenu1.forEach(System.out::println);

        System.out.println("Example dropWhile");
        List<Dish> sliceMenu2 = menu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(toList());
        sliceMenu2.forEach(System.out::println);

        System.out.println("");
        System.out.println("Example limmit");
        List<Dish> dishes = menu.stream().filter(dish -> dish.getCalories() > 300).limit(3).collect(toList());
        dishes.forEach(System.out::println);

        System.out.println("");
        System.out.println("Example skip");
        List<Dish> dishes1 = menu.stream().filter(dish -> dish.getCalories() > 300).skip(2).limit(3).collect(toList());
        dishes1.forEach(System.out::println);

        System.out.println("");
        System.out.println("Example two fisrt meat dishes");
        List<Dish> twoMeatDishes = menu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).limit(2).collect(toList());
        twoMeatDishes.forEach(System.out::println);

        System.out.println("");
        System.out.println("Example get name");
        List<String> dishNames = menu.stream().map(Dish::getName).sorted().collect(toList());
        dishNames.forEach(System.out::println);

        System.out.println("");
        System.out.println("Example length word");
        List<Integer> dishesNameLength = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        dishesNameLength.forEach(System.out::println);

        System.out.println("");
        System.out.println("Example flatMap");
        List<String> symbolList = menu.parallelStream().map(Dish::getName).map(word -> word.split("")).flatMap(Arrays::stream).distinct().sorted().collect(toList());
        symbolList.forEach(System.out::println);

        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);

        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);


        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<Dish.Type, List<Dish>> dishesByTyp2 = menu.stream()
                .collect(groupingBy(Dish::getType, Collectors.filtering(dish->dish.getCalories() > 500, toList())));
        dishesByTyp2.forEach((type, dishes2) -> {System.out.println(type + dishes2.toString());});


    }
}
