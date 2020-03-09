package codility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinaryGap {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int num = Integer.parseInt(reader.readLine());
            String binary = Integer.toBinaryString(num);

            String[] array = binary.split("1", -1);
            System.out.println(binary);
            System.out.println(binary.length());
            System.out.println(binary.indexOf('1'));
            System.out.println(binary.lastIndexOf('1'));
            System.out.println(array.length + "-" + Arrays.toString(array));
            int size = array.length;
            for (int i = 0; i < size; i++) {
                if (array[i].equals("") && array[size-1].equals("")) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
