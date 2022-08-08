package workshop.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapStreamTest {

    private Map<String, Integer> map;

    @BeforeEach
    public void init() {
        map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
    }

    @AfterEach
    public void destroy() {
        map = null;
    }


    @Test
    @DisplayName("remove by value")
    public void removeByValue() {
        map.values().removeIf(entry -> entry == 3);
        display(map);

    }

    private void display(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.println(k + " --> " + v));
    }
}
