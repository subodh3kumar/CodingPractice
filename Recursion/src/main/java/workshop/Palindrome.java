package workshop;

public class Palindrome {

    public boolean palindrome(String str) {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("empty string");
        }
        int length = str.length();
        boolean isPalindrome = true;
        for (int i = 0; i < length / 2; i++) {
            if (!(str.charAt(i) == str.charAt(length - 1 - i))) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
