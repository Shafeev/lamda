package ru.mcs.streamapi.organization;

import java.util.List;

interface Organization {
    List<Worker> getWorkers();
    int getId();
}
