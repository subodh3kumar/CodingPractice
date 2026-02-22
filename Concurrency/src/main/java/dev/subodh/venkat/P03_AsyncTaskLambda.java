package dev.subodh.venkat;

import java.util.concurrent.CompletableFuture;

public class P03_AsyncTaskLambda {

    public static void main(String[] args) throws InterruptedException {
        IO.println("main(): " + Thread.currentThread());

        startAsyncTask(); // this is non-blocking

        IO.println("end: " + Thread.currentThread());
        Thread.sleep(2000);
    }

    private static void startAsyncTask() {
        CompletableFuture.runAsync(() -> IO.println("running little task: " + Thread.currentThread()));
    }
}
