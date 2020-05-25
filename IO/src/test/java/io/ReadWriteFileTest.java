package io;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteFileTest {

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
        MatcherAssert.assertThat(content, CoreMatchers.is("subodh"));
    }

    @Test
    @DisplayName("write file using Java 11")
    public void testWriteFileUsingJava11() throws IOException {
        Path file = workingDir.resolve("welcome.txt");
        //Path file = Paths.get("src/test/resources/welcome.txt");
        String content = "Hello Subodh, learn Java very well.";
        Files.writeString(file, content);
        String actual = Files.readString(file);
        Assertions.assertEquals(content, actual);
    }
}
