package ru.mcs.streamapi.organization;

public class WorkerImp implements Worker {

    private String name;
    private Integer point;

    public WorkerImp(String name) {
        this.name = name;
    }

    public WorkerImp(Integer point) {
        this.point = point;
    }

    public WorkerImp(String name, Integer point) {
        this.name = name;
        this.point = point;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPoints() {
        return point;
    }


    @Override
    public String toString() {
        return "WorkerImp{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
