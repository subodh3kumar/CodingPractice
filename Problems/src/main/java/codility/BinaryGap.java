package codility;
/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros
 * that is surrounded by ones at both ends in the binary representation of N.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryGap {

    public static void main(String[] args) throws Exception {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(reader.readLine()); // 529, 32, 1041
            String binary = Integer.toBinaryString(num);

            System.out.println(solution(binary));
            System.out.println(solution2(binary));
        }
    }

    private static int solution(String binary) {
        long startTime = System.nanoTime();
        int first = binary.indexOf('1');
        int last = binary.lastIndexOf('1');
        int result = 0;
        if (last > first) {
            binary = binary.substring(first, last + 1);
            String[] array = binary.split("1", -1);
            for (int i = 0; i < array.length; i++) {
                int size = array[i].length();
                if (size > result) {
                    result = size;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution): " + (endTime - startTime));
        return result;
    }

    private static int solution2(String binary) {
        long startTime = System.nanoTime();
        int length = 0;
        int index = 0;
        for (int i = 0; i < binary.length(); i = index) {
            int start = binary.indexOf('0', index);
            if (start < 0) {
                break;
            }
            int end = binary.indexOf('1', start) - 1;
            if (end < 0) {
                break;
            }
            int temp = end - start + 1;
            if (temp > length) {
                length = temp;
            }
            index = end + 1;
        }
        long endTime = System.nanoTime();
        System.out.println("elapsedTime in nano second (solution2): " + (endTime - startTime));
        return length;
    }
}
