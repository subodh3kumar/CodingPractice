package workshop.list;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListTest {
    private List<String> fruits;

    @BeforeEach
    public void init() {
        fruits = new ArrayList<>();
        fruits.add("banana");
        fruits.add("mango");
        fruits.add("orange");
        fruits.add("apple");
    }

    @Test
    @Disabled
    @DisplayName("test list contains")
    public void testContainsList() {
        Assertions.assertEquals(4, fruits.size());

        boolean isBananaAvailable = fruits.contains("banana");
        Assertions.assertTrue(isBananaAvailable);

        boolean isCoconutAvailable = fruits.contains("coconut");
        Assertions.assertFalse(isCoconutAvailable);
    }

    @Test
    @Disabled
    @DisplayName("test list remove")
    public void testRemove() {
        System.out.println("size of list: " + fruits.size());
        System.out.println("before remove, list is:");
        fruits.forEach(System.out::println);

        fruits.remove(0);
        fruits.remove(fruits.size() - 1);

        System.out.println("\nsize of list: " + fruits.size());
        System.out.println("after remove, list is:");
        fruits.forEach(System.out::println);
    }

    @Test
    @DisplayName("test list merge")
    public void mergeList() {
        var list1 = List.of(1, 2);
        var list2 = List.of(3, 4);
        var ints = Stream.concat(list1.stream(), list2.stream()).toList();
        Assertions.assertEquals(4, ints.size());
        ints.forEach(System.out::println);
    }
}
