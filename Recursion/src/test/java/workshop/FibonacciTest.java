package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    private Fibonacci obj;

    @BeforeEach
    public void setUp() {
        obj = new Fibonacci();
    }

    @Test
    public void testNthFibonacci() {
        int nthFibonacci = obj.nthFibonacci(5);
        System.out.println("nthFibonacci: " + nthFibonacci);
        Assertions.assertEquals(8, nthFibonacci);
    }
}