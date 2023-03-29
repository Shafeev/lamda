package ru.mcs.streamapi.collections;

import ru.mcs.streamapi.trade.Trader;
import ru.mcs.streamapi.trade.Transaction;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class FabricaCollections {

    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");

        List<String> friends2 = Arrays.asList("Olivia", "Richard", "THinbaut");
        List<String> values = List.of("wdsfsdf", "dsfsdf", "sdlkfsdf");
        List<String> list1 = List.of("val", "Val2", "val3");


        Set<String> values2 = new HashSet<>(Arrays.asList("dsfsdf", "sdfsdf", "sdfsdf"));
        Set<String> friend3 = Stream.of("sdfsd", "sdfs", "sdfsdf").collect(Collectors.toSet());


        Map<String, Integer> valMap = new HashMap<>();

        Map<String, String> mapValue1 = Map.of("key1", "Value1", "key2", "Val2");
        Map<Integer, String> map = Map.of(1, "sfsd", 2, "sdf");
        Map<String, Integer> mapVal = Map.ofEntries(entry("key1", 1), entry("key2", 2), entry("key3", 3));


        StringBuilder builder = new StringBuilder();
        mapVal.forEach((key, value) -> {
            System.out.println(key + " " + value);
            builder.append(key).append(",");
        });
        System.out.println(builder.toString());

        mapVal.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(System.out::println);

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext(); ) {
            Transaction next = iterator.next();
            if (Character.isDigit(next.getTrader().getName().charAt(0))) {
                transactions.remove(next);
            }
        }

        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphel", "Star Wars");
        favouriteMovies.put("Olivia", "james bond");
        favouriteMovies.replaceAll((friend, movie) -> friend.toUpperCase());
        System.out.println(favouriteMovies);

        Map<String, String> familyMap = Map.ofEntries(entry("Teo", "Star Wars"), entry("Cristian", "James Bond"));
        Map<String, String> friendsMap = Map.ofEntries(entry("Raphael", "Star Wars"), entry("Cristian", "Matrix"));
        Map<String, String> everyOne = new HashMap<>(familyMap);
        friendsMap.forEach((key, value) -> everyOne.merge(key, value, (movie1 , movie2) -> movie1 + " & " + movie2));
        System.out.println(everyOne);

        Map<String, Long> moviesToCount = new HashMap<>();
        String movieName = "James Bond";
//        long count = moviesToCount.get(movieName);
//        if (count == null) {
//            moviesToCount.put(movieName, 1L);
//        } else {
//            moviesToCount.put(movieName, count + 1);
//        }
        moviesToCount.merge(movieName, 1L, (key, count) -> count + 1);

    }


}
