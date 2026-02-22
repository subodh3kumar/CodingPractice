package dev.subodh.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncStream_v6 {

    public static void main(String[] args) {
        List<Integer> values = List.of(5, 4, 8, 9, 1, 7, 3);

        values.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> getId(n)))
                .map(cf -> cf.thenApply(SupplyAsyncStream_v6::process))
                .forEach(cf -> {
                    try {
                        IO.println(cf.get());
                        IO.println("------------");
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

    private static String process(String data) {
        IO.println("process " + Thread.currentThread().getName());
        return data + " process";
    }

    private static String getId(Integer num) {
        IO.println("getId: " + Thread.currentThread().getName());
        return "id " + num;
    }
}
