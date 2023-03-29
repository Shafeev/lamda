package ru.mcs.streamapi.trade;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TraderExample {

    public static void main(String[] args) {
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

        List<Transaction> t2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        t2011.forEach(System.out::println);

        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        cities.forEach(System.out::println);

        Set<String> cities2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
        cities2.forEach(System.out::println);

        List<Trader> traders = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(toList());
        traders.forEach(System.out::println);

        List<String> traderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());
        traderNames.forEach(System.out::println);

        boolean isMilan = transactions.stream().map(Transaction::getTrader).anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println("Milan is " + isMilan);

        Integer sumValue = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue).reduce(0, Integer::sum);
        System.out.println("Sum " + sumValue);

        Optional<Integer> maxTr = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(maxTr);
        Optional<Integer> minTr = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(minTr);
        Optional<Transaction> minValue  = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(minValue.get().getValue());
    }
}
