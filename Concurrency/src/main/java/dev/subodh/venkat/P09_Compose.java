package dev.subodh.venkat;

import java.util.concurrent.CompletableFuture;

public class P09_Compose {

    public static void main(String[] args) {
        create(2).thenCompose(P09_Compose::create)
                .thenAccept(System.out::println);
    }

    private static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> n);
    }
}
