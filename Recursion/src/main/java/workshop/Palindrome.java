package workshop;

public class Palindrome {

    public int palindrome(int number) {
        if (number <= 1) {
            return 1;
        }
        return palindrome(number - 1) + palindrome(number - 2);
    }
}
