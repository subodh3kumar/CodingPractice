package dev.subodh.venkat;

import java.util.concurrent.CompletableFuture;

public class P08_Combine {

    public static void main(String[] args) {
        create(2).thenCombine(create(3), (a, b) -> a + b)
                .thenAccept(System.out::println);
    }

    private static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> n);
    }
}
