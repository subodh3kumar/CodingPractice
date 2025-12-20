package dev.subodh.misc;

public class PrintInSequence2 {

    static void main() {
        Runnable a = () -> {
            for (int i = 1; i < 27; i++) {
                IO.println("Thread-1: " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    IO.println("Interrupted Exception in A");
                }
            }
        };
        Runnable b = () -> {
            for (char i = 'A'; i <= 'Z'; i++) {
                IO.println("Thread-2: " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    IO.println("Interrupted Exception in B");
                }
            }
        };
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }
}
