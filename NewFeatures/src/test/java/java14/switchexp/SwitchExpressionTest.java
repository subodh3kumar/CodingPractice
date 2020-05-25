package java14.switchexp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import util.Constants;
import util.Month;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwitchExpressionTest implements Constants {

    private static SwitchExpression obj;

    @BeforeAll
    public static void init() {
        obj = new SwitchExpression();
    }

    @AfterAll
    public static void destroy() {
        obj = null;
    }

    @Test
    public void traditionalSwitch() {
        assertEquals(6, obj.traditionalSwitch(SUNDAY));
        assertEquals(7, obj.traditionalSwitch(TUESDAY));
        assertEquals(8, obj.traditionalSwitch(THURSDAY));
        assertEquals(9, obj.traditionalSwitch(WEDNESDAY));

        Exception exception = assertThrows(IllegalStateException.class, () -> obj.traditionalSwitch("hello"));
        assertEquals("Unexpected value", exception.getMessage());
    }

    @Test
    public void newSwitchStatement() {
        assertEquals(6, obj.newSwitchStatement(MONDAY));
        assertEquals(7, obj.newSwitchStatement(TUESDAY));
        assertEquals(8, obj.newSwitchStatement(SATURDAY));
        assertEquals(9, obj.newSwitchStatement(WEDNESDAY));

        Exception exception = assertThrows(IllegalStateException.class, () -> obj.newSwitchStatement("hello"));
        assertEquals("Unexpected value", exception.getMessage());
    }

    @Test
    public void testTraditionalSwitchWithYield() {
        assertEquals(FIRST_QUARTER, obj.traditionalSwitchWithYield(Month.FEBRUARY));
        assertEquals(SECOND_QUARTER, obj.traditionalSwitchWithYield(Month.MAY));
        assertEquals(FIRST_QUARTER, obj.traditionalSwitchWithYield(Month.FEBRUARY));
        assertEquals(FIRST_QUARTER, obj.traditionalSwitchWithYield(Month.FEBRUARY));
        assertEquals(UNKNOWN, obj.traditionalSwitchWithYield(Month.UNKNOWN));
    }

    @Test
    public void testSwitchWithYield() {
        assertEquals(FIRST_QUARTER, obj.traditionalSwitchWithYield(Month.FEBRUARY));
        assertEquals(SECOND_QUARTER, obj.traditionalSwitchWithYield(Month.MAY));
        assertEquals(FIRST_QUARTER, obj.traditionalSwitchWithYield(Month.FEBRUARY));
        assertEquals(FIRST_QUARTER, obj.traditionalSwitchWithYield(Month.FEBRUARY));
        assertEquals(UNKNOWN, obj.traditionalSwitchWithYield(Month.UNKNOWN));
    }
}