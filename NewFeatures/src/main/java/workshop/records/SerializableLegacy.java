package workshop.records;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializableLegacy {

    public static void main(String[] args) throws Exception {
        serialize();
        deserialize();
    }

    private static void deserialize() throws Exception {
        final var inputStream = Files.newInputStream(Path.of("files/range-legacy-10-0.dat"));
        final var objectInputStream = new ObjectInputStream(inputStream);

        System.out.println("Reading Range:");

        final var range = objectInputStream.readObject();

        System.out.println("Range: " + range);
    }

    private static void serialize() throws Exception {
        final var rangeLegacy = new RangeLegacy(10, 0);

        System.out.println("Range: " + rangeLegacy);

        final var outputStream = Files.newOutputStream(Path.of("files/range-legacy-10-0.dat"));
        final var objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(rangeLegacy);
    }

    public static class RangeLegacy implements Serializable {
        private final int begin;
        private final int end;

        public RangeLegacy(int begin, int end) {
            //Validator.validate(begin, end);
            this.begin = begin;
            this.end = end;
        }

        @Override
        public String toString() {
            return "RangeLegacy{" +
                    "begin=" + begin +
                    ", end=" + end +
                    '}';
        }

        @Serial
        private Object writeReplace() throws Exception {
            System.out.println("Serializing a record proxy:");
            return new RangeProxy(begin, end);
        }
    }

    record RangeProxy(int begin, int end) implements Serializable {

        public RangeProxy {
            Validator.validate(begin, end);
        }

        @Serial
        private Object readResolve() throws Exception {
            System.out.println("Creating the real object:");
            return new RangeLegacy(begin, end);
        }
    }

    public static class Validator {
        public static void validate(int begin, int end) {
            if (begin > end) {
                throw new IllegalArgumentException("begin should be smaller than end");
            }
        }
    }
}
