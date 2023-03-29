package ru.mcs.streamapi.shop;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private String name;
    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void main(String[] args) {
//        Shop shop = new Shop();
//        double test = shop.getPrice("rrr");
//        System.out.println(test);

        Shop shop = new Shop("Best shop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my fsvire product");
        long invocationTime = ((System.nanoTime() - start)/1_000_000);
        System.out.println("Return " + invocationTime + " msecs");
        System.out.println("DoSumthing");
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price " + retrivalTime + " msec");

    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
