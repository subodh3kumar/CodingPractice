package completable.venkat;

import java.util.concurrent.CompletableFuture;

public class P03_AsyncTaskLambda {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main(): " + Thread.currentThread());

        startAsyncTask(); // this is non-blocking

        System.out.println("end: " + Thread.currentThread());
        Thread.sleep(2000);
    }

    private static void startAsyncTask() {
        CompletableFuture.runAsync(() -> System.out.println("running little task: " + Thread.currentThread()));
    }
}
