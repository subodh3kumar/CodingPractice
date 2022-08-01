package workshop.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public record Employee(long id, String name, Gender gender, LocalDate dob, double income) {

    public static List<Employee> getAllEmployees() {
        return List.of(
                new Employee(1, "Jake", Gender.MALE, LocalDate.of(1971, Month.JANUARY, 1), 2343.0),
                new Employee(2, "Jack", Gender.MALE, LocalDate.of(1972, Month.JULY, 21), 7100.0),
                new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1973, Month.MAY, 29), 5455.0),
                new Employee(4, "Jode", Gender.MALE, LocalDate.of(1974, Month.OCTOBER, 16), 1800.0),
                new Employee(5, "Jeny", Gender.FEMALE, LocalDate.of(1975, Month.DECEMBER, 13), 1234.0),
                new Employee(6, "Jason", Gender.MALE, LocalDate.of(1976, Month.JUNE, 9), 3211.0));
    }
}
