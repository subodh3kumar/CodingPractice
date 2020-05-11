package map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Slf4j
class MapComputeTest {

    @Test
    public void testCompute1() {
        var map = new HashMap<String, String>();
        map.put("Name", "Subodh");
        map.put("Address", "Chennai");

        log.info(map.toString());

        map.compute("Name", (k, v) -> v.concat("_Kumar"));
        map.compute("Address", (k, v) -> v.concat("_TN"));

        log.info(map.toString());
    }


    @Test
    public void testCompute2() {
        var map = new HashMap<String, Integer>();
        map.put("key1", 12);
        map.put("key2", 22);

        log.info(map.toString());

        map.compute("key1", (k, v) -> (v == null) ? 1 : ++v);
        map.compute("key2", (k, v) -> (v == null) ? 1 : ++v);

        log.info(map.toString());
    }

    @Test
    public void testCompute3() {
        var map = new HashMap<String, Integer>();
        map.put("key1", 12);
        map.put("key2", 22);

        log.info(map.toString());

        try {
            map.compute(null, (k, v) -> v + 3);
            log.info("New map: " + map);
        } catch (Exception e) {
            log.error("Exception: " + e);
        }
    }
}