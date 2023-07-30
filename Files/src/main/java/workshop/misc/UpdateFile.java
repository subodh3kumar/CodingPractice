package workshop.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UpdateFile {

    private static final String SOURCE_PATH = "/Development/Workspace/IDEA/CodingPractice/Files/src/main/resources/words.txt";

    public static void main(String[] args) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(SOURCE_PATH));
            String firstLine = lines.get(0);
            System.out.println("first line: " + firstLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
