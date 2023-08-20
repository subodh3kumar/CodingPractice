package workshop.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    @Test
    public void testDuplicateKeyHashMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("ONE", 1);
        map.put("ONE", 100);

        System.out.println(map);

        map.put(null, null);
        map.put(null, 200);

        System.out.println(map);
        Assertions.assertEquals(2, map.size());
    }

    @Test
    public void testTreeMapNull() {
        Map<String, Integer> map = new TreeMap<>();

        map.put("ONE", 1);
        map.put("TWO", 2);

        System.out.println(map);

        Assertions.assertThrows(NullPointerException.class, () -> {
            map.put(null, 3);
        });
    }

    @Test
    public void testLinkedHashMapNull() {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put(null, 3);

        System.out.println(map);
    }
}
