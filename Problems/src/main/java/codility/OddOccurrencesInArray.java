package codility;

import java.util.*;

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of
 * elements, and each element of the array can be paired with another element that has the same
 * value, except for one element that is left unpaired, return the value of the unpaired element.
 */
public class OddOccurrencesInArray {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        String[] strings = str.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        int result = solution(array);
        System.out.println(result);
    }

    private static int solution(int[] array) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 != 0) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("No odd value available");
    }
}
