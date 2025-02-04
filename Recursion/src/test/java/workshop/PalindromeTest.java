package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    private Palindrome obj;

    @BeforeEach
    public void setUp() {
        obj = new Palindrome();
    }

    @Test
    public void testPalindrome() {
        int palindrome = obj.palindrome(5);
        System.out.println("palindrome value: " + palindrome);
        Assertions.assertEquals(8, palindrome);
    }
}