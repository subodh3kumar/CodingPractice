package workshop.streams;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Gatherers;

public class StreamsTest {

    @Test
    public void testMaxLengthWord() {

        List<String> countries = List.of("India", "US", "Japan", "Australia");

        String country = countries.stream()
                .max(Comparator.comparing(String::length))
                .get();

        System.out.println(country);

    }

    @Test
    public void testReduce() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void testGatherScan() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .forEach(System.out::println);
    }
}
