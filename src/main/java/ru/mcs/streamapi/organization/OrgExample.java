package ru.mcs.streamapi.organization;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrgExample {

    public static void main(String[] args) {
        Worker w1 = new WorkerImp("Worker 1", 1);
        Worker w2 = new WorkerImp("Worker 2", 2);
        Worker w3 = new WorkerImp("Worker 3", 3);
        Worker w4 = new WorkerImp("Worker 4", 4);
        Worker w5 = new WorkerImp("Worker 4", 5);
        Worker w6 = new WorkerImp("Worker 6", 6);
        Worker w7 = new WorkerImp("Worker 7", 7);
        Worker w8 = new WorkerImp("Worker 8", 8);
        Organization org1 = new OrganizationImp(1, Arrays.asList(w1, w2, w3, w4, w5, w6, w7, w8));

        Worker wa1 = new WorkerImp("Workera 1", 3);
        Worker wa2 = new WorkerImp("Workera 2", 3);
        Worker wa3 = new WorkerImp("Workera 3", 3);
        Worker wa4 = new WorkerImp("Workera 3", 3);
        Worker wa5 = new WorkerImp("Workera 5", 3);
        Worker wa6 = new WorkerImp("Workera 6", 3);
        Worker wa7 = new WorkerImp("Workera 7", 3);
        Organization org2 = new OrganizationImp(2, Arrays.asList(wa1, wa2, wa3, wa4, wa5, wa6, wa7));


        Worker wb1 = new WorkerImp("Workera 1", 4);
        Worker wb2 = new WorkerImp("Workera 2", 4);
        Worker wb3 = new WorkerImp("Workera 3", 4);
        Worker wb4 = new WorkerImp("Workera 4", 4);
        Worker wb5 = new WorkerImp("Workera 5", 4);
        Organization org3 = new OrganizationImp(3, Arrays.asList(wb1, wb2, wb3, wb4, wb5));

        ArrayList<Organization> organizations = new ArrayList<>();
        organizations.add(org1);
        organizations.add(org2);
        organizations.add(org3);

//        Stream<String> result = uniqueNameStream(organizations.stream());
        List<String> workers = organizations.stream()
                .filter(organization -> organization.getWorkers().size() > 7)
                .map(Organization::getWorkers).flatMap(Collection::stream).map(Worker::getName)
                .distinct()
                .collect(Collectors.toList());
        workers.forEach(System.out::println);

        Map<Integer, Organization> actual = organizations.stream()
                .collect(
                        Collectors.toMap(Organization::getId, o -> o)
                );
        actual.forEach((key, org) -> {
            System.out.println(key + " : " + org.toString());
        });

        /*
        Нужно упорядочить сотрудников по количеству очков и выбрать трёх лучших из них.
        Нужно написать коллектор, который создаст строку с именами трех лучших сотрудников, разделенными запятой и пробелом.
        Имена сотрудников в строке дожны идти в порядке убывания количества очков.
        Гарантируется, что количество очков у всех сотрудников разное.
        */
//        organizations.stream().map(Organization::getWorkers)
//                .flatMap(Collection::stream)
//                .sorted(Comparator.comparing(Worker::getPoints, Comparator.reverseOrder()))
//                .limit(3)
//                .collect(Collectors.joining(""));
    }


    static Stream<String> uniqueNameStream(Stream<Organization> organizationStream) {
        return organizationStream.filter(organization -> organization.getWorkers().size() > 7)
                .map(Organization::getWorkers).flatMap(Collection::stream).map(Worker::getName)
                .distinct();
    }
}
