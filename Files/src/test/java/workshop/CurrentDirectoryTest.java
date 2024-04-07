package workshop;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Objects;


public class CurrentDirectoryTest {

    @Test
    public void testDirectory() throws IOException {
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        System.out.println("parent class path: " + path);

        Path absolutePath = Path.of("").toAbsolutePath();
        System.out.println("absolute path: " + absolutePath);

        Path fileSystemAbsolutePath = FileSystems.getDefault().getPath("").toAbsolutePath();
        System.out.println("absolute path: " + fileSystemAbsolutePath);

        Path realPath = Path.of("").toRealPath();
        System.out.println("real path: " + realPath);

        String property = System.getProperty("user.dir");
        System.out.println("property: " + property);

        String normalizePath = Path.of(".").toAbsolutePath().normalize().toString();
        System.out.println("normalize path: " + normalizePath);

        URL location = CurrentDirectoryTest.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("location: " + location.getFile());
    }
}
