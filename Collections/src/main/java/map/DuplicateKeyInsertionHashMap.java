package map;

import java.util.HashMap;
import java.util.Map;

public class DuplicateKeyInsertionHashMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("ONE", 1);
        map.put("ONE", 100);

        map.put(null, null);
        map.put(null, 200);

        System.out.println(map);
    }
}
