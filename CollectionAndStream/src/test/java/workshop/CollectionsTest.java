package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    @Test
    @Disabled
    public void testAddAll() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Integer[] ints = {4, 5, 6};

        boolean flag = Collections.addAll(integers, ints);

        System.out.println("flag: " + flag);
        System.out.println("integers: " + integers);
    }

    @Test
    @Disabled
    public void testAddAllThrowUnsupportedOperationException() {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        Integer[] ints = {4, 5, 6};

        Throwable throwable = Assertions.assertThrows(Throwable.class, () -> {
            Collections.addAll(integers, ints);
        });
        Assertions.assertEquals(UnsupportedOperationException.class, throwable.getClass());
    }

    @Test
    public void testStreamUpperCaseWrongApproach() {
        List<String> names = List.of("Ram", "Krishna", "Parth", "Shiva", "Vishnu");
        List<String> inUpperCase = new ArrayList<>();

        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> inUpperCase.add(name));

        System.out.println(names.size());
        System.out.println(inUpperCase.size());
    }

    @Test
    public void testStreamUpperCaseCorrectApproach() {
        List<String> names = List.of("Ram", "Krishna", "Parth", "Shiva", "Vishnu");
        List<String> inUpperCase = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(names.size());
        System.out.println(inUpperCase.size());
    }
}
