package workshop.streams;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class StreamsTest {

    @Test
    public void testMaxLengthWord() {

        List<String> countries = List.of("India", "US", "Japan", "Australia");

        String country = countries.stream()
                .max(Comparator.comparing(String::length))
                .get();

        countries.

        System.out.println(country);

    }
}
