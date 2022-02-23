package workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class IntStreamTest {

    @Test
    @DisplayName("max value")
    public void maxValue() {
        int[] array = {4, 6, 8, 3, 1};
        int max = IntStream.of(array).max().getAsInt();
        System.out.println("Max: " + max);
    }
}