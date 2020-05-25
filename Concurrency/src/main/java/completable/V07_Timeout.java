package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class V07_Timeout {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        //future.completeOnTimeout(500, 3, TimeUnit.SECONDS);
        future.orTimeout(3, TimeUnit.SECONDS);

        process(future);

        Thread.sleep(2000);
        //future.complete(2);
        future.completeExceptionally(new RuntimeException("something went wrong"));
        Thread.sleep(5000);
    }

    private static void process(CompletableFuture<Integer> future) {
        future.exceptionally(throwable -> handle(throwable))
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);
    }

    private static int handle(Throwable throwable) {
        System.out.println("ERROR: " + throwable);
        //return 100;
        throw new RuntimeException("This is beyond any repair");
    }
}
