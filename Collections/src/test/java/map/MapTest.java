package map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapTest {

    @Test
    public void testMapDuplicateKey() {
        Map<String, Integer> map = new HashMap<>();

        map.put("ONE", 1);
        map.put("ONE", 100);

        log.info(map.toString());

        map.put(null, null);
        map.put(null, 200);

        log.info(map.toString());
    }
}
