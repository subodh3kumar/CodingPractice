package workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubStringTest {

    @Test
    @Disabled
    public void substring1() {
        String word = "3518493_LNBR";
        System.out.println(word.substring(0, word.length() - 5));
    }

    @Test
    @Disabled
    public void substring2() {
        String str = "abc";
        for (int i = 0; i < str.length(); i++) {
            System.out.println("|" + str.substring(0, i) + "|");
        }
    }

    @Test
    @Disabled
    public void testRepeat() {
        String placeholder = "?, ";
        String repeat = placeholder.repeat(21).strip();
        repeat = repeat.substring(0, repeat.length() - 1);
        System.out.println(repeat);
    }

    @Test
    public void testStringRepetitionUsingGenerate() {
        String collect = Stream.generate(() -> "?")
                .limit(3)
                .collect(Collectors.joining(", "));
        Assertions.assertEquals("?, ?, ?", collect);
    }

    @Test
    public void testStringRepetitionUsingJoin() {
        String join = String.join(", ", Collections.nCopies(3, "?"));
        Assertions.assertEquals("?, ?, ?", join);
    }
}
