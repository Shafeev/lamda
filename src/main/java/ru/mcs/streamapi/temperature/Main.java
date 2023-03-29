package ru.mcs.streamapi.temperature;

import java.util.concurrent.Flow;

public class Main {

    public static void main(String[] args) {
        getTemperature("Moscow").subscribe(new TempSubscriber());
    }

    private static Flow.Publisher<TempInfo> getTemperature(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            subscriber.onSubscribe(new TempSubscription(subscriber, town));
        };
    }
}
