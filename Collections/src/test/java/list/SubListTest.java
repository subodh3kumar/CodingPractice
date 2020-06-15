package list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SubListTest {

    @Test
    @DisplayName("subList example")
    public void testSubList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println("original list: " + list);

        List<String> subList = list.subList(2, 4);
        System.out.println("sub list: " + subList);
    }
}
