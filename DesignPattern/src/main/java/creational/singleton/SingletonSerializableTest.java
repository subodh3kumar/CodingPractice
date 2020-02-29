package creational.singleton;

public class SingletonSerializableTest {

    public static void main(String[] args) {
        SingletonSerializable s1 = SingletonSerializable.getInstance();
        SingletonSerializable s2 = SingletonSerializable.getInstance();

        display("s1", s1);
        display("s2", s2);
    }

    private static void display(String name, SingletonSerializable obj) {
        System.out.println(String.format("object: %s, Hashcode: %d", name, obj.hashCode()));
    }
}
