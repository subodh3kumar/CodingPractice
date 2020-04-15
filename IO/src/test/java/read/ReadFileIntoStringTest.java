package read;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileIntoStringTest {

    private static Path workingDir;

    @BeforeAll
    public static void init() {
        workingDir = Paths.get("", "src/test/resources");
    }

    @Test
    @DisplayName("read file using Java 11")
    public void testReadFileUsingJava11() throws IOException {
        Path file = workingDir.resolve("names.txt");
        //Path file = Paths.get("src/test/resources/names.txt");
        String content = Files.readString(file);
        System.out.println(content);
        MatcherAssert.assertThat(content, CoreMatchers.is("subodh\r\njuli"));
    }
}
