package workshop.venkat;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class MultipleShareSubscriber {

    public static void main(String[] args) {
        Flowable<Long> feed = Flowable.interval(1, 1, TimeUnit.SECONDS).share();

        feed.subscribe(data -> process("S1: " + data));
        sleep(5000);
        feed.subscribe(data -> process("S2: " + data));

        sleep(10000);
    }

    private static void process(String msg) {
        System.out.println(msg);
    }

    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
