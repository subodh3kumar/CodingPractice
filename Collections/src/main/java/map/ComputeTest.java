package map;

import java.util.HashMap;

public class ComputeTest {

    public static void main(String[] args) {
        compute();
        System.out.println("-----------");
        compute2();
        System.out.println("-----------");
        compute3();
    }

    private static void compute3() {
        var map = new HashMap<String, Integer>();
        map.put("key1", 12);
        map.put("key2", 22);
        System.out.println(map);
        try {
            map.compute(null, (k, v) -> v + 3);
            System.out.println("New map: " + map);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    private static void compute2() {
        var map = new HashMap<String, Integer>();
        map.put("key1", 12);
        map.put("key2", 22);
        System.out.println(map);
        map.compute("key1", (k, v) -> (v == null) ? 1 : ++v);
        map.compute("key2", (k, v) -> (v == null) ? 1 : ++v);
        System.out.println(map);
    }

    private static void compute() {
        var map = new HashMap<String, String>();
        map.put("Name", "Subodh");
        map.put("Address", "Chennai");
        System.out.println(map);
        map.compute("Name", (k, v) -> v.concat("_Kumar"));
        map.compute("Address", (k, v) -> v.concat("_TN"));
        System.out.println(map);
    }
}
