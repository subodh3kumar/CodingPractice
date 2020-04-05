package methods;

public class CodePointMethods {

    public static void main(String[] args) {
        codePointAtMethod();
        codePointCountMethod();
        codePointBeforeMethod();
        codePointsMethod();
    }

    private static void codePointsMethod() {
        String text = "hello";
        text.codePoints().forEach(System.out::println);
    }

    private static void codePointBeforeMethod() {
        String text = "hello";
        System.out.println(text.codePointBefore(1));
        System.out.println(text.codePointBefore(0));
    }

    private static void codePointCountMethod() {
        String text = "hello";
        System.out.println(text.codePointCount(0, 3));
        System.out.println(text.codePointCount(1, 3));
        System.out.println(text.codePointCount(2, 3));
        System.out.println(text.codePointCount(3, 1));
    }

    private static void codePointAtMethod() {
        String name = "subodh";
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.codePointAt(i));
        }
        System.out.println("--------");
        System.out.println(name.codePointAt(-1));
    }
}
