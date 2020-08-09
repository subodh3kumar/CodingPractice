import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentListTest {

    @Test
    @DisplayName("test copyOnWrite")
    public void testCopyOnWrite() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        for (String str: list) {
            System.out.println(str);
        }
    }
}
