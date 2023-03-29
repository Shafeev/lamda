package ru.mcs.streamapi.predicate;

import java.util.Currency;

public class Transaction {
    private final String transaction;
    private final int price;

    public Transaction(String transaction, int price) {
        this.transaction = transaction;
        this.price = price;
    }

    public String getCurrency() {
        return transaction;
    }

    public int getPrice() {
        return price;
    }
}
