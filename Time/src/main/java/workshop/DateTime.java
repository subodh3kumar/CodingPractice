package workshop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public LocalDate parse(String strDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(strDate, formatter);
    }
}
