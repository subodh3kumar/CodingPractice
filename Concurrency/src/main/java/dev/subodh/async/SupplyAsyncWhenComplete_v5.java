package dev.subodh.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncWhenComplete_v5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> getById(10))
                .whenComplete((data, error) -> {
                    process(data);
                    if (error != null) {
                        System.err.println(error);
                    }
                });
        IO.println(completableFuture.get());
    }

    private static void process(String data) {
        IO.println("process: " + Thread.currentThread().getName());
        IO.println("process: " + data + " process");
    }

    private static String getById(int value) {
        IO.println("getById: " + Thread.currentThread().getName());
        return "id: " + value;
    }
}
