package workshop.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

class DirectoryIterationTest {

    private DirectoryIteration obj;

    @BeforeEach
    public void setUp() {
        obj = new DirectoryIteration();
    }

    @Test
    @Disabled
    public void testListDirectoriesUsingWalk() {
        List<Path> directories = obj.listDirectoriesUsingWalk();
        System.out.println("total directories: " + directories.size());
        Assertions.assertNotNull(directories);
    }

    @Test
    @Disabled
    public void testListDirectoriesUsingWalkDepthAsOne() {
        List<Path> directories = obj.listDirectoriesUsingWalkDepthAsOne();
        System.out.println("total directories: " + directories.size());
        Assertions.assertNotNull(directories);
    }

    @Test
    @Disabled
    public void testListDirectoriesUsingFileApi() {
        List<String> directories = obj.listDirectoriesUsingFileApi();
        Assertions.assertNotNull(directories);
        System.out.println("total directories: " + directories.size());
    }

    @Test
    @Disabled
    public void testListDirectoriesUsingFind() {
        List<String> directories = obj.listDirectoriesUsingFind();
        Assertions.assertNotNull(directories);
        System.out.println("total directories: " + directories.size());
    }

    @Test
    @Disabled
    public void testListDirectoriesUsingFindDepthAsOne() {
        List<String> directories = obj.listDirectoriesUsingFindDepthAsOne();
        Assertions.assertNotNull(directories);
        directories.forEach(System.out::println);
        System.out.println("total directories: " + directories.size());
    }

    @Test
//    @Disabled
    public void testListDirectoriesUsingFileFilter() {
        List<String> directories = obj.listDirectoriesUsingFileFilter();
        Assertions.assertNotNull(directories);
        directories.forEach(System.out::println);
        System.out.println("total directories: " + directories.size());
    }
}