package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncThenApply_v3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> valueCompletableFuture = CompletableFuture.supplyAsync(() -> getById(10))
                .thenApply(SupplyAsyncThenApply_v3::process);

        String result = valueCompletableFuture.get();
        System.out.println(result);
    }

    private static String process(String data) {
        System.out.println("process: " + Thread.currentThread().getName());
        return data + " processed";
    }

    private static String getById(int id) {
        System.out.println("getById: " + Thread.currentThread().getName());
        return "id: " + id;
    }
}
