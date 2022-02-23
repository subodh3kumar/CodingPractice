package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharAtTest {

    @Test
    void testCharAt() {
        String name = "subodh";
        Assertions.assertEquals('s', name.charAt(0));
    }

    @Test
    void testCharAt2() {
        String name = "subodh";
        Assertions.assertEquals((115 * 117), (name.charAt(0) * name.charAt(1)));
    }
}
