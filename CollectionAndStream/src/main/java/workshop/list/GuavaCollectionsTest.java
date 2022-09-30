package workshop.list;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GuavaCollectionsTest {

    private List<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = getNumbers();
    }

    private List<Integer> getNumbers() {
        return ThreadLocalRandom.current()
                .ints(800, 10_000, 100_000)
                .boxed()
                .toList();
    }

    @Test
    public void testListsPartition() {
        List<List<Integer>> partitionedList = Lists.partition(numbers, 1000);
        System.out.println(partitionedList.size());
        for (List<Integer> list : partitionedList) {
            System.out.println(list.size());
        }
    }
}
