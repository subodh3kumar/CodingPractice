package venkat;

import java.util.concurrent.CompletableFuture;

public class P01_AsyncTask {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main(1): " + Thread.currentThread());
        CompletableFuture<Integer> cf = create();
        Thread.sleep(1000);
        cf.thenAccept(P01_AsyncTask::printIt);
        Thread.sleep(1000);
        System.out.println("main(2): " + Thread.currentThread());
    }

    private static void printIt(Integer data) {
        System.out.println("printIt(): " + Thread.currentThread());
        System.out.println(data);
    }

    private static CompletableFuture<Integer> create() {
        System.out.println("create(): " + Thread.currentThread());
        return CompletableFuture.supplyAsync(P01_AsyncTask::compute);
    }

    private static int compute() {
        System.out.println("compute(): " + Thread.currentThread());
        return 2;
    }
}
