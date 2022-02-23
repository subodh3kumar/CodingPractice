package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void testContainsList() {
        List<String> list = new ArrayList<>();
        list.add("juli");
        list.add("subodh");
        list.add("akash");
        list.add("diksha");

        Assertions.assertEquals(4, list.size());

        if (list.contains("subodh")) {
            list.remove("subodh");
        }
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void testRemove() {
        List<String> words = new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");

        System.out.println("size of list: " + words.size());
        System.out.println("before remove, list is:");
        words.forEach(System.out::println);

        words.remove(0);
        words.remove(words.size() - 1);

        System.out.println("\nsize of list: " + words.size());
        System.out.println("after remove, list is:");
        words.forEach(System.out::println);
    }
}
