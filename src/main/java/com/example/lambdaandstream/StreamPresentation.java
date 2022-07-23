package com.example.lambdaandstream;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamPresentation {


    public static void main(String[] args) {
        Collection<Integer> numbers = new ArrayList<>(asList(88, 44, 111, 32, 5));
        // 1. Przykład operacji na kolekcji z pętla
        for (Integer a : numbers) {
            System.out.println(a);
        }

        // 2. Ten sam przykład ze streamem
        numbers.forEach(System.out::println);
        List<Integer> collect1 = numbers
                .stream()
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(collect1);

        // Lista
        // Consumer
        // forEach

        //allMatch
        boolean b = numbers.stream().allMatch(x -> x > 5);
        System.out.println(b);

        //anyMatch
        b = numbers.stream().anyMatch(x -> x < 5);
        System.out.println(b);

        // distinct and collect
        numbers.add(5);
        numbers.add(32);

        System.out.println(numbers);
        List<Integer> collect = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(collect);
        numbers.forEach(integer -> System.out.println(integer.hashCode()));

        // sorted
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

        System.out.println(numbers);

        // map
        List<Integer> mapped = numbers.stream().map(StreamPresentation::extracted).collect(Collectors.toList());
        System.out.println(mapped);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        //peek and skip
        List<Integer> withPeek = numbers.stream().skip(3).peek(System.out::println).collect(Collectors.toList());
        System.out.println(withPeek);

        //reduce
        Collection<Integer> numbers1 = new ArrayList<>(asList(1, 2, 3, 4, 5));
        Optional<Integer> reduce1 = numbers1.stream().reduce((i1, i2) -> i1 * i2);
        Optional<Integer> reduce2 = numbers1.stream().reduce(Integer::sum);
        System.out.println(reduce1);
        System.out.println(reduce2);

        //flatMap
        List<Integer> flatMap = Stream.of(numbers, mapped, withPeek).peek(System.out::println).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flatMap);

        System.out.println("+++++++++++++++++++++++++++++++++++++");
        //findFirst
        Collection<String> words = new ArrayList<>(asList("Polska", "Nimecy", "Hiszpania", "Wielka Brytania"));
        Optional<String> first = words.stream().findFirst();
        System.out.println(first);


        // noneMatch
        boolean noneMatch = words.stream().noneMatch(s -> s.length() < 6);
        System.out.println(noneMatch);


        System.out.println("+++++++++++++++++++++++++++++++++++");
        // concurrent
        words.add("Australia");
        words.add("Wegry");
        words.add("Chiny");
        words.add("Chile");
        words.add("Kanada");
        words.add("Kambodza");
        words.forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
        System.out.println("+++++++++++++++++++++++++++++++++++");
        words.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
        System.out.println("+++++++++++++++++++++++++++++++++++");
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> reduce = listOfNumbers.parallelStream().reduce((a, b1) -> {
            System.out.println(a + " " + Thread.currentThread().getName());
            return Integer.sum(a, b1);
        });
        System.out.println(reduce);
    }

    private static int extracted(Integer x) {
        int i = x * 2;
        return i + 9;
    }
}

class SomeSome {
    public void hey() {
        System.out.println("aaaa");
    }

    public void no(String a) {
        System.out.println(a);
    }
}