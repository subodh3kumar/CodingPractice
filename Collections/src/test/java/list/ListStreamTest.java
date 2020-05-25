package list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListStreamTest {

    @Test
    @DisplayName("test removeIf Exception")
    public void testRemoveIfException() {
        String[] array = {"Java", "Hibernate", "Spring", "JakartaEE"};
        List<String> list = Arrays.asList(array);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            list.removeIf(e -> e.equals("Spring"));
        });
        System.out.println(exception.getMessage());
        assertTrue("remove".equals(exception.getMessage()));
    }

    @Test
    @DisplayName("test removeIf")
    public void testRemoveIf() {
        String[] array = {"Java", "Hibernate", "Spring", "JakartaEE"};
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        list.removeIf(element -> element.equals("Spring"));
        list.forEach(System.out::println);
    }
}
