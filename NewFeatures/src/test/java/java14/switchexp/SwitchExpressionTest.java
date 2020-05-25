package java14.switchexp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwitchExpressionTest {

    @Test
    public void traditionalSwitch() {
        SwitchExpression obj = new SwitchExpression();

        assertEquals(6, obj.traditionalSwitch("MONDAY"));
        assertEquals(7, obj.traditionalSwitch("TUESDAY"));
        assertEquals(8, obj.traditionalSwitch("THURSDAY"));
        assertEquals(9, obj.traditionalSwitch("WEDNESDAY"));

        Exception exception = assertThrows(IllegalStateException.class, () -> obj.traditionalSwitch("hello"));
        assertEquals("Unexpected value", exception.getMessage());
    }

    @Test
    public void newSwitchStatement() {
        SwitchExpression obj = new SwitchExpression();

        assertEquals(6, obj.newSwitchStatement("MONDAY"));
        assertEquals(7, obj.newSwitchStatement("TUESDAY"));
        assertEquals(8, obj.newSwitchStatement("THURSDAY"));
        assertEquals(9, obj.newSwitchStatement("WEDNESDAY"));

        Exception exception = assertThrows(IllegalStateException.class, () -> obj.newSwitchStatement("hello"));
        assertEquals("Unexpected value", exception.getMessage());
    }
}