package workshop.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import workshop.model.Developer;

import java.util.List;
import java.util.Map;

public class SetTest {

    @Test
    public void testEntrySetWithRecord() {
        Map<String, Integer> developers = Map.of("Java", 30, "JavaScript", 30, "Ruby", 35);

        List<Developer> developerList = developers.entrySet().stream()
                .map(Developer::new)
                .toList();

        developerList.forEach(System.out::println);
        Assertions.assertEquals(3, developerList.size());
    }
}
