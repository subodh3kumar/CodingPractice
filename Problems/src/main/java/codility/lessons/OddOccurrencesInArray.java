package codility.lessons;

import java.util.*;

/**
 * Find value that occurs in odd number of elements.
 */
public class OddOccurrencesInArray {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine(); // 9 3 9 3 9 7 9
        input.close();

        String[] strings = str.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(solution(array));
        System.out.println(solution2(array));
        System.out.println(solution3(array));
        System.out.println(solution4(array));
    }

    private static int solution4(int[] array) {
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    array[i] = -1;
                    array[j] = -1;
                    j = array.length;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                result = array[i];
            }
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution4): " + (endTime - startTime));
        return result;
    }

    private static int solution3(int[] array) {
        long startTime = System.nanoTime();
        HashSet<Integer> duplicates = new HashSet<>();
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (duplicates.add(array[i])) {
                result = array[i];
            }
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution3): " + (endTime - startTime));
        return result;
    }

    private static int solution2(int[] array) {
        long startTime = System.nanoTime();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution2): " + (endTime - startTime));
        return result;
    }

    private static int solution(int[] array) throws Exception {
        long startTime = System.nanoTime();
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
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 != 0) {
                result = entry.getKey();
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution): " + (endTime - startTime));
        return result;
    }
}
