package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharAtTest {

    @Test
    public void testCharAt() {
        String name = "subodh";
        Assertions.assertEquals('s', name.charAt(0));
    }

    @Test
    public void testCharAt2() {
        String name = "subodh";
        Assertions.assertEquals((115 * 117), (name.charAt(0) * name.charAt(1)));
    }
}
