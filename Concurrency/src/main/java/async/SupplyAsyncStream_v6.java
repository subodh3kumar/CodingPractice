package async;

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
                        System.out.println(cf.get());
                        System.out.println("------------");
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

    private static String process(String data) {
        System.out.println("process " + Thread.currentThread().getName());
        return data + " process";
    }

    private static String getId(Integer num) {
        System.out.println("getId: " + Thread.currentThread().getName());
        return "id " + num;
    }
}
