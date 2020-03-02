package hackerearth.basics.io;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int range = input.nextInt();
        input.close();

        int num = 1;

        while (num <= range) {
            if (isPrime(num) && num != 1) {
                System.out.print(num + " ");
            }
            num++;
        }
        System.out.println();
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
