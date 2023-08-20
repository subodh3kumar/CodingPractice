package workshop;

import java.util.Scanner;

public class BitManipulation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a unsigned number: ");
        long num = input.nextLong();

        System.out.println("decimal value: " + num);
        System.out.println("hexadecimal value: " + Long.toHexString(num));
        System.out.println("octal value: " + Long.toOctalString(num));
        System.out.println("binary value: " + Long.toBinaryString(num));

        System.out.println("binary (num & 1): " + (num & 1));
    }
}
