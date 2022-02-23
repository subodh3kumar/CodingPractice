package workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListStreamTest {

    @Test
    @DisplayName("test list removeIf Exception")
    public void testRemoveIfException() {
        String[] array = {"Java", "Hibernate", "Spring", "JakartaEE"};
        List<String> list = Arrays.asList(array);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            list.removeIf(e -> e.equals("Spring"));
        });
        System.out.println(exception.getMessage());
        assertEquals("remove", exception.getMessage());
    }

    @Test
    @DisplayName("test list removeIf")
    public void testRemoveIf() {
        String[] array = {"Java", "Hibernate", "Spring", "JakartaEE"};
        List<String> list = Arrays.stream(array).collect(Collectors.toList());

        list.removeIf(element -> element.equals("Spring"));

        list.forEach(System.out::println);

        assertEquals(3, list.size());
    }
}
