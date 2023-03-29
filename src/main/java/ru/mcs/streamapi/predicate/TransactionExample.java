package ru.mcs.streamapi.predicate;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class TransactionExample {

    public static void main(String[] args) {
        Transaction t1 = new Transaction("USDT", 2);
        Transaction t2 = new Transaction("RU", 3);
        Transaction t3 = new Transaction("USD", 4);
        Transaction t4 = new Transaction("RU", 5);
        Transaction t5 = new Transaction("YEN", 6);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(t1);
        transactionList.add(t2);
        transactionList.add(t3);
        transactionList.add(t4);
        transactionList.add(t5);

        Map<String, List<Transaction>> transactionByCurrencies = new HashMap<>();

        for (Transaction transaction : transactionList) {
            if (transaction.getPrice() > 1000) {
                String currency = transaction.getCurrency();
                List<Transaction> transactionForCurrency = transactionByCurrencies.get(currency);
                if (transactionForCurrency == null) {
                    transactionForCurrency = new ArrayList<>();
                    transactionByCurrencies.put(currency, transactionForCurrency);
                }
                transactionForCurrency.add(transaction);
            }
        }


        Map<String, List<Transaction>> transactionsByCurrencies = transactionList.stream().filter((Transaction t) -> t.getPrice() >1000).collect(groupingBy(Transaction::getCurrency));
    }
}
