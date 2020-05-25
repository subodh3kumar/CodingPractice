package io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SwapTwoNumberTest {

    @Test
    @DisplayName("swap using operator")
    public void swapUsingMultiplicationAndDivision() {
        int a = 10;
        int b = 20;
        System.out.println("Before swap, a=" + a + ", b=" + b);
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("After  swap, a=" + a + ", b=" + b);
    }

    @Test
    @DisplayName("swap using XOR")
    public void swapUsingXOR() {
        int a = 10;
        int b = 20;
        System.out.println("Before swap, a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After  swap, a=" + a + ", b=" + b);
    }

    @Test
    @DisplayName("swap using temp variable")
    public void swapUsingTempVariable() {
        int a = 10;
        int b = 20;
        System.out.println("Before swap, a=" + a + ", b=" + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After  swap, a=" + a + ", b=" + b);
    }
}