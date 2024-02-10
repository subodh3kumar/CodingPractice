package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SupplyAsyncThenCombine_v1 {

    public static void main(String[] args) {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(SupplyAsyncThenCombine_v1::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(SupplyAsyncThenCombine_v1::world);

        CompletableFuture<String> helloWorld = hello.thenCombine(world, (msg1, msg2) -> msg1 + " " + msg2);

        try {
            System.out.println(helloWorld.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static String world() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "World";
    }

    private static String hello() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello";
    }
}
