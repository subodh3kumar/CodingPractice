package dev.subodh.async;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo_1 {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(CompletableFutureDemo_1::message)
                .thenApply(CompletableFutureDemo_1::decorate)
                .thenAccept(CompletableFutureDemo_1::print)
                .join();
    }

    static String message() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello World";
    }

    static String decorate(String msg) {
        return msg + " !!!";
    }

    static void print(String msg) {
        System.out.println(msg);
    }
}
