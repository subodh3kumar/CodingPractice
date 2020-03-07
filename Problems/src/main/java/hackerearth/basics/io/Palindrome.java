package hackerearth.basics.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String word = reader.readLine();
            int size = word.length();
            boolean isPalindrome = true;
            for (int i = 0; i < size / 2; i++) {
                if (!(word.charAt(i) == word.charAt(size - 1))) {
                    isPalindrome = false;
                    break;
                }
                size--;
            }
            System.out.println((isPalindrome == true) ? "YES" : "NO");
        }
    }
}
