package workshop.annotation;

public class App {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long result = 0;
        for (long i = 1; i <= 100000000; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " in " + (end - start) + " ms");
    }
}
