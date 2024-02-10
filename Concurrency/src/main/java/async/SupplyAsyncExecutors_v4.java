package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsyncExecutors_v4 {

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
                    () -> getId(10), executorService
            ).thenApply(SupplyAsyncExecutors_v4::process);

            String msg = completableFuture.get();
            System.out.println(msg);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String process(String msg) {
        System.out.println("process: " + Thread.currentThread().getName());
        return msg + " process";
    }

    private static String getId(int num) {
        System.out.println("getId: " + Thread.currentThread().getName());
        return "id " + num;
    }
}
