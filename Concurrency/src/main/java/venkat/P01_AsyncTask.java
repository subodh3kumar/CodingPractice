package venkat;

import java.util.concurrent.CompletableFuture;

public class P01_AsyncTask {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main(): " + Thread.currentThread());
        CompletableFuture<Integer> cf = create();
        Thread.sleep(1000);
        cf.thenAccept(data -> printIt(data));
        Thread.sleep(1000);
    }

    private static void printIt(Integer data) {
        System.out.println("printIt(): " + Thread.currentThread());
        System.out.println(data);
    }

    private static CompletableFuture<Integer> create() {
        System.out.println("create(): " + Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private static int compute() {
        System.out.println("compute(): " + Thread.currentThread());
        return 2;
    }
}
