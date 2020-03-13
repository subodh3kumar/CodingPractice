package codility;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Rotate an array to the right by a given number of steps.
 */
public class CyclicRotation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine(); // 3 8 9 7 6, 3
        int num = input.nextInt();
        input.close();

        String[] strings = str.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(Arrays.toString(solution(array, num)));
    }

    private static int[] solution(int[] array, int num) {
        long startTime = System.nanoTime();
        int size = array.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int remainder = (i + num) % size;
            result[remainder] = array[i];
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution): " + (endTime - startTime));
        return result;
    }
}
