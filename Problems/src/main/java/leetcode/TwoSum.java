package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] array = {2, 7, 11, 15, 6, 9, 15, 4, 3};
            int target = Integer.parseInt(reader.readLine());
            int[] index = twoSum(array, target);
            System.out.println(Arrays.toString(index));
        }
    }

    private static int[] twoSum(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
