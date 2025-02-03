package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PermutationTest {

    private Permutation permutation;

    @BeforeEach
    public void setUp() {
        permutation = new Permutation();
    }

    @Test
    public void testPerm1() {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String word = alphabet.substring(0, 3);
        List<String> strings = permutation.perm1(word);
        System.out.println("strings: " + strings);
        Assertions.assertEquals(6, strings.size());
    }

    @Test
    public void testPerm2() {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String word = alphabet.substring(0, 3);
        List<String> strings = permutation.perm2(word);
        System.out.println("strings: " + strings);
        Assertions.assertEquals(6, strings.size());
    }
}