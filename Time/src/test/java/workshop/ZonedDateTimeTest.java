package workshop;


import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class ZonedDateTimeTest {

    @Test
    void testZonedDateTimeString() {
        String formatted = " %s ".formatted(ZonedDateTime.now());
        System.out.println(formatted);

        String formatted2 = " %tQ ".formatted(ZonedDateTime.now());
        System.out.println(formatted2);

        String formatted3 = " %tF ".formatted(ZonedDateTime.now());
        System.out.println(formatted3);

        String formatted4 = " %tD ".formatted(ZonedDateTime.now());
        System.out.println(formatted4);
    }
}
