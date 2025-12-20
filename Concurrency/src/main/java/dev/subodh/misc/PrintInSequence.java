package dev.subodh.misc;

public class PrintInSequence {

    static void main() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.println("Thread 1: " + i);
                synchronized (PrintInSequence.class) {
                    PrintInSequence.class.notify();
                    try {
                        if (i < 26) {
                            PrintInSequence.class.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 'A'; i <= 'Z'; i++) {
                synchronized (PrintInSequence.class) {
                    System.out.println("Thread 2: " + (char) i);
                    PrintInSequence.class.notify();
                    try {
                        if (i < 'Z') {
                            PrintInSequence.class.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
