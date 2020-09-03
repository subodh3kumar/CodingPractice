package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class V02_AsyncTaskForkJoinPool {

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(10);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main(): " + Thread.currentThread());
        create().thenAccept(data -> printIt(data));
    }

    private static void printIt(Integer data) {
        System.out.println("printIt(): " + Thread.currentThread());
        System.out.println(data);
    }

    private static CompletableFuture<Integer> create() {
        System.out.println("create(): " + Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> compute(), forkJoinPool);
    }

    private static int compute() {
        System.out.println("compute(): " + Thread.currentThread());
        return 2;
    }
}
