package workshop.records;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializableDemoRecord {

    public static void main(String[] args) throws Exception {
        //serialize();
        deserialize();
    }

    private static void deserialize() throws Exception {
        final var inputStream = Files.newInputStream(Path.of("files/range-record-10-0.dat"));
        final var objectInputStream = new ObjectInputStream(inputStream);

        System.out.println("Reading Range:");

        final var range = objectInputStream.readObject();

        System.out.println("Range: " + range);
    }

    private static void serialize() throws Exception {
        var range = new Range(10, 0);
        System.out.println("Range: " + range);

        final var outputStream = Files.newOutputStream(Path.of("files/range-record-10-0.dat"));
        final var objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(range);
    }

    record Range(int begin, int end) implements Serializable {

        // comment before running the serialize() method
        // uncomment before running the deserialize() method
        Range {
            if (begin > end) {
                throw new IllegalArgumentException("begin should be smaller than end");
            }
        }
    }
}
