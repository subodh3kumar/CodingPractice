package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    private Factorial obj;

    @BeforeEach
    public void setUp() {
        obj = new Factorial();
    }

    @Test
    public void testFactorial() {
        int factorial = obj.factorial(5);
        System.out.println("factorial: " + factorial);
        Assertions.assertEquals(120, factorial);
    }
}