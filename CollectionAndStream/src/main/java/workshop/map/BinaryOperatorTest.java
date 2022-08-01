package workshop.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import workshop.model.Employee;
import workshop.model.Gender;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BinaryOperatorTest {

    @Test
    public void testGenderMap() {
        List<Employee> employees = Employee.getAllEmployees();
        Map<Gender, String> genderMap = employees.stream()
                .collect(Collectors.toMap(Employee::gender, Employee::name, (oldValue, newValue) -> String.join(",", oldValue, newValue)));
        System.out.println(genderMap);
        Assertions.assertEquals(2, genderMap.size());
    }

    @Test
    public void testSimpleMap() {
        List<String> fruits = List.of("apple", "banana", "orange");
        Map<Character, String> fruitMap = fruits.stream().collect(Collectors.toMap(fruit -> fruit.charAt(0), fruit -> fruit));
        System.out.println(fruitMap);
        Assertions.assertEquals(3, fruitMap.size());
    }

    @Test
    public void testBinaryOperatorMap() {
        List<String> fruits = List.of("apple", "banana", "apricot", "orange");
        Map<Character, String> fruitMap = fruits.stream()
                .collect(Collectors.toMap(fruit -> fruit.charAt(0), fruit -> fruit, (fruit1, fruit2) -> fruit1 + "|" + fruit2));
        System.out.println(fruitMap);
        Assertions.assertEquals(3, fruitMap.size());
    }

    @Test
    public void testSupplierMap() {
        List<String> fruits = List.of("apple", "banana", "apricot", "orange");
        LinkedHashMap<Character, String> fruitMap = fruits.stream()
                .collect(Collectors.toMap(fruit -> fruit.charAt(0),
                        fruit -> fruit,
                        (fruit1, fruit2) -> fruit1 + "|" + fruit2,
                        LinkedHashMap::new));

        System.out.println(fruitMap);
        Assertions.assertEquals(3, fruitMap.size());
    }
}
