package dev.workshop;

import java.util.stream.Stream;

public class FlatMapTest {

    static Stream<String> addPrefix(String prefix) {
        return Stream.of("java", "duke")
                .map(str -> prefix + " " + str);
    }

    public static void main(String[] args) {
        var message = Stream.of("hey", "hi")
                .flatMap(FlatMapTest::addPrefix)
                .toList();
        System.out.println(message);
    }
}