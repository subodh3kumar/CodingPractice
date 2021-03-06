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

        for (String element : iterable) {
            System.out.println(element);
        }
        System.out.println("----");

        iterable.forEach(System.out::println);

        System.out.println("----");

        Iterator<String> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        System.out.println("----");

        Spliterator<String> spliterator = iterable.spliterator();
        spliterator.forEachRemaining(System.out::println);
    }
}
