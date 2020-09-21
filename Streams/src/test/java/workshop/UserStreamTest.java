package workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserStreamTest {


    public static void main(String[] args) {
        List<User> users = User.getUsers();

        // Iterate persons
        users.stream().forEach(System.out::println);
        System.out.println("----------");

        // Display person names where age > 30, using reduce function
        List<String> personNamesAgeGT30 = users.stream()
                .filter(person -> person.getAge() > 30)
                .map(User::getName)
                .map(String::toUpperCase)
                .reduce(new ArrayList<String>(),
                        (names, name) -> {
                            names.add(name);
                            return names;
                        },
                        (names1, names2) -> {
                            names1.addAll(names2);
                            return names1;
                        });
        personNamesAgeGT30.forEach(System.out::println);

        System.out.println("----------");

        // Display person names where age > 30, using collect function
        List<String> personsAgeGT30 = users.stream()
                .filter(user -> user.getAge() > 30)
                .map(User::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        personsAgeGT30.forEach(System.out::println);
    }
}
