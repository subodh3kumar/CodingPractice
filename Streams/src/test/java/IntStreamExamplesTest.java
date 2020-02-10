import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.*;

@TestInstance(Lifecycle.PER_CLASS)
public class IntStreamExamplesTest {

    IntegerStream obj = null;

    @BeforeAll
    public void init() {
        obj = new IntegerStream();
    }

    @Test
    @DisplayName("test max value")
    public void testMaxValue() {
        int[] array = {4, 6, 8, 3, 1};
        assertEquals(8, obj.getMaxValue(array));
    }
}