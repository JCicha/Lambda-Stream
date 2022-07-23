package com.example.lambdaandstream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    // 1. Wyfiltruj słowa, które zaczynja się lub kończa na litere A.
    public Collection<String> taskOne(Collection<String> input) {
        return input.stream()
                .filter(str -> str.startsWith("A") || str.endsWith("A"))
                .collect(Collectors.toList());
    }

    // 2. Wyfiltruj liczby, które kończa się 1 (użyj mapowania do stringa).
    public Collection<Integer> taskTwo(Collection<Integer> input) {
        return input.stream()
                .filter(integer -> String.valueOf(integer).endsWith("1"))
                .collect(Collectors.toList());
    }

    // 3. Wyfiltruj liczby, które kończa się 1 (nie używaj mapowania do stringa).
    public Collection<Integer> taskThree(Collection<Integer> input) {
        return input.stream()
                .filter(integer -> integer % 10 == 1)
                .collect(Collectors.toList());
    }

    // 4. Połacz wszystkie słowa z listy.
    public Collection<String> taskFour(Collection<String> input) {
        return input.stream()
                .map(str -> str.split(" "))
                .map(str -> String.join("", str))
                .collect(Collectors.toList());
    }

    // 5. Połacz wszystkie słowa z listy, słowa musz być odzielone "_".
    public Collection<String> taskFive(Collection<String> input) {
        return input.stream()
                .map(str -> str.split(" "))
                .map(str -> String.join("_", str))
                .collect(Collectors.toList());    }

    // 6. Wyświetl hascode każdego obiektu z listy i zwróć listę hascodów.
    public Collection<Integer> taskSix(Collection<Object> input) {
        List<Integer> list = new ArrayList<>();
        for (Object o : input) {
            Integer hashCode = o.hashCode();
            System.out.println(hashCode);
            list.add(hashCode);
        }
        return list;
    }

    // 7. Zwróć listę o najmniejsze wielkości.
    public Collection<Object> taskSeven(Collection<Collection<Object>> input) {
        return input.stream()
                .min(Comparator.comparing(Collection::size))
                .get();
    }

    // 8. Sprawdz czy wszystkie liczby sa parzyste.
    public Boolean taskEight(Collection<Integer> input) {
        return input.stream()
                .allMatch(integer -> integer % 2 == 0);
    }
}
