package creational.singleton;

import java.io.Serializable;

public class SingletonSerializable implements Serializable {

    private static SingletonSerializable singleton = new SingletonSerializable();

    private SingletonSerializable() {
        System.out.println("eager creation.");
        System.out.println("serialization issue.");
    }

    public static SingletonSerializable getInstance() {
        return singleton;
    }
}
