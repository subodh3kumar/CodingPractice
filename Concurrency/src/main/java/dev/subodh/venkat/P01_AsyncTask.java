package dev.subodh.venkat;

import java.util.concurrent.CompletableFuture;

public class P01_AsyncTask {

    public static void main(String[] args) throws InterruptedException {
        IO.println("main(1): " + Thread.currentThread());
        CompletableFuture<Integer> cf = create();
        Thread.sleep(1000);
        cf.thenAccept(P01_AsyncTask::printIt);
        Thread.sleep(1000);
        IO.println("main(2): " + Thread.currentThread());
    }

    private static void printIt(Integer data) {
        IO.println("printIt(): " + Thread.currentThread());
        IO.println(data);
    }

    private static CompletableFuture<Integer> create() {
        IO.println("create(): " + Thread.currentThread());
        return CompletableFuture.supplyAsync(P01_AsyncTask::compute);
    }

    private static int compute() {
        IO.println("compute(): " + Thread.currentThread());
        return 2;
    }
}
