package workshop.recursive;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Permutation {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    //@Disabled
    public void perm1() {
        perm1(alphabet.substring(0, 3));
        //perm1("1122");
    }

    private void perm1(String word) {
        perm1("", word);
    }

    private void perm1(String prefix, String word) {
        int length = word.length();
        if (length == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < length; i++) {
            perm1(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1, length));
        }
    }

    @Test
    @Disabled
    public void perm2() {
        perm2(alphabet.substring(0, 3));
    }

    private void perm2(String word) {
        char[] chars = word.toCharArray();
        perm2(chars, chars.length);
    }

    private void perm2(char[] chars, int length) {
        if (length == 1) {
            System.out.println(new String(chars));
            return;
        }
        for (int i = 0; i < length; i++) {
            swap(chars, i, length - 1);
            perm2(chars, length - 1);
            swap(chars, i, length - 1);
        }
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }
}
