package venkat;

import java.util.concurrent.CompletableFuture;

public class P05_ApplyAccept {

    public static void main(String[] args) {
        create().thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(P05_ApplyAccept::printIt);
    }

    private static void printIt(Integer data) {
        System.out.println(data);
    }

    private static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(P05_ApplyAccept::compute);
    }

    private static int compute() {
        return 2;
    }
}
