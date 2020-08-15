package workshop;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionConversionTest {

    @Test
    public void convertMapToSet() {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1001, new User(1001, "Subodh", 30));
        userMap.put(1002, new User(1002, "Juli", 22));
        userMap.put(1003, new User(1003, "Harsh", 3));
        userMap.put(1004, new User(1004, "Diksha", 8));
        userMap.put(1005, new User(1005, "Nidhi", 6));
        userMap.put(1006, new User(1006, "Akash", 20));
        userMap.put(1007, new User(1007, "Bindiya", 18));

        System.out.println("user map -->");
        userMap.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v.toString()));

        System.out.println("\nuser set -->");
        Set<User> users = new HashSet<>(userMap.values());
        users.forEach(System.out::println);
    }
}

