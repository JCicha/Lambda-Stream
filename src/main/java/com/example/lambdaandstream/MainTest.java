package com.example.lambdaandstream;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.asList;

public class MainTest {
    public static void main(String[] args) {
        Task task = new Task();
        Collection<Integer> numbers = new ArrayList<>(asList(88, 44, 2, 32, 52, 11));
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        Task task4 = new Task();
        Collection<Object> tasks = new ArrayList<>(asList(task1, task2, task3, task4));

        // task 8
        boolean isEven = task.taskEight(numbers);
        System.out.println(isEven);

        // task 2
        Collection<Integer> taskTwo = task.taskTwo(numbers);
        System.out.println(taskTwo);

        // task 3
        Collection<Integer> taskTree = task.taskThree(numbers);
        System.out.println(taskTree);

        // task 6
        Collection<Integer> taskSix = task.taskSix(tasks);
        System.out.println(taskSix);

        // task 4
        Collection<String> words = new ArrayList<>(asList("Ala ma", "kota", "A kot ma", "ale", "sdsd", "ds sa dsa d dsa"));
        Collection<String> taskFour = task.taskFour(words);
        System.out.println(taskFour);

        // task 5
        Collection<String> taskFive = task.taskFive(words);
        System.out.println(taskFive);

        // task 7
        Collection<Collection<Object>> lists = new ArrayList<>(asList(asList(1,2,3), asList(1,2,4), asList(1,2,3,4)));
        Collection<Object> smallestList = task.taskSeven(lists);
        System.out.println(smallestList);
    }
}
