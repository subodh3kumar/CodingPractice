package bit;

import java.util.Scanner;

public class SwapTwoNumberWithoutTempVariable {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        input.close();
        swapUsingXOR(a, b);
        System.out.println();
        swapUsingMultiplicationAndDivision(a, b);
    }

    private static void swapUsingMultiplicationAndDivision(int a, int b) {
        System.out.println("Before swap, a=" + a + ", b=" + b);
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("After  swap, a=" + a + ", b=" + b);
    }

    private static void swapUsingXOR(int a, int b) {
        System.out.println("Before swap, a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After  swap, a=" + a + ", b=" + b);
    }
}
