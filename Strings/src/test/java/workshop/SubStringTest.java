package workshop;

import org.junit.jupiter.api.Test;

public class SubStringTest {

    @Test
    public void testSubString() {
        String word = "3518493_LNBR";
        System.out.println(word.substring(0, word.length() - 5));
    }
}
