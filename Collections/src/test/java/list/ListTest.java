package list;

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

}
