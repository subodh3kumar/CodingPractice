package workshop;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private List<String> permutations;

    public List<String> perm1(String str) {
        permutations = new ArrayList<>();
        perm1("", str);
        return permutations;
    }

    private void perm1(String prefix, String str) {
        int length = str.length();
        if (length == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                perm1(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, length));
            }
        }
    }

    public List<String> perm2(String word) {
        permutations = new ArrayList<>();
        int length = word.length();
        char[] chars = word.toCharArray();
        perm2(chars, length);
        return permutations;
    }

    private void perm2(char[] chars, int length) {
        if (length == 1) {
            permutations.add(new String(chars));
        } else {
            for (int i = 0; i < length; i++) {
                swap(chars, i, length - 1);
                perm2(chars, length - 1);
                swap(chars, i, length - 1);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
