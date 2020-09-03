package workshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemoveElements {

    public static void main(String[] args) {
        List<User> users = new LinkedList<>(getUserList());
        System.out.println("users before deletion");
        users.forEach(System.out::println);
        System.out.println("users size: " + users.size());
        System.out.println("\nusers after deletion");
        List<Integer> idsToBeRemove = getIds();
        remove(users, idsToBeRemove);
        users.forEach(System.out::println);
        System.out.println("users size: " + users.size());
    }

    private static void remove(List<User> users, List<Integer> ids) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            int id = user.getId();
            if (ids.contains(id)) {
                iterator.remove();
            }
        }
    }

    private static List<Integer> getIds() {
        return List.of(103, 106, 107, 109);
    }

    private static List<User> getUserList() {
        return Arrays.asList(
                new User(100, "Subodh"),
                new User(101, "Juli"),
                new User(102, "Akash"),
                new User(103, "Harsh"),
                new User(104, "Diksha"),
                new User(105, "Nidhi"),
                new User(106, "Gaurav"),
                new User(107, "Devraj"),
                new User(108, "Anu"),
                new User(109, "Vinit"),
                new User(1010, "Pihu")
        );
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class User {
        private int id;
        private String name;
    }
}
