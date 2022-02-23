package workshop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CodePointTest {

    @Test
    void codePointsMethod() {
        final var intStream = "hello".codePoints();
        final var ints = intStream.toArray();
        Assertions.assertThat(ints[0]).isEqualTo(104);
        Assertions.assertThat(ints[1]).isEqualTo(101);
    }

    @Test
    @Disabled
    void codePointBeforeMethod() {
        String text = "hello";
        System.out.println(text.codePointBefore(1));
        //System.out.println(text.codePointBefore(0));
    }

    @Test
    @Disabled
    void codePointCountMethod() {
        String text = "hello";
        System.out.println(text.codePointCount(0, 3));
        System.out.println(text.codePointCount(1, 3));
        System.out.println(text.codePointCount(2, 3));
        //System.out.println(text.codePointCount(3, 1));
    }

    @Test
    @Disabled
    void codePointAtMethod() {
        String name = "subodh";
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.codePointAt(i));
        }
        System.out.println("--------");
        //System.out.println(name.codePointAt(-1)); // StringIndexOutOfBoundsException
    }
}
