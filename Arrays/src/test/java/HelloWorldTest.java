import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    public void testFunc() {
        HelloWorld obj = new HelloWorld();
        assertEquals("HELLO", obj.func("hello"));
    }
}