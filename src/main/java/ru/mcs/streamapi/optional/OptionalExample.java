package ru.mcs.streamapi.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        String name = optPerson
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
        System.out.println(name);
    }
}
