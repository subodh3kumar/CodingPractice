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
        boolean isPalindrome = obj.palindrome("121");
        Assertions.assertTrue(isPalindrome);

        isPalindrome = obj.palindrome("1211");
        Assertions.assertFalse(isPalindrome);

        isPalindrome = obj.palindrome("radar");
        Assertions.assertTrue(isPalindrome);

        isPalindrome = obj.palindrome("12321");
        Assertions.assertTrue(isPalindrome);
    }
}