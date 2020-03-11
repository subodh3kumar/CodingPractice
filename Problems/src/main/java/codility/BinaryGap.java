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
            int num = Integer.parseInt(reader.readLine());
            int result = solution(num);
            System.out.println(result);
        }
    }

    private static int solution(int num) {
        String binary = Integer.toBinaryString(num);
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
        return result;
    }
}
