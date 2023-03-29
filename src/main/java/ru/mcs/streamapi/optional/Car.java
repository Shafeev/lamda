package ru.mcs.streamapi.optional;

import java.util.Optional;

class Car {
    private Optional<Insurance> insurance;

    Car(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    Optional<Insurance> getInsurance() {
        return insurance;
    }
}
