package oneD;

import java.security.SecureRandom;

public class RandomIntegerArray10M {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = 10 + random.nextInt(100);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
