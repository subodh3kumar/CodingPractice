package workshop.basics;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AsyncComputation {

    public static void main(String[] args) {
        Flowable.<Integer>create(emitter -> emit(emitter), BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.computation(), true, 2)
                .map(data -> data * 1)
                .subscribe(AsyncComputation::process,
                        error -> System.out.println("ERROR: " + error),
                        () -> System.out.println("DONE"));

        sleep(10000);
    }

    private static void process(int value) {
        System.out.println("Consumer: " + value);
        sleep(1000);
    }

    private static void emit(FlowableEmitter<Integer> emitter) {
        int count = 0;

        while (count < 10) {
            count++;

            System.out.println("Producer: " + count);

            emitter.onNext(count);
            sleep(500);
        }
        emitter.onComplete();
    }

    public static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
