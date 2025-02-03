package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    @Test
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
    public void testAddAllThrowUnsupportedOperationException() {
        List<Integer> integers = Arrays.asList(1, 2, 3);

        Integer[] ints = {4, 5, 6};

        Throwable throwable = Assertions.assertThrows(Throwable.class, () -> {
            Collections.addAll(integers, ints);
        });
        Assertions.assertEquals(UnsupportedOperationException.class, throwable.getClass());
    }
}
