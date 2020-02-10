import java.util.Arrays;
import java.util.List;

public class IntListToArray {

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // List<Integer>
        listToArray(numbers);
    }

    private static void listToArray(List<Integer> numbers) {
        int[] array = numbers.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(array).forEach(System.out::println);
    }
}
