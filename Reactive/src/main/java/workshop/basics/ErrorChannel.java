package workshop.basics;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ErrorChannel {

    public static void main(String[] args) {
        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .map(e -> transform(e))
                .subscribe(System.out::println, error -> System.out.println("ERROR: " + error));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long transform(long data) {
        if (data == 5) {
            throw new RuntimeException("something went wrong.");
        }
        return data;
    }
}
