package ru.mcs.streamapi.organization;

import java.util.ArrayList;
import java.util.List;

public class OrganizationImp implements Organization {

    private Integer id;
    private List<Worker> workers = new ArrayList<>();

    public OrganizationImp(List<Worker> workers) {
        this.workers.addAll(workers);
    }

    public OrganizationImp(Integer id) {
        this.id = id;
    }

    public OrganizationImp(Integer id, List<Worker> workers) {
        this.id = id;
        this.workers = workers;
    }

    @Override
    public List<Worker> getWorkers() {
        return workers;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OrganizationImp{" +
                "id=" + id +
                ", workers=" + workers +
                '}';
    }
}
