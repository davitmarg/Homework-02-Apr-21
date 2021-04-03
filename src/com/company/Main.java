package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

public class Main {


    //1
    public static void convertToUpperCase(List<String> collection) {

        Stream<String> stream = collection.stream();

        List<String> collect = stream
                .map(each -> each.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    //2
    public static void filterCollection(List<String> collection) {

        Stream<String> stream = collection.stream();

        List<String> collect = stream
                .filter(each -> each.length() < 4)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    //3
    public static void flattenCollection(List<List<String>> collection) {

        Stream<List<String>> stream = collection.stream();
        List<String> oneDimList;
        oneDimList = stream
                .flatMap(each -> each.stream())
                .collect(Collectors.toList());
        System.out.println(oneDimList);
    }

    //4
    public static void findMaxAgePerson(List<Person> collection) {

        Stream<Person> stream = collection.stream();
        Person person = stream
                .max((a, b) -> Integer.compare(a.getAge(), b.getAge())).get();
        System.out.println(person);
    }

    //5
    public static void sumOfElements(List<Integer> collection) {

        Stream<Integer> stream = collection.stream();
        Integer sum = stream.mapToInt(each -> each).sum();
        System.out.println(sum);
    }

    //6
    public static void getKidNames(List<Person> collection) {

        Stream<Person> stream = collection.stream();
        List<Person> collect = stream
                .filter(each -> each.getAge() < 18).collect(Collectors.toList());
        System.out.println(collect);
    }

    //7
    static void sparateAdultsFromKids(List<Person> collection) {
        Map<Boolean, List<Person>> collect = collection.stream()
                .collect(Collectors.partitioningBy(each -> each.getAge() >= 18));
        System.out.println("True: " + collect.get(true));
        System.out.println("False: " + collect.get(false));
    }

    //8
    static void groupByNatinality(List<Person> collection) {
        Map<String, List<Person>> collect = collection.stream()
                .collect(Collectors.groupingBy(each -> each.getNationality()));
        System.out.println("Norwegian: " + collect.get("Norwegian"));
        System.out.println("Serbian: " + collect.get("Serbian"));
        System.out.println("Armenian: " + collect.get("Armenian"));
    }

    //9
    static String namesSeparatedByComma(List<Person> collection) {
       return "Names: " + collection.stream()
                       .map(each->each.getName())
                       .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("My", "name", "is", "John", "Doe");
        List<List<String>> multiStrings = Arrays.asList(Arrays.asList("Victor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
        System.out.println(strings);

        convertToUpperCase(strings);
        filterCollection(strings);
        flattenCollection(multiStrings);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Sara", 4, "Norwegian"));
        personList.add(new Person("Viktor", 40, "Serbian"));
        personList.add(new Person("Eva", 42, "Norwegian"));
        personList.add(new Person("Anna", 5, "Armenian"));
        System.out.println("\n" + personList);

        findMaxAgePerson(personList);

        List<Integer> numericList = new ArrayList<>();
        numericList.add(1);
        numericList.add(2);
        numericList.add(3);
        numericList.add(5);
        numericList.add(4);
        numericList.add(6);
        System.out.println("\n" + numericList);

        sumOfElements(numericList);

        getKidNames(personList);

        sparateAdultsFromKids(personList);

        groupByNatinality(personList);

        System.out.println(namesSeparatedByComma(personList));

    }

}
