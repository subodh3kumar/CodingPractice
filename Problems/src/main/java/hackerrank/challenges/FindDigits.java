package hackerrank.challenges;

import java.util.Scanner;

public class FindDigits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int digits = findDigits(num);
        System.out.println(digits);
    }

    private static int findDigits(int num) {
        int[] array = Integer.toString(num).chars().map(ch -> ch - '0').toArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && num % array[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
