package workshop;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SubStringTest {

    @Test
    @Disabled
    public void substring1() {
        String word = "3518493_LNBR";
        System.out.println(word.substring(0, word.length() - 5));
    }

    @Test
    public void substring2() {
        String str = "abc";
        for (int i = 0; i < str.length(); i++) {
            System.out.println("|" + str.substring(0, i) + "|");
        }
    }
}
