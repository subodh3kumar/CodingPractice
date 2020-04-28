package creational.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("singleton serializable test")
    public void singletonSerializableTest() {
        SingletonSerializable s1 = SingletonSerializable.getInstance();
        SingletonSerializable s2 = SingletonSerializable.getInstance();

        displaySerializable("s1", s1);
        displaySerializable("s2", s2);
    }

    private void displaySerializable(String name, SingletonSerializable obj) {
        System.out.println(String.format("object: %s, Hashcode: %d", name, obj.hashCode()));
    }
}