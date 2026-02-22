package dev.subodh.venkat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class P02_AsyncTaskForkJoinPool {

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(10);

    public static void main(String[] args) throws InterruptedException {
        IO.println("main(): " + Thread.currentThread());
        create().thenAccept(P02_AsyncTaskForkJoinPool::printIt);
    }

    private static void printIt(Integer data) {
        IO.println("printIt(): " + Thread.currentThread());
        IO.println(data);
    }

    private static CompletableFuture<Integer> create() {
        IO.println("create(): " + Thread.currentThread());
        return CompletableFuture.supplyAsync(P02_AsyncTaskForkJoinPool::compute, forkJoinPool);
    }

    private static int compute() {
        IO.println("compute(): " + Thread.currentThread());
        return 2;
    }
}
