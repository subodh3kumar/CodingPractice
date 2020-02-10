import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    private static final List<Person> persons = createPerson();

    public static void main(String[] args) {
        // Iterate persons
        // createPerson().stream().forEach(System.out::println);

        // Display person names where age > 30, using reduce function
        /*List<String> personNamesAgeGT30 = persons.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
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
        personNamesAgeGT30.forEach(System.out::println);*/

        // Display person names where age > 30, using collect function
        List<String> personsAgeGT30 = persons.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        personsAgeGT30.forEach(System.out::println);

    }

    private static List<Person> createPerson() {
        return List.of(new Person(),
                new Person("Sara", 20),
                new Person("Sara", 22),
                new Person("Nancy", 22),
                new Person("Bob", 20),
                new Person("Paula", 32),
                new Person("Paul", 32),
                new Person("Jack", 3),
                new Person("Jack", 72),
                new Person("Jill", 11));
    }
}
