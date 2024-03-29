package venkat;

import java.util.concurrent.CompletableFuture;

public class P04_Exceptionally {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        process(future);
        //future.complete(2);
        //future.completeExceptionally(new RuntimeException("something went wrong"));
    }

    private static void process(CompletableFuture<Integer> future) {
        future.exceptionally(P04_Exceptionally::handle)
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
