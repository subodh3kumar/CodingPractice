package workshop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserStreamTest {


    @Test
    public void displayUsersAgeGT30() {
        // Iterate persons
        users().forEach(System.out::println);
        System.out.println("----------");

        // Display person names where age > 30, using reduce function
        System.out.println("reduce(): ");
        List<String> userAgeGT30Reduce = users().stream()
                .filter(person -> person.age() > 30)
                .map(User::name)
                .map(String::toUpperCase)
                .reduce(new ArrayList<>(),
                        (names, name) -> {
                            names.add(name);
                            return names;
                        },
                        (names1, names2) -> {
                            names1.addAll(names2);
                            return names1;
                        });
        userAgeGT30Reduce.forEach(System.out::println);

        // Display person names where age > 30, using collect function
        System.out.println("toList(): ");
        List<String> userAgeGT30Collect = users().stream()
                .filter(user -> user.age() > 30)
                .map(User::name)
                .map(String::toUpperCase)
                .toList();

        userAgeGT30Collect.forEach(System.out::println);
    }

    record User(String name, int age) {

    }

    private List<User> users() {
        return List.of(
                new User("Sara", 20),
                new User("Sara", 22),
                new User("Nancy", 22),
                new User("Bob", 20),
                new User("Paula", 32),
                new User("Paul", 32),
                new User("Jack", 3),
                new User("Jack", 72),
                new User("Jill", 11)
        );
    }
}
