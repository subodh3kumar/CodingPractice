package workshop;

import org.junit.jupiter.api.Test;

class SwitchExpressionTest {

    @Test
    void testSwitchExpressionStringFormat() {
        Object o = 123L;
        String formatted = switch (o) {
            case Integer i when i == 42 -> String.format("int 42: %d", i);
            case Integer i -> String.format("int: %d", i);
            case Long l -> String.format("long: %d", l);
            case null, default -> "something else";
        };
        System.out.println(formatted);
    }
}
