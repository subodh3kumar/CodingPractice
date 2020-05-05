package codility.lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L06_TapeEquilibrium {

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 4, 3};
        System.out.println(solution(array));
        System.out.println(solution2(array));
    }

    private static int solution2(int[] array) {
        long startTime = System.nanoTime();
        int leftSum = 0;
        int rightSum = 0;
        int min = Integer.MAX_VALUE;

        int total = Arrays.stream(array).sum();

        for (int i = 1; i < array.length; i++) {
            leftSum += array[i - 1];
            rightSum = total - leftSum;
            min = Math.min(min, Math.abs(rightSum - leftSum));
        }

        long endTime = System.nanoTime();
        System.out.println("time taken(2): " + (endTime - startTime) + " ns");
        return min;
    }

    private static int solution(int[] array) {
        long startTime = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        for (int index = 1; index <= array.length - 1; index++) {
            int leftSum = leftSum(index, array);
            int rightSum = rightSum(index, array);
            list.add(Math.abs(leftSum - rightSum));
        }
        int result = list.stream().min(Integer::compareTo).get();
        long endTime = System.nanoTime();
        System.out.println("time taken: " + (endTime - startTime) + " ns");
        return result;
    }

    private static int leftSum(int index, int[] array) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static int rightSum(int index, int[] array) {
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
