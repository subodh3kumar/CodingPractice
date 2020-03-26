package codility.lessons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Find the missing element in a given permutation.
 */
public class PermMissingElem {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = reader.readLine().split(" ");
            int[] array = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            System.out.println(solution(array));
            System.out.println(solution2(array));
        }
    }

    private static int solution2(int[] array) {
        long startTime = System.nanoTime();
        int missingElement = array.length + 1;
        for (int i = 0; i < array.length; i++) {
            missingElement = missingElement ^ array[i] ^ (i + 1);
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution2): " + (endTime - startTime));
        return missingElement;
    }

    private static int solution(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length + 1;
        long sum = (n * (n + 1)) / 2;
        long partialSum = 0;
        for (int i = 0; i < array.length; i++) {
            partialSum += array[i];
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution): " + (endTime - startTime));
        return (int) (sum - partialSum);
    }
}
