package workshop;

import java.util.Scanner;

public class BitManipulation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a unsigned number: ");
        int num = input.nextInt();

        System.out.println("decimal value: " + num);
        System.out.println("hexadecimal value: " + Integer.toHexString(num));
        System.out.println("octal value: " + Integer.toOctalString(num));
        System.out.println("binary value: " + Integer.toBinaryString(num));
    }
}
