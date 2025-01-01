package workshop.misc;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerFileReader {

    record Dev(String name, boolean javaDev, int age) {
    }

    public static void main(String[] args) {
        var path = Path.of("src/main/resources/devs.txt");
        try (var scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                var dev = new Dev(scanner.next(), scanner.nextBoolean(), scanner.nextInt());
                System.out.println(dev);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
