package workshop;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateTest {

    @Test
    public void testDuplicateFrequency() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 4, 4);

        Set<Integer> duplicates = numbers.stream()
                .filter(i -> Collections.frequency(numbers, i) > 1)
                .collect(Collectors.toSet());

        System.out.println("testDuplicateFrequency: " + duplicates);
    }

    @Test
    public void testDuplicateGroupingBy() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 1, 2, 3, 4, 2, 2, 2, 6, 7);

        Set<Map.Entry<Integer, Long>> entries = numbers.stream()
                .mapToInt(value -> value)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet();

        List<Integer> list = entries.stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("testDuplicateGroupingBy: " + list);
    }

    @Test
    public void testDuplicateHashSet() {
        Integer[] numbers = new Integer[]{1, 2, 1, 3, 4, 4};
        Set<Integer> allItems = new HashSet<>();

        Set<Integer> duplicates = Arrays.stream(numbers)
                .filter(n -> !allItems.add(n))
                .collect(Collectors.toSet());

        System.out.println("testDuplicateHashSet: " + duplicates);
    }
}
