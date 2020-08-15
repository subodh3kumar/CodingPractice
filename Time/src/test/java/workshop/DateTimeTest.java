package workshop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeTest {

    private static DateTime obj;

    @BeforeAll
    private static void init() {
        obj = new DateTime();
    }

    @Test
    @Disabled
    public void parseDate() {
        LocalDate localDate = obj.parse("07/30/2020", "MM/dd/yyyy");
        System.out.println("local date: " + localDate);
        assertThat(localDate).isEqualTo(LocalDate.of(2020, 07, 30));
    }

    @Test
    @Disabled
    public void testDayDifferenceUsingChronoUtil() {
        LocalDate previousDay = obj.parse("07/25/2020", "MM/dd/yyyy");
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(previousDay, today);
        System.out.println("day difference: " + days);
        assertThat(days).isEqualTo(19);
    }

    @Test
    @Disabled
    public void testDayDifferenceUsingDuration() {
        LocalDate oldDate = obj.parse("20-07-2020", "dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        Duration duration = Duration.between(oldDate.atStartOfDay(), today.atStartOfDay());
        long days = duration.toDays();
        System.out.println("day difference: " + days);
    }

    @Test
    @Disabled
    public void testDayDifferenceUsingUntil() {
        LocalDate oldDate = obj.parse("12-07-2020", "dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        Period until = oldDate.until(today);
        System.out.println("day difference: " + until.getDays());
    }

    @Test
    @Disabled
    public void testDayDifferenceUsingUntilChrono() {
        LocalDate oldDate = obj.parse("18-07-2020", "dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        long until = oldDate.until(today, ChronoUnit.DAYS);
        System.out.println("day difference: " + until);
    }

    @Test
    @Disabled
    public void testYesterdayUsingOldDate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        System.out.println("yesterday date: " + calendar.getTime());
    }
}