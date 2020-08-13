package workshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HolidayCount {

    public static void main(String[] args) {
        List<LocalDate> holidays = new ArrayList<>();
        holidays.add(LocalDate.of(2020, 1, 1));
        holidays.add(LocalDate.of(2020, 1, 14));
        holidays.add(LocalDate.of(2020, 1, 26));
        holidays.add(LocalDate.of(2020, 8, 3));
        holidays.add(LocalDate.of(2020, 8, 15));
        holidays.add(LocalDate.of(2020, 10, 25));
        holidays.add(LocalDate.of(2020, 11, 14));

        System.out.println("total holiday count: " + holidays.size());

        LocalDate startDate = LocalDate.of(2020, 8, 1);
        LocalDate endDate = LocalDate.of(2020, 8, 31);

        int augustHolidays = getAugustHolidays(startDate, endDate, holidays);
        System.out.println("August holidays: " + augustHolidays);
    }

    private static int getAugustHolidays(LocalDate startDate, LocalDate endDate, List<LocalDate> holidays) {
        int count = 0;
        while (startDate.isBefore(endDate)) {
            if (holidays.contains(startDate)) {
                count++;
            }
            startDate = startDate.plusDays(1);
        }
        return count;
    }
}
