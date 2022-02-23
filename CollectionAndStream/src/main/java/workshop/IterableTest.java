package workshop;

import org.junit.jupiter.api.Test;

import java.util.*;

public class IterableTest {

    @Test
    public void testIterable() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Collection<String> collection = list;
        Iterable<String> iterable = collection;

        System.out.println("Iterable: ");
        for (String str : iterable) {
            System.out.println(str);
        }

        System.out.println("Iterator: ");
        Iterator<String> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        System.out.println("Spliterator: ");
        Spliterator<String> spliterator = iterable.spliterator();
        spliterator.forEachRemaining(System.out::println);
    }
}
