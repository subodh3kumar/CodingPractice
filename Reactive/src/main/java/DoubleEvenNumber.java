import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class DoubleEvenNumber {

    public static void main(String[] args) {
        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .filter(e -> isEven(e))
                .map(e -> e * 2)
                .subscribe(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isEven(Long n) {
        return n % 2 == 0;
    }
}
