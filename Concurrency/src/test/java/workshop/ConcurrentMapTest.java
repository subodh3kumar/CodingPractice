package workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentMapTest {

    @Test
    @DisplayName("not thread safe")
    public void testCharOccurrenceMap() {
        System.out.println("not thread safe");
        Map<Character, LongAdder> occurrences = new Hashtable<>();
        String str = "abcd abcd abcd";

        for (char character: str.toCharArray()) {
            LongAdder longAdder = occurrences.get(character);
            if (longAdder == null) {
                longAdder = new LongAdder();
            }
            longAdder.increment();
            occurrences.put(character, longAdder);
        }
        System.out.println(occurrences);
    }

    @Test
    @DisplayName("thread safe")
    public void testCharOccurrenceConcurrentMap() {
        System.out.println("thread safe");
        ConcurrentMap<Character, LongAdder> occurrences = new ConcurrentHashMap<>();
        String str = "abcd abcd abcd";

        for (char character: str.toCharArray()) {
            occurrences.computeIfAbsent(character, ch -> new LongAdder()).increment();
        }
        System.out.println(occurrences);
    }
}
