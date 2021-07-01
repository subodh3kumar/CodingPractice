package workshop;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetAllFilesFromDirectory {

    private static final String PATH = "C:\\Development\\Workspace\\IDEA\\CodingPractice\\Files\\src\\main\\resources\\directory\\";

    public static void main(String[] args) {
        List<File> files = getAllFiles(PATH, "HELLO");
        files.forEach(file -> System.out.println("file name: " + file.getName()));
    }

    private static List<File> getAllFiles(String directory, String pattern) {
        return Arrays.stream(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(file -> file.getName().toLowerCase().startsWith(pattern.toLowerCase()))
                .sorted(Comparator.comparing(File::getName).reversed())
                .collect(Collectors.toList());
        /*File[] files = new File(directory).listFiles();
        for (File file : files) {
            System.out.println("file name: " + file.getName());
            if (file.getName().startsWith("HELLO")) {
                System.out.println("yes");
            }
        }
        return null;*/
    }
}
