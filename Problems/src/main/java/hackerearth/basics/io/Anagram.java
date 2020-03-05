package hackerearth.basics.io;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        String word1 = input.next();
        String word2 = input.next();
        input.close();

        char[] charArr1 = word1.toCharArray();
        char[] charArr2 = word2.toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        for (int i = 0; i < charArr1.length; i++) {
            System.out.print(charArr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < charArr2.length; i++) {
            System.out.print(charArr2[i] + " ");
        }
    }
}
