package bits;

import java.util.Scanner;

public class SumWithoutPlusOperator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        input.close();
        System.out.println("recursive add: " + addRecursive(a, b));
        System.out.println("iterative add: " + addIterative(a, b));
    }

    private static int addRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b; // sum of two integer is A XOR B
        int carry = (a & b) << 1;  // carry of two integer is A AND B
        return addRecursive(sum, carry);
    }

    private static int addIterative(int a, int b) {
        while (b != 0) {
            int carry = (a & b); // carry is tow integer is A AND B
            a = a ^ b; // sum of two bits is A XOR B
            b = carry << 1; // shifts carry to 1 bit to calculate sum
        }
        return a;
    }
}
