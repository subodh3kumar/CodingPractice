package dev.subodh.async;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncExceptionally_v2 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter divisor: ");
            int divisor = input.nextInt();

            CompletableFuture<String> valueFuture = CompletableFuture.supplyAsync(() -> String.valueOf(100 / divisor))
                    .exceptionally(Throwable::getLocalizedMessage);

            String result = valueFuture.get();
            System.out.println("value: " + result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
