import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeTest {

    private static DateTime obj;

    @BeforeAll
    private static void init() {
        obj = new DateTime();
    }

    @Test
    public void parseDate() {
        LocalDate localDate = obj.parse("07/30/2020", "MM/dd/yyyy");
        System.out.println("local date: " + localDate);
        assertThat(localDate).isEqualTo(LocalDate.of(2020, 07, 30));
    }

    @Test
    public void testDayDifferenceUsingChronoUtil() {
        LocalDate previousDay = obj.parse("07/25/2020", "MM/dd/yyyy");
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(previousDay, today);
        System.out.println("day difference: " + days);
        assertThat(days).isEqualTo(6);
    }

    @Test
    public void testDayDifferenceUsingDuration() {
        LocalDate oldDate = obj.parse("20-07-2020", "dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        Duration duration = Duration.between(oldDate.atStartOfDay(), today.atStartOfDay());
        long days = duration.toDays();
        System.out.println("day difference: " + days);
    }

    @Test
    public void testDayDifferenceUsingUntil() {
        LocalDate oldDate = obj.parse("12-07-2020", "dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        Period until = oldDate.until(today);
        System.out.println("day difference: " + until.getDays());
    }

    @Test
    public void testDayDifferenceUsingUntilChrono() {
        LocalDate oldDate = obj.parse("18-07-2020", "dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        long until = oldDate.until(today, ChronoUnit.DAYS);
        System.out.println("day difference: " + until);
    }
}