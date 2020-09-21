package workshop;

import java.util.List;

public class User {

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "---" + age;
    }

    public static List<User> getUsers() {
        return List.of(new User(),
                new User("Sara", 20),
                new User("Sara", 22),
                new User("Nancy", 22),
                new User("Bob", 20),
                new User("Paula", 32),
                new User("Paul", 32),
                new User("Jack", 3),
                new User("Jack", 72),
                new User("Jill", 11));
    }
}
