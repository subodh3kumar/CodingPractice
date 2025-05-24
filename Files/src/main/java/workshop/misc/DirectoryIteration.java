package workshop.misc;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryIteration {

    private static final String PATH = "C:/Users/subod/Workspace/Idea";

    public List<Path> listDirectoriesUsingWalk() {
        try (Stream<Path> paths = Files.walk(Path.of(PATH))) {
            return paths.filter(Files::isDirectory).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Path> listDirectoriesUsingWalkDepthAsOne() {
        try (Stream<Path> paths = Files.walk(Path.of(PATH), 1)) {
            return paths.filter(Files::isDirectory).toList();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public List<String> listDirectoriesUsingFileApi() {
        Path path = Path.of(PATH);
        File[] files = path.toFile().listFiles();

        if (files != null && files.length > 0) {
            return Arrays.stream(files)
                    .filter(File::isDirectory)
                    .map(File::getAbsolutePath)
                    .toList();
        } else {
            throw new RuntimeException();
        }
    }

    public List<String> listDirectoriesUsingFind() {
        Path directory = Path.of(PATH);
        try (Stream<Path> paths = Files.find(directory, Integer.MAX_VALUE, (_, attributes) -> attributes.isDirectory())) {
            return paths.map(path -> path.toAbsolutePath().toString()).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listDirectoriesUsingFindDepthAsOne() {
        Path directory = Path.of(PATH);
        try (Stream<Path> paths = Files.find(directory, 1, (_, attributes) -> attributes.isDirectory())) {
            return paths.map(path -> path.toAbsolutePath().toString()).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listDirectoriesUsingFileFilter() {
        Path directory = Path.of(PATH);

        String[] directories = directory.toFile().list((current, name) -> new File(current, name).isDirectory());
        assert directories != null;
        return Arrays.stream(directories).toList();
    }
}
