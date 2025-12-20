package dev.subodh.spilca.ex2;

public class OddNumberRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 11; i += 2) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
