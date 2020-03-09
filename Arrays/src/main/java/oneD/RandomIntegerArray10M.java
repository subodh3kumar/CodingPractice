package oneD;

import java.security.SecureRandom;

public class RandomIntegerArray10M {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[] array = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            array[i] = 1 + random.nextInt(9999999);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
