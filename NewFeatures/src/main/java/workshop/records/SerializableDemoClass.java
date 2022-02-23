package workshop.records;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializableDemoClass {

    public static void main(String[] args) throws Exception {
        //serialize();
        deserialize();
    }

    private static void deserialize() throws Exception {
        final var inputStream = Files.newInputStream(Path.of("files/range-class-10-0.dat"));
        final var objectInputStream = new ObjectInputStream(inputStream);

        System.out.println("Reading Range:");

        final var range = objectInputStream.readObject();

        System.out.println("Range: " + range);
    }

    private static void serialize() throws Exception {
        var range = new Range(10, 0);
        System.out.println("Range: " + range);

        final var outputStream = Files.newOutputStream(Path.of("files/range-class-10-0.dat"));
        final var objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(range);
    }

    static class Range implements Serializable {
        private final int begin;
        private final int end;

        public Range(int begin, int end) {

            // comment before running the serialize() method
            // uncomment before running the deserialize() method
            if (begin > end) {
                throw new IllegalArgumentException("begin should be smaller than end");
            }
            this.begin = begin;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "begin=" + begin +
                    ", end=" + end +
                    '}';
        }
    }
}


