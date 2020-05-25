package completable;

import java.util.concurrent.CompletableFuture;

public class V05_ApplyAccept {

    public static void main(String[] args) {
        create().thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(data -> printIt(data));
    }

    private static void printIt(Integer data) {
        System.out.println(data);
    }

    private static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private static int compute() {
        return 2;
    }
}
