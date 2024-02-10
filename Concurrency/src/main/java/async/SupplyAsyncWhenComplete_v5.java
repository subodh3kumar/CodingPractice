package async;

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
        System.out.println(completableFuture.get());
    }

    private static void process(String data) {
        System.out.println("process: " + Thread.currentThread().getName());
        System.out.println("process: " + data + " process");
    }

    private static String getById(int value) {
        System.out.println("getById: " + Thread.currentThread().getName());
        return "id: " + value;
    }
}
