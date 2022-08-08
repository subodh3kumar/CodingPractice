package workshop.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void testMapDuplicateKey() {
        Map<String, Integer> map = new HashMap<>();

        map.put("ONE", 1);
        map.put("ONE", 100);

        System.out.println(map);

        map.put(null, null);
        map.put(null, 200);

        System.out.println(map);
        Assertions.assertEquals(2, map.size());
    }
}
