import org.junit.jupiter.api.Test;

public class CodePointMethodTest {

    @Test
    public void codePointsMethod() {
        String text = "hello";
        text.codePoints().forEach(System.out::println);
    }

    @Test
    public void codePointBeforeMethod() {
        String text = "hello";
        System.out.println(text.codePointBefore(1));
        System.out.println(text.codePointBefore(0));
    }

    @Test
    public void codePointCountMethod() {
        String text = "hello";
        System.out.println(text.codePointCount(0, 3));
        System.out.println(text.codePointCount(1, 3));
        System.out.println(text.codePointCount(2, 3));
        System.out.println(text.codePointCount(3, 1));
    }

    @Test
    public void codePointAtMethod() {
        String name = "subodh";
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.codePointAt(i));
        }
        System.out.println("--------");
        System.out.println(name.codePointAt(-1)); // StringIndexOutOfBoundsException
    }
}
