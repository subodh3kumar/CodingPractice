package methods;

import org.junit.jupiter.api.Test;

public class StringMethodTest {

    @Test
    public void testSubString() {
        String word = "3518493_LNBR";
        System.out.println(word.substring(0, word.length() - 5));
    }
}
