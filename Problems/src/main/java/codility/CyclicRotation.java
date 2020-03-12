package codility;

import java.util.Arrays;
import java.util.Scanner;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element
 * is shifted right by one index, and the last element of the array is moved to the first place.
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
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
